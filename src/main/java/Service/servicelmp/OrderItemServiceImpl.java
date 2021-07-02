package Service.servicelmp;

import Dao.entity.OrderItem;
import Dao.mapper.OrderItemMapper;
import Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Override
    public List<OrderItem> list() {
        return orderItemMapper.list();
    }

    @Override
    public List<OrderItem> orderlist(int order_id) {
        return orderItemMapper.orderlist(order_id);
    }

    @Override
    public Boolean insert(OrderItem orderItem) {
        return orderItemMapper.insert(orderItem);
    }

    @Override
    public boolean delete(Integer order_id) {
        return orderItemMapper.delete(order_id);
    }
}
