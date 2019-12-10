package com.example.cinemaonline.tabset.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.tabset.model.ListPhim;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IListPhimService {

    List<ListPhim> findByNameRap(String routeName);

    List<ListPhim> findByTinhThanh(String tinhThanh);

    ListPhim findById(String id) throws ServiceException;

    PagingResponse<ListPhim> findAll(int pageNumber, int pageSize);

    PagingResponse<ListPhim> searchByKey(int pageNumber, int pageSize, String searchKey) ;

    ListPhim edit(ListPhim ListPhim) throws ServiceException;

    ListPhim insert(ListPhim ListPhim) throws ServiceException;

    void delete(ListPhim ListPhim);
}
