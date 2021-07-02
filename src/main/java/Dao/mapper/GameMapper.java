package Dao.mapper;

import Dao.entity.Game;
import Dao.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GameMapper {
    @Select("select * from game")
    public List<Game> gameList();

    @Select({"<script> " +
            "select * from game " +
            "where 1=1" +
            "<if test='game_title!=null'> " +
            "and game_title like concat('%',#{game_title},'%')</if> " +
            "<if test='game_type!=null'> " +
            "and game_type = #{game_type}</if> " +
            "</script>"})
    public List<Game> search(Game game);

    //关键字ignore：忽略主键重复
    @Insert("insert ignore into game(game_title,game_type) values(#{game_title},#{game_type})")
    public boolean insert(Game game);
    @Delete("delete from game where id = #{id}")
    public boolean delete(@Param("id") Integer id);
    @Update("update game set game_title=#{game_title},game_type=#{game_type} where id =#{id}")

    public boolean update(Game game);
}
