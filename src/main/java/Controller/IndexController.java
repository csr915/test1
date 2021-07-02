package Controller;

import Dao.entity.*;
import Service.*;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping(value = "/index")
public class IndexController {
    @Autowired
    private GameService gameService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    private String orderID="";
    @RequestMapping("")
    public String index(HttpServletRequest req, Model model){
        List<Game> games = gameService.gameList();
        model.addAttribute("games",games);
        model.addAttribute("title","");
        model.addAttribute("type","");
        return "index";
    }

    @RequestMapping("search")
    public String search(HttpServletRequest req, Model model){
        String game_title = req.getParameter("game_title");
        String game_type = req.getParameter("game_type");
        Game game = new Game();
        game.setGame_title(game_title);
        game.setGame_type(game_type);
        List<Game> games = gameService.search(game);
        model.addAttribute("games",games);
        model.addAttribute("title",game_title);
        model.addAttribute("type",game_type);
        return "index";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request,Model model){
        Integer id = Integer.valueOf(request.getParameter("id"));
        gameService.delete(id);
        List<Game> games = gameService.gameList();
        model.addAttribute("games",games);
        return "index";
    }

    @RequestMapping("goodList")
    @ResponseBody
    public String goodList(){
        Map<String,Object> r = new HashMap<>();
        List<Good> goods = goodService.goods();
        r.put("goods",goods);
        return JSON.toJSONString(r);
    }

    @RequestMapping("addcart")
    @ResponseBody
    public String addcart(HttpServletRequest request){
        Map<String,Object> r = new HashMap<>();
        int id = Integer.parseInt(request.getParameter("id"));
        Cart cart = new Cart();
        cart.setGood_id(id);
        Good good = goodService.cartgoods(id);
        cart.setGood_title(good.getTitle());
        cart.setUser_id(1);
        cart.setGood_num(1);
        if (cartService.insert(cart)){
            r.put("msg","添加购物车成功");
            r.put("code",0);
        }
        else {
            r.put("msg","添加购物车失败");
            r.put("code",1);
        }



        return JSON.toJSONString(r);
    }

    @RequestMapping("cart")
    @ResponseBody
    public String cart(){
        Map<String,Object> r = new HashMap<>();
        List<Cart> cartList = cartService.carts(1);

        List<Good> goods = goodService.cart(cartList);
        r.put("goods",goods);
        return JSON.toJSONString(r);
    }

    @RequestMapping("deletecart")
    @ResponseBody
    public String deletcart(HttpServletRequest request){
        Map<String,Object> r = new HashMap<>();
        int id = Integer.parseInt(request.getParameter("id"));
        if (cartService.delete(id,1)){
            r.put("msg","删除购物车成功");
            r.put("code",0);
        }
        else {
            r.put("msg","删除购物车失败");
            r.put("code",1);
        }



        return JSON.toJSONString(r);
    }

    @RequestMapping("addcartnum")
    @ResponseBody
    public String addnum(HttpServletRequest request){
        Map<String,Object> r = new HashMap<>();
        int id = Integer.parseInt(request.getParameter("id"));
        int num = Integer.parseInt(request.getParameter("num"));
        Cart cart = new Cart();
        cart.setUser_id(1);
        cart.setGood_id(id);
        cart.setGood_num(num);
        if (cartService.update(cart)){
            r.put("msg","成功");
            r.put("code",0);
        }
        else {
            r.put("msg","失败");
            r.put("code",1);
        }



        return JSON.toJSONString(r);
    }

    @RequestMapping("deleteall")
    @ResponseBody
    public String deleteall(HttpServletRequest request){
        Map<String,Object> r = new HashMap<>();

        if (cartService.deleteall()){
            r.put("msg","成功");
            r.put("code",0);
        }
        else {
            r.put("msg","失败");
            r.put("code",1);
        }



        return JSON.toJSONString(r);
    }


    @RequestMapping("addprice")
    @ResponseBody
    public String addprice(HttpServletRequest request){
        Map<String,Object> r = new HashMap<>();
        String price = request.getParameter("price");
        Order order =new Order();
        Date date = new Date();
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmss");
        order.setDate(sdf1.format(date));
        order.setOrderID(sdf1.format(date));
        order.setPrice(Integer.valueOf(price));
        order.setUser_id(1);
        orderID=order.getOrderID();
        orderService.insert(order);
        r.put("msg","成功");
        return JSON.toJSONString(r);
    }
    @RequestMapping("addorder")
    @ResponseBody
    public String addorder(HttpServletRequest request){
        Map<String,Object> r = new HashMap<>();
        String[] chooseId = request.getParameterValues("ChooseIds");


        Order order = orderService.findOrder(orderID);

        for (String id:chooseId
             ) {
            Integer good_id =Integer.valueOf(id);
            Cart cart =cartService.Findcart(good_id,1);
            cartService.delete(good_id,1);

            OrderItem orderItem = new OrderItem();
            orderItem.setGood_id(good_id);
            orderItem.setGood_num(1);
            orderItem.setOrder_id(order.getId());
            orderItemService.insert(orderItem);

        }
        r.put("msg","提交成功");
        return JSON.toJSONString(r);
    }

    @RequestMapping("orderlist")
    @ResponseBody
    public String orderlist(){
        Map<String,Object> r = new HashMap<>();
        List<List<Good>> goodlist = new ArrayList<>();
        List<Order> orders = orderService.orderlist(1);
        for (Order order:orders
             ) {
            List<OrderItem> orderItems = orderItemService.orderlist(order.getId());
            List<Good> goods = goodService.orders(orderItems);
            goodlist.add(goods);
        }
        r.put("goods",goodlist);
        r.put("orders",orders);
        return JSON.toJSONString(r);
    }

    @RequestMapping("deleteorder")
    @ResponseBody
    public String deleteorder(HttpServletRequest request){
        Map<String,Object> r = new HashMap<>();
        Integer id = Integer.valueOf(request.getParameter("id"));
        if (orderService.update(id)){
            r.put("msg","取消订单");
        }
        else{
            r.put("msg","取消订单失败");
        }
        return JSON.toJSONString(r);
    }

    @RequestMapping("searchorder")
    @ResponseBody
    public String searchorder(HttpServletRequest request){
        Map<String,Object> r = new HashMap<>();
        String ID = request.getParameter("ID");
        List<List<Good>> goodlist = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        Order order = orderService.findOrder(ID);

            List<OrderItem> orderItems = orderItemService.orderlist(order.getId());
            List<Good> goods = goodService.orders(orderItems);
            goodlist.add(goods);
            orders.add(order);
        r.put("goods",goodlist);
        r.put("orders",orders);
        return JSON.toJSONString(r);

    }
}
