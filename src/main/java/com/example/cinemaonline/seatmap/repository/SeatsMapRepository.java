package com.example.cinemaonline.seatmap.repository;

import com.example.cinemaonline.seatmap.model.SeatsMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SeatsMapRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public SeatsMap findById(String id) {
        Query query= new Query().addCriteria(Criteria.where("idSeatMap").is(id));
        return mongoTemplate.findOne(query, SeatsMap.class);
    }


   
}
