package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.seatmap.model.SuatChieu;
import com.example.cinemaonline.seatmap.repository.SuatChieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuatChieuServiceImpl implements ISuatChieuService {
    @Autowired
    SuatChieuRepository suatChieuRepository;


    @Override
    public List<SuatChieu> findById(String id) {
        return suatChieuRepository.findById(id);
    }
}
