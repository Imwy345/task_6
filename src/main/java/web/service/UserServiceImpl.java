package web.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    public Object getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Transactional
    public void updateUser(@Valid User user) {
        this.userDao.updateUser(user);
    }
}
