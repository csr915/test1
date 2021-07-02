package Dao.mapper;

import Dao.entity.Game;
import Dao.entity.Order;
import Dao.entity.OrderItem;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    @Select("select * from `order`")
    public List<Order> list();

    @Select("select * from `order` where user_id=#{user_id} and state=0")
    public List<Order> orderlist(@Param("user_id")int user_id);

    @Select("select * from `order` where id=#{id}")
    public Order findId(@Param("id")int id);

    @Select("select * from `order` where orderID=#{order}")
    public Order findOrder(@Param("order")String order);

    @Insert("insert into `order`(price,date,user_id,orderID) values(#{price},#{date},#{user_id},#{orderID})")
    public Boolean insert(Order order);

    @Update("update `order` set  state=1 where id =#{id}")
    public boolean update(@Param("id") int id);
    @Delete("delete from `order` where id = #{id}")
    public boolean delete(@Param("id") Integer id);
}
