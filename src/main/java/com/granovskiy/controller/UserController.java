package com.granovskiy.controller;

import com.granovskiy.model.User;
import com.granovskiy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private ModelAndView login(ModelAndView vm) {
        vm.addObject("user", new User());
        vm.setViewName("login");
        return vm;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String login(@ModelAttribute User user) { //user:User@4896
        User u = userService.getByUsername(user.getUsername());
        // all fields of the u object got their values from DB
        // some logic
        return "login";
    }
}
