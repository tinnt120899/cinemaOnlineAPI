package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.seatmap.model.NgayChieu;
import com.example.cinemaonline.seatmap.repository.NgayChieuRepository;
import com.example.cinemaonline.tabset.repository.ListPhimRepository;
import com.example.cinemaonline.tabset.service.IListPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NgayChieuServiceImpl implements INgayChieuService {
    @Autowired
    NgayChieuRepository ngayChieuRepository;


    @Override
    public List<NgayChieu> findByIdPhim(String idPhim) {
        return ngayChieuRepository.findByIdPhim(idPhim);
    }
}
