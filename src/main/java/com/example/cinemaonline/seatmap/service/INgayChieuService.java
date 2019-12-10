package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.seatmap.model.NgayChieu;
import org.springframework.stereotype.Service;

import java.util.List;


public interface INgayChieuService {

    List<NgayChieu> findByIdPhim(String idPhim);

    NgayChieu findById(String id) throws ServiceException;

    PagingResponse<NgayChieu> findAll(int pageNumber, int pageSize);

    PagingResponse<NgayChieu> searchByKey(int pageNumber, int pageSize, String searchKey) ;

    NgayChieu edit(NgayChieu NgayChieu) throws ServiceException;

    NgayChieu insert(NgayChieu NgayChieu) throws ServiceException;

    void delete(NgayChieu NgayChieu);
}
