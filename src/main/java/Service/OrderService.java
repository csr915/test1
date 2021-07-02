package Service;

import Dao.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderService {
    public List<Order> list();
    public Order findOrder(String order);

    public List<Order> orderlist(int user_id);
    public Order findId(int id);
    public boolean insert(Order order);
    public boolean delete(Integer id);
    public boolean update(int id);
}
