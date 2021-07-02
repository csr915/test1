package Service.servicelmp;

import Dao.entity.User;
import Dao.mapper.UserMapper;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserByUsername(String un) {
        return userMapper.getUserByUsername(un);
    }

    @Override
    public User getUserByUsernameAndPassword(User user) {
        return userMapper.getUserByUsernameAndPassword(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(String username) {
        return userMapper.deleteUser(username);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
