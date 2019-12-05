package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.seatmap.model.SeatsMap;
import com.example.cinemaonline.seatmap.repository.SeatsMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsMapServiceImpl implements ISeatsMapService {
    @Autowired
    SeatsMapRepository seatsMapRepository;


    @Override
    public SeatsMap findById(String id) {
        return seatsMapRepository.findById(id);
    }
}
