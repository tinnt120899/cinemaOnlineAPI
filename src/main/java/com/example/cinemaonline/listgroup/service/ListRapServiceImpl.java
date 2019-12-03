package com.example.cinemaonline.listgroup.service;

import com.example.cinemaonline.listgroup.model.ListRap;
import com.example.cinemaonline.listgroup.repository.ListRapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListRapServiceImpl implements IListRapService {
    @Autowired
    ListRapRepository listRapRepository;

    @Override
    public List<ListRap> findByName(String heThongRap, String tinhThanh) {
        return listRapRepository.findByName(heThongRap, tinhThanh);
    }

    @Override
    public List<ListRap> findById(String id) {
        return listRapRepository.findById(id);
    }


}
