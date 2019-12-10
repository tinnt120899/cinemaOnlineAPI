package com.example.cinemaonline.seatmap.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.enumeration.CategoryErrorEnum;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.seatmap.model.NgayChieu;
import com.example.cinemaonline.seatmap.repository.NgayChieuRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NgayChieuServiceImpl implements INgayChieuService {
    @Autowired
    NgayChieuRepositoryImpl iNgayChieuRepositoryImpl;


    @Override
    public List<NgayChieu> findByIdPhim(String idPhim) {
        return iNgayChieuRepositoryImpl.findByIdPhim(idPhim);
    }

    @Override
    public NgayChieu findById(String id) throws ServiceException {
        NgayChieu NgayChieu = iNgayChieuRepositoryImpl.findById(id);
        if(NgayChieu == null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
        }
        return NgayChieu;
    }

    @Override
    public PagingResponse<NgayChieu> findAll(int pageNumber, int pageSize) {
        return iNgayChieuRepositoryImpl.findAll(pageNumber, pageSize);
    }

    @Override
    public PagingResponse<NgayChieu> searchByKey(int pageNumber, int pageSize, String searchKey) {

        if (searchKey == null || searchKey.isEmpty()) {
            return iNgayChieuRepositoryImpl.findAll(pageNumber, pageSize);
        }
        return iNgayChieuRepositoryImpl.searchByKey(pageNumber, pageSize, searchKey);
    }

    @Override
    public NgayChieu edit(NgayChieu NgayChieu) throws ServiceException {
        NgayChieu existedNgayChieu = iNgayChieuRepositoryImpl.findByMaOrTenAndNotId(
                NgayChieu.getNgayChieu(),
                NgayChieu.get_id()
        );

        if (existedNgayChieu != null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.BAD_REQUEST);
        }

        return iNgayChieuRepositoryImpl.edit(NgayChieu);
    }

    @Override
    public NgayChieu insert(NgayChieu NgayChieu) throws ServiceException {
        if(findByMaOrTen(NgayChieu.getNgayChieu()) != null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.NOT_ACCEPTABLE);
        }
        return iNgayChieuRepositoryImpl.insert(NgayChieu);
    }

    @Override
    public void delete(NgayChieu NgayChieu) {
        iNgayChieuRepositoryImpl.delete(NgayChieu);
    }


    public NgayChieu findByMaOrTen(String ma) {
        return iNgayChieuRepositoryImpl.findByMaOrTen(ma);
    }

}
