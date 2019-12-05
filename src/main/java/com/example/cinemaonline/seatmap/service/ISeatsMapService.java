package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.seatmap.model.SeatsMap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISeatsMapService {

    SeatsMap findById(String id);

}
