package com.example.cinemaonline.Pages.news.controller;

import com.example.cinemaonline.Pages.news.model.News;
import com.example.cinemaonline.Pages.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    INewsService iNewsService;

    @GetMapping("/{_id}")
    List<News> getById(@PathVariable String _id){
        return  iNewsService.findById(_id);
    }

    @GetMapping()
    List<News> getAll(){
        return  iNewsService.findAll();
    }

}
