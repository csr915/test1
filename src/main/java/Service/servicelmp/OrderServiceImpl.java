package Service.servicelmp;

import Dao.entity.Order;
import Dao.mapper.OrderMapper;
import Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> list() {
        return orderMapper.list();
    }

    @Override
    public Order findOrder(String order) {
        return orderMapper.findOrder(order);
    }

    @Override
    public List<Order> orderlist(int user_id) {
        return orderMapper.orderlist(user_id);
    }

    @Override
    public Order findId(int id) {
        return orderMapper.findId(id);
    }

    @Override
    public boolean insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public boolean delete(Integer id) {
        return orderMapper.delete(id);
    }

    @Override
    public boolean update(int id) {
        return orderMapper.update(id);
    }
}
