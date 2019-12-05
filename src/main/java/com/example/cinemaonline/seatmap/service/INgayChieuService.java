package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.seatmap.model.NgayChieu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface INgayChieuService {

    List<NgayChieu> findByIdPhim(String idPhim);

}
