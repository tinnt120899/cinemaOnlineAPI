package com.example.cinemaonline.Pages.news.service;

import com.example.cinemaonline.Pages.news.model.News;
import com.example.cinemaonline.Pages.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    NewsRepository newsRepository;

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> findById(String id) {
        return newsRepository.findById(id);
    }

}
