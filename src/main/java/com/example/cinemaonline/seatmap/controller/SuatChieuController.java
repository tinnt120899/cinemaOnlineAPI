package com.example.cinemaonline.seatmap.controller;

import com.example.cinemaonline.seatmap.model.SuatChieu;
import com.example.cinemaonline.seatmap.service.ISuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suatchieu")
public class SuatChieuController {

    @Autowired
    ISuatChieuService iSuatChieuService;

    @GetMapping("/{idSuatChieu}")
    List<SuatChieu> getSuatChieuById(@PathVariable String idSuatChieu){
        return  iSuatChieuService.findById(idSuatChieu);
    }

}
