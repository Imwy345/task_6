package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/"})
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping({"/{id}"})
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping({"/new"})
    public String addUser(User user) {
        return "newUser";
    }

    @PostMapping({"/new"})
    public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newUser";
        } else {
            userService.addUser(user);
            return "redirect:/";
        }
    }

    @GetMapping({"{id}/update"})
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "updateUser";
    }

    @PatchMapping({"/update"})
    public String update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        } else {
            this.userService.updateUser(user);
            return "redirect:/";
        }
    }

    @DeleteMapping({"/delete/{id}"})
    public String delete(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
