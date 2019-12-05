package com.example.cinemaonline.Pages.news.repository;


import com.example.cinemaonline.Pages.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NewsRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<News> findById(String id) {
        Query query= new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.find(query, News.class);
    }

    public List<News> findAll() {
        return mongoTemplate.findAll(News.class);
    }
   
}
