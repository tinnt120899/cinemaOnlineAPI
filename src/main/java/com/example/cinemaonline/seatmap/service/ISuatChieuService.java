package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.seatmap.model.SuatChieu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISuatChieuService {

    List<SuatChieu> findById(String id);

}
