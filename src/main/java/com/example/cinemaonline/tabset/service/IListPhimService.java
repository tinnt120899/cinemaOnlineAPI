package com.example.cinemaonline.tabset.service;

import com.example.cinemaonline.tabset.model.ListPhim;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IListPhimService {

    List<ListPhim> getListPhimDangChieu();

    List<ListPhim> findByNameRap(String routeName);

    List<ListPhim> findById(String id);

    List<ListPhim> findByTinhThanh(String tinhThanh);
}
