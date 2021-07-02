package Service.servicelmp;

import Dao.entity.Cart;
import Dao.mapper.CartMapper;
import Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Override
    public List<Cart> carts(Integer user_id) {
        return cartMapper.carts(user_id);
    }

    @Override
    public Cart Findcart(Integer id, Integer user_id) {
        return cartMapper.Findcart(id,user_id);
    }

    @Override
    public Cart FindById(Integer id) {
        return cartMapper.FindById(id);
    }

    @Override
    public boolean insert(Cart cart) {
        return cartMapper.insert(cart);
    }

    @Override
    public boolean update(Cart cart) {
        return cartMapper.update(cart);
    }

    @Override
    public boolean delete(Integer id,Integer user_id) {
        return cartMapper.delete(id,user_id);
    }

    @Override
    public boolean deleteall() {
        return cartMapper.deleteall();
    }
}
