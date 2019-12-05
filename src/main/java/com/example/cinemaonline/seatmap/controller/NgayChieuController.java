package com.example.cinemaonline.seatmap.controller;

import com.example.cinemaonline.seatmap.model.NgayChieu;
import com.example.cinemaonline.seatmap.service.INgayChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ngaychieu")
public class NgayChieuController {

    @Autowired
    INgayChieuService iNgayChieuService;

    @GetMapping("/{idPhim}")
    List<NgayChieu> getNgayChieuByIdPhim(@PathVariable String idPhim){
        return  iNgayChieuService.findByIdPhim(idPhim);
    }

}
