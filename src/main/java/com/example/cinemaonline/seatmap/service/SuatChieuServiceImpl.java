package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.enumeration.CategoryErrorEnum;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.seatmap.model.SuatChieu;
import com.example.cinemaonline.seatmap.repository.SuatChieuRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuatChieuServiceImpl implements ISuatChieuService {
    @Autowired
    SuatChieuRepositoryImpl iSuatChieuRepositoryImpl;


    @Override
    public List<SuatChieu> findByIdSuatChieu(String id) {
        return iSuatChieuRepositoryImpl.findByIdSuatChieu(id);
    }

    @Override
    public SuatChieu findById(String id) throws ServiceException {
        SuatChieu suatChieu = iSuatChieuRepositoryImpl.findById(id);
        if(suatChieu == null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
        }
        return suatChieu;
    }

    @Override
    public PagingResponse<SuatChieu> findAll(int pageNumber, int pageSize) {
        return iSuatChieuRepositoryImpl.findAll(pageNumber, pageSize);
    }

    @Override
    public PagingResponse<SuatChieu> searchByKey(int pageNumber, int pageSize, String searchKey) {

        if (searchKey == null || searchKey.isEmpty()) {
            return iSuatChieuRepositoryImpl.findAll(pageNumber, pageSize);
        }
        return iSuatChieuRepositoryImpl.searchByKey(pageNumber, pageSize, searchKey);
    }

    @Override
    public SuatChieu edit(SuatChieu SuatChieu) throws ServiceException {
        SuatChieu existedSuatChieu = iSuatChieuRepositoryImpl.findByMaOrTenAndNotId(
                SuatChieu.getSuatChieu(),
                SuatChieu.getIdSuatChieu(),
                SuatChieu.get_id()
        );

        if (existedSuatChieu != null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.BAD_REQUEST);
        }

        return iSuatChieuRepositoryImpl.edit(SuatChieu);
    }

    @Override
    public SuatChieu insert(SuatChieu SuatChieu) throws ServiceException {
        if(findByMaOrTen(SuatChieu.getSuatChieu(), SuatChieu.getIdSuatChieu()) != null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.NOT_ACCEPTABLE);
        }
        return iSuatChieuRepositoryImpl.insert(SuatChieu);
    }

    @Override
    public void delete(SuatChieu SuatChieu) {
        iSuatChieuRepositoryImpl.delete(SuatChieu);
    }


    public SuatChieu findByMaOrTen(String ma, String ten) {
        return iSuatChieuRepositoryImpl.findByMaOrTen(ma, ten);
    }
}
