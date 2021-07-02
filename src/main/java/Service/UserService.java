package Service;

import Dao.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();

    public User getUserByUsername(String un);


    public User getUserByUsernameAndPassword(User user);


    public int addUser(User user);

    public int deleteUser(String username);

    public int updateUser(User user);
}
