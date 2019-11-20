package com.example.cinemaonline.listgroup.service;

import com.example.cinemaonline.listgroup.model.HeThongRap;
import com.example.cinemaonline.listgroup.repository.HeThongRapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeThongRapServiceImpl implements IHeThongRapService {
    @Autowired
    HeThongRapRepository HeThongRapRepository;

    @Override
    public List<HeThongRap> findByName(String tinhThanh) {
        return HeThongRapRepository.findByName(tinhThanh);
    }

}
