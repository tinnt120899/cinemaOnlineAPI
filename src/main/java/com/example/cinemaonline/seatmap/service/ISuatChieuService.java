package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.seatmap.model.SuatChieu;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISuatChieuService {

    List<SuatChieu> findByIdSuatChieu(String id);

    SuatChieu findById(String id) throws ServiceException;

    PagingResponse<SuatChieu> findAll(int pageNumber, int pageSize);

    PagingResponse<SuatChieu> searchByKey(int pageNumber, int pageSize, String searchKey) ;

    SuatChieu edit(SuatChieu SuatChieu) throws ServiceException;

    SuatChieu insert(SuatChieu SuatChieu) throws ServiceException;

    void delete(SuatChieu SuatChieu);
}
