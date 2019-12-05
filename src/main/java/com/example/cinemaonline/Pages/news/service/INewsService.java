package com.example.cinemaonline.Pages.news.service;


import com.example.cinemaonline.Pages.news.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface INewsService {

    List<News> findAll();

    List<News> findById(String id);
}
