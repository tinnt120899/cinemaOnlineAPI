package com.example.cinemaonline.listgroup.service;

import com.example.cinemaonline.listgroup.model.ListRap;
import com.example.cinemaonline.listgroup.repository.ListRapRepository;
import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListRapServiceImpl implements IListRapService {
    @Autowired
    ListRapRepository listRapRepository;

    @Override
    public List<ListRap> findByName(String heThongRap, String tinhThanh) {
        return listRapRepository.findByName(heThongRap, tinhThanh);
    }



}
