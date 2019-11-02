package com.example.cinemaonline.listgroup.service;

import com.example.cinemaonline.listgroup.model.ListRap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IListRapService {

    List<ListRap> findByName(String heThongRap);

}
