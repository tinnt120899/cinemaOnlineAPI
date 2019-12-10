package com.example.cinemaonline.listgroup.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.listgroup.model.ListRap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IListRapService {

    List<ListRap> findByName(String heThongRap, String tinhThanh);

    ListRap findById(String id) throws ServiceException;

    PagingResponse<ListRap> findAll(int pageNumber, int pageSize);

    PagingResponse<ListRap> searchByKey(int pageNumber, int pageSize, String searchKey) ;

    ListRap edit(ListRap ListRap) throws ServiceException;

    ListRap insert(ListRap ListRap) throws ServiceException;

    void delete(ListRap ListRap);
}
