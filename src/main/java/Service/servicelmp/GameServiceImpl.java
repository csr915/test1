package Service.servicelmp;

import Dao.entity.Game;
import Dao.mapper.GameMapper;
import Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameMapper gameMapper;
    @Override
    public List<Game> gameList() {
        return gameMapper.gameList();
    }

    @Override
    public List<Game> search(Game game) {
        return gameMapper.search(game);
    }

    @Override
    public boolean insert(Game game) {
        return gameMapper.insert(game);
    }

    @Override
    public boolean delete(Integer id) {
        return gameMapper.delete(id);
    }

    @Override
    public boolean update(Game game) {
        return gameMapper.update(game);
    }
}
