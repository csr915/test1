package Dao.mapper;


import Dao.entity.Cart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {
    @Select("select * from cart where user_id = #{user_id}")
    public List<Cart> carts(@Param("user_id")Integer user_id);
    @Select("select * from cart where id = #{id}")
    public Cart FindById(@Param("id")Integer id);
    @Select("select * from cart where good_id = #{good_id} and user_id=#{user_id}")
    public Cart Findcart(@Param("good_id")Integer id,@Param("user_id")Integer user_id);
    @Insert("Insert into cart(user_id,good_id,good_title,good_num) value(#{user_id},#{good_id},#{good_title},good_num=#{good_num})")
    public boolean insert(Cart cart);
    @Update("Update  cart set good_num=#{good_num} where good_id=#{good_id} and user_id=#{user_id}")
    public boolean update(Cart cart);
    @Delete("delete from cart where good_id=#{id} and user_id=#{user_id}")
    public boolean delete(@Param("id") Integer id,@Param("user_id") Integer user_id);
    @Delete("delete from cart ")
    public boolean deleteall();
}
