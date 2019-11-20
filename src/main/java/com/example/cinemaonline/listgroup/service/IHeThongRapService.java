package com.example.cinemaonline.listgroup.service;

import com.example.cinemaonline.listgroup.model.HeThongRap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHeThongRapService {

    List<HeThongRap> findByName(String tinhThanh);

}
