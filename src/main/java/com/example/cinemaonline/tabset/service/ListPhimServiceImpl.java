package com.example.cinemaonline.tabset.service;

import com.example.cinemaonline.tabset.model.ListPhim;
import com.example.cinemaonline.tabset.repository.ListPhimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPhimServiceImpl implements IListPhimService {
    @Autowired
    ListPhimRepository listPhimRepository;

    @Override
    public List<ListPhim> getListPhimDangChieu() {
        return listPhimRepository.findAll();
    }

    @Override
    public List<ListPhim> findByNameRap(String routeName) {
        return listPhimRepository.findByNameRap(routeName);
    }

    @Override
    public List<ListPhim> findById(String id) {
        return listPhimRepository.findById(id);
    }
}
