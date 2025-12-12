package goltsman.dev.controller;

import goltsman.dev.model.User;
import goltsman.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", service.getAll());
        return "users";
    }

    @PostMapping("/add")
    public String add(User user) {
        service.save(user);
        return "redirect:/users";
    }

    @PostMapping("/edit")
    public String edit(User user) {
        service.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/users";
    }
}
