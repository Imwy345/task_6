package web.service;

import java.util.List;
import jakarta.validation.Valid;
import web.model.User;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long var1);

    void addUser(User var1);

    void removeUser(long var1);

    void updateUser(@Valid User var1);
}
