package com.example.cinemaonline.tabset.repository;

import com.example.cinemaonline.tabset.model.ListPhim;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ListPhimRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    public List<ListPhim> findByNameRap(String routeName) {
        Query query= new Query().addCriteria(Criteria.where("routeName").is(routeName));
        return mongoTemplate.find(query, ListPhim.class);
    }

    public List<ListPhim> findAll() {
        return mongoTemplate.findAll(ListPhim.class);
    }

    public List<ListPhim> findById(String id) {
        Query query= new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.find(query, ListPhim.class);
    }

   
}
