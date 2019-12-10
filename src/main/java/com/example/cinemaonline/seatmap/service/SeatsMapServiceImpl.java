package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.enumeration.CategoryErrorEnum;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.seatmap.model.SeatsMap;
import com.example.cinemaonline.seatmap.repository.SeatsMapRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SeatsMapServiceImpl implements ISeatsMapService {
    @Autowired
    SeatsMapRepositoryImpl iSeatsMapRepositoryImpl;


    @Override
    public SeatsMap findByIdSeatMap(String id) {
        return iSeatsMapRepositoryImpl.findByIdSeatMap(id);
    }

    @Override
    public SeatsMap findById(String id) throws ServiceException {
        SeatsMap SeatsMap = iSeatsMapRepositoryImpl.findById(id);
        if(SeatsMap == null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
        }
        return SeatsMap;
    }

    @Override
    public PagingResponse<SeatsMap> findAll(int pageNumber, int pageSize) {
        return iSeatsMapRepositoryImpl.findAll(pageNumber, pageSize);
    }

    @Override
    public PagingResponse<SeatsMap> searchByKey(int pageNumber, int pageSize, String searchKey) {

        if (searchKey == null || searchKey.isEmpty()) {
            return iSeatsMapRepositoryImpl.findAll(pageNumber, pageSize);
        }
        return iSeatsMapRepositoryImpl.searchByKey(pageNumber, pageSize, searchKey);
    }

    @Override
    public SeatsMap edit(SeatsMap SeatsMap) throws ServiceException {
        SeatsMap existedSeatsMap = iSeatsMapRepositoryImpl.findByMaOrTenAndNotId(
                SeatsMap.getIdSeatMap(),
                SeatsMap.get_id()
        );

        if (existedSeatsMap != null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.BAD_REQUEST);
        }

        return iSeatsMapRepositoryImpl.edit(SeatsMap);
    }

    @Override
    public SeatsMap insert(SeatsMap SeatsMap) throws ServiceException {
        if(findByMaOrTen(SeatsMap.getIdSeatMap()) != null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.NOT_ACCEPTABLE);
        }
        return iSeatsMapRepositoryImpl.insert(SeatsMap);
    }

    @Override
    public void delete(SeatsMap SeatsMap) {
        iSeatsMapRepositoryImpl.delete(SeatsMap);
    }


    public SeatsMap findByMaOrTen(String ma) {
        return iSeatsMapRepositoryImpl.findByMaOrTen(ma);
    }
}
