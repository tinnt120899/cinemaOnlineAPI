package com.example.cinemaonline.seatmap.controller;

import com.example.cinemaonline.seatmap.model.SeatsMap;
import com.example.cinemaonline.seatmap.service.ISeatsMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seatmap")
public class SeatsMapController {

    @Autowired
    ISeatsMapService iSeatsMapService;

    @GetMapping("/{idSeatMap}")
    SeatsMap getSeatMapById(@PathVariable String idSeatMap){
        return  iSeatsMapService.findById(idSeatMap);
    }

}
