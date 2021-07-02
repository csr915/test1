package Service;

import Dao.entity.Cart;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartService {
    public List<Cart> carts(Integer user_id);
public Cart Findcart(Integer id,Integer user_id);
    public Cart FindById(Integer id);
   public boolean insert(Cart cart);
   public boolean update(Cart cart);
    public boolean delete(Integer id,Integer user_id);
    public boolean deleteall();
}
