package web.service;

import web.Dao.UserDao;
import web.model.User;
import java.util.List;

public interface UserService extends UserDao {
    void saveUser(User user);

    void updateUser(User user);

    User getUserById(long id);

    void removeUserById(long id);

    List<User> getAllUsers();
}
