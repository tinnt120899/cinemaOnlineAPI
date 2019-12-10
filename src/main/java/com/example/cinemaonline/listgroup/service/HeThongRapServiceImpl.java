package com.example.cinemaonline.listgroup.service;


import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.enumeration.CategoryErrorEnum;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.listgroup.model.HeThongRap;
import com.example.cinemaonline.listgroup.repository.IHeThongRapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeThongRapServiceImpl implements IHeThongRapService {
    @Autowired
    IHeThongRapRepository iHeThongRapRepository;

    @Override
    public List<HeThongRap> findByName(String tinhThanh) {
        return iHeThongRapRepository.findByName(tinhThanh);
    }

    @Override
    public HeThongRap findById(String id) throws ServiceException {
        HeThongRap HeThongRap = iHeThongRapRepository.findById(id);
        if(HeThongRap == null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
        }
        return HeThongRap;
    }

    @Override
    public PagingResponse<HeThongRap> findAll(int pageNumber, int pageSize) {
        return iHeThongRapRepository.findAll(pageNumber, pageSize);
    }

    @Override
    public PagingResponse<HeThongRap> searchByKey(int pageNumber, int pageSize, String searchKey) {

        if (searchKey == null || searchKey.isEmpty()) {
            return iHeThongRapRepository.findAll(pageNumber, pageSize);
        }
        return iHeThongRapRepository.searchByKey(pageNumber, pageSize, searchKey);
    }

    @Override
    public HeThongRap edit(HeThongRap HeThongRap) throws ServiceException {
        HeThongRap existedHeThongRap = iHeThongRapRepository.findByMaOrTenAndNotId(
                HeThongRap.getId(),
                HeThongRap.get_id()
        );

        if (existedHeThongRap != null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.BAD_REQUEST);
        }

        return iHeThongRapRepository.edit(HeThongRap);
    }

    @Override
    public HeThongRap insert(HeThongRap HeThongRap) throws ServiceException {
        if(findByMaOrTen(HeThongRap.getId()) != null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.NOT_ACCEPTABLE);
        }
        return iHeThongRapRepository.insert(HeThongRap);
    }

    @Override
    public void delete(HeThongRap HeThongRap) {
        iHeThongRapRepository.delete(HeThongRap);
    }


    public HeThongRap findByMaOrTen(String ma) {
        return iHeThongRapRepository.findByMaOrTen(ma);
    }

}
