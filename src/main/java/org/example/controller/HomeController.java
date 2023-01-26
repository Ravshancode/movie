package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.dao.MovieDao;
import org.example.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    private final UserDao userDao;
    private final MovieDao movieDao;
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("movies",movieDao.findAll());
        return "home";
    }
    @GetMapping("/movie/{id}")
    public String movieInfo(@PathVariable int id, Model model){
        model.addAttribute("movieInfo", userDao.findById(id));
        return "movie-info";
    }
}
