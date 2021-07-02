package Service;

import Dao.entity.Cart;
import Dao.entity.Good;
import Dao.entity.OrderItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodService {
    public List<Good> goods();

    public Good cartgoods(Integer id);

    public List<Good> cart(List<Cart> carts);
    public List<Good> orders(List<OrderItem> orderItems);
}
