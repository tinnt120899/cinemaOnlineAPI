package com.example.cinemaonline.seatmap.repository;

import com.example.cinemaonline.seatmap.model.NgayChieu;
import com.example.cinemaonline.tabset.model.ListPhim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NgayChieuRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<NgayChieu> findByIdPhim(String idPhim) {
        Query query= new Query().addCriteria(Criteria.where("idPhim").is(idPhim));
        return mongoTemplate.find(query, NgayChieu.class);
    }


   
}
