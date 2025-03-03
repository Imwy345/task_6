package web.service;

import java.util.List;
import javax.validation.Valid;
import web.model.User;

public interface UserService {
    List<User> getAllUsers();

    Object getUserById(int var1);

    void addUser(User var1);

    void removeUser(int var1);

    void updateUser(@Valid User var1);
}
