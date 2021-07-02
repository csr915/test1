package Service;

import Dao.entity.Game;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GameService {
    public List<Game> gameList();
    public List<Game> search(Game game);
    public boolean insert(Game game);
    public boolean delete(@Param("id") Integer id);
    public boolean update(Game game);
}
