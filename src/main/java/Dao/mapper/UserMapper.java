package Dao.mapper;

import Dao.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
	
	//查找所有用户，无参

	@Select("select * from user")
	public List<User> getAllUser();

	//根据用户名查找 （只有一个参数），应用于用户注册时的用户名查重
	@Select("select * from user where username=#{un}")
	public User getUserByUsername(String un);
	
	//根据用户名及密码查找（包含多个参数的查询，必须使用@param注解参数），应用于用户根据用户名及密码的登录
@Select("select * from user where username=#{username} and password=#{password}")
	public User getUserByUsernameAndPassword(User user);

	//----------------------------------------
	
	//下面的增加——删除——修改，均不需要注解参数
	
	
	//关键字ignore：忽略主键重复
	@Insert("insert ignore into user(username,password,realname,mobile,age) values(#{username},#{password},#{realname},#{mobile},#{age})")
	public int addUser(User user);
	@Delete("delete from user where username = #{username}")
	//根据用户名删除用户
	public int deleteUser(String username);
	@Update("update user set password=#{password},realname=#{realname} where username =#{username}")
	//根据用户名修改真实姓名
	public int updateUser(User user);

}

