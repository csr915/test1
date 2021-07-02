package Service.servicelmp;


import Dao.entity.Cart;
import Dao.entity.Good;
import Dao.entity.OrderItem;
import Dao.mapper.GoodMapper;
import Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public List<Good> goods() {
        return goodMapper.goods();
    }

    @Override
    public Good cartgoods(Integer id) {
        return goodMapper.cartgoods(id);
    }

    @Override
    public List<Good> cart(List<Cart> carts) {
        List<Good> goods = new ArrayList<>();
        for (Cart c:carts
             ) {
            Good good = goodMapper.cartgoods(c.getGood_id());
            good.setNumber(c.getGood_num());
            goods.add(good);
        }
        return goods;
    }

    @Override
    public List<Good> orders(List<OrderItem> orderItems) {
        List<Good> goods = new ArrayList<>();

        for (OrderItem c:orderItems
        ) {
            Good good = goodMapper.cartgoods(c.getGood_id());
            good.setNumber(c.getGood_num());
            goods.add(good);
        }
        return goods;
    }
}
