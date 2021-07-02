package Dao.mapper;

import Dao.entity.Commodity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommodityMapper {
    @Select("Select * from commodity")
    public List<Commodity> GetAllCommodity();
    @Insert("INSERT INTO commodity(commodityname,price) VALUES (#{commodityname},#{price})")
    public void AddCommodity(Commodity commodity);
    @Select("Select * from commodity where commodityname like concat(concat('%',#{commodityname}),'%')")
    List<Commodity> GetCommodityByname(String commodityname);
    @Delete("Delete from commodity where id=#{id}")
    void Deleteit(int id);
    @Select("Select * from commodity where id=#{id}")
    Commodity GetDetail(int id);
    @Update("Update commodity set commodityname=#{commodityname},price=#{price} where id=#{id}")
    void UpdateCommodity(Commodity commodity);
    @Select({"<script> " +
            "select * from commodity " +
            "where 1=1" +
            "<if test='commodityname!=null'> " +
            "and commodityname like concat('%',#{commodityname},'%')</if> " +
            "<if test='price!=null'> " +
            "and price = #{price}</if> " +
            "</script>"})
     List<Commodity> Searchit(@Param("commodityname")String commodityname,@Param("price")Float price);



}
