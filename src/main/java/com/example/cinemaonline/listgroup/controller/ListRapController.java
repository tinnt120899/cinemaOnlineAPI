package com.example.cinemaonline.listgroup.controller;

import com.example.cinemaonline.listgroup.model.ListRap;
import com.example.cinemaonline.listgroup.service.IListRapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListRapController {

    @Autowired
    IListRapService iListRapService;

    @GetMapping("/cumrap/{heThongRap}")
    List<ListRap> getAll(@PathVariable String heThongRap){
        return  iListRapService.findByName(heThongRap);
    }


}
