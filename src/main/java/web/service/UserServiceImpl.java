package web.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(@Valid User user) {
        User oldUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println(oldUser.toString() + " " +user.toString());
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        userRepository.save(oldUser);
    }
}
