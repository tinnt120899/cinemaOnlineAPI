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

    public List<ListRap> findByName(String heThongRap, String tinhThanh) {
        Criteria criteria = new Criteria().andOperator(
                Criteria.where("heThongRap").is(heThongRap),
                Criteria.where("tinhThanh").is(tinhThanh));
        Query query= new Query().addCriteria(criteria);
        return mongoTemplate.find(query, ListRap.class);
    }

    public List<ListRap> findById(String _id) {
        Query query= new Query().addCriteria(Criteria.where("_id").is(_id));
        return mongoTemplate.find(query, ListRap.class);
    }

}
