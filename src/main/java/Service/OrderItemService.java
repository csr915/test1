package Service;

import Dao.entity.OrderItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderItemService {
    public List<OrderItem> list();

    public List<OrderItem> orderlist(int order_id);

    public Boolean insert(OrderItem orderItem);
    public boolean delete(Integer order_id);
}
