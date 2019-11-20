package com.example.cinemaonline.listgroup.controller;

import com.example.cinemaonline.listgroup.model.ListRap;
import com.example.cinemaonline.listgroup.service.IListRapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cumrap")
@RestController
public class ListRapController {

    @Autowired
    IListRapService iListRapService;

    @GetMapping()
    List<ListRap> getAll(
            @RequestParam("heThongRap") String heThongRap,
            @RequestParam("tinhThanh") String tinhThanh
    ){
        return  iListRapService.findByName(heThongRap, tinhThanh);
    }

}
