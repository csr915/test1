package Dao.mapper;

import Dao.entity.OrderItem;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface OrderItemMapper {
    @Select("select * from orderItem")
    public List<OrderItem> list();

    @Select("select * from orderItem where order_id=#{order_id}")
    public List<OrderItem> orderlist(@Param("order_id")int order_id);

    @Insert("insert ignore into orderItem(order_id,good_id,good_num) values(#{order_id},#{good_id},#{good_num})")
    public Boolean insert(OrderItem orderItem);

    @Delete("delete from orderItem where order_id = #{order_id}")
    public boolean delete(@Param("order_id") Integer order_id);

}
