package com.example.cinemaonline.listgroup.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.listgroup.model.HeThongRap;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IHeThongRapService {

    List<HeThongRap> findByName(String tinhThanh);

    HeThongRap findById(String id) throws ServiceException;

    PagingResponse<HeThongRap> findAll(int pageNumber, int pageSize);

    PagingResponse<HeThongRap> searchByKey(int pageNumber, int pageSize, String searchKey) ;

    HeThongRap edit(HeThongRap HeThongRap) throws ServiceException;

    HeThongRap insert(HeThongRap HeThongRap) throws ServiceException;

    void delete(HeThongRap HeThongRap);

}
