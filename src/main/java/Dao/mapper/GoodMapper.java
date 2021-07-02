package Dao.mapper;

import Dao.entity.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodMapper {
    @Select("select * from good")
    public List<Good> goods();
    @Select("select * from good where id=#{id}")
    public Good cartgoods(@Param("id")Integer id);
}
