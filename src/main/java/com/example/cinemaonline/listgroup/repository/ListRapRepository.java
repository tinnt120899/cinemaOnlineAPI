package com.example.cinemaonline.listgroup.repository;

import com.example.cinemaonline.listgroup.model.ListRap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ListRapRepository{
    @Autowired
    MongoTemplate mongoTemplate;
    public List<ListRap> getAll() {
        return mongoTemplate.findAll(ListRap.class);
    }

    public List<ListRap> findByName(String heThongRap) {
        Query query= new Query().addCriteria(Criteria.where("heThongRap").is(heThongRap));
        return mongoTemplate.find(query, ListRap.class);
    }


}
