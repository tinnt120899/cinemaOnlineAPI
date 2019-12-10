package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.seatmap.model.SeatsMap;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISeatsMapService {

    SeatsMap findByIdSeatMap(String id);

    SeatsMap findById(String id) throws ServiceException;

    PagingResponse<SeatsMap> findAll(int pageNumber, int pageSize);

    PagingResponse<SeatsMap> searchByKey(int pageNumber, int pageSize, String searchKey) ;

    SeatsMap edit(SeatsMap SeatsMap) throws ServiceException;

    SeatsMap insert(SeatsMap SeatsMap) throws ServiceException;

    void delete(SeatsMap SeatsMap);
}
