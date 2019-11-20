package com.example.cinemaonline.listgroup.controller;

import com.example.cinemaonline.listgroup.model.HeThongRap;
import com.example.cinemaonline.listgroup.service.IHeThongRapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/hethongrap")
@RestController
public class HeThongRapController {
    @Autowired
    IHeThongRapService iHeThongRapService;

    @GetMapping()
    List<HeThongRap> getAll(
            @RequestParam("tinhThanh") String tinhThanh
    ){
        return  iHeThongRapService.findByName(tinhThanh);
    }
}
