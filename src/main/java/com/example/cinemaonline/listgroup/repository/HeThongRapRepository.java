package com.example.cinemaonline.listgroup.repository;

import com.example.cinemaonline.listgroup.model.HeThongRap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HeThongRapRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public List<HeThongRap> getAll() {
        return mongoTemplate.findAll(HeThongRap.class);
    }

    public List<HeThongRap> findByName(String tinhThanh) {
        Criteria criteria = new Criteria().andOperator(
                Criteria.where("tinhThanh").is(tinhThanh));
        Query query= new Query().addCriteria(criteria);
        return mongoTemplate.find(query, HeThongRap.class);
    }


}
