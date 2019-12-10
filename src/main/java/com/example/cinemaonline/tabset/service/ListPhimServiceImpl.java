package com.example.cinemaonline.tabset.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.enumeration.CategoryErrorEnum;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.tabset.model.ListPhim;
import com.example.cinemaonline.tabset.repository.IListPhimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPhimServiceImpl implements IListPhimService {
    @Autowired
    IListPhimRepository iListPhimRepository;

    @Override
    public List<ListPhim> findByNameRap(String routeName) {
        return iListPhimRepository.findByNameRap(routeName);
    }

    @Override
    public List<ListPhim> findByTinhThanh(String tinhThanh) {
        return iListPhimRepository.findByTinhThanh(tinhThanh);
    }


    @Override
    public ListPhim findById(String id) throws ServiceException {
        ListPhim ListPhim = iListPhimRepository.findById(id);
        if(ListPhim == null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
        }
        return ListPhim;
    }

    @Override
    public PagingResponse<ListPhim> findAll(int pageNumber, int pageSize) {
        return iListPhimRepository.findAll(pageNumber, pageSize);
    }

    @Override
    public PagingResponse<ListPhim> searchByKey(int pageNumber, int pageSize, String searchKey) {

        if (searchKey == null || searchKey.isEmpty()) {
            return iListPhimRepository.findAll(pageNumber, pageSize);
        }
        return iListPhimRepository.searchByKey(pageNumber, pageSize, searchKey);
    }

    @Override
    public ListPhim edit(ListPhim ListPhim) throws ServiceException {
        ListPhim existedListPhim = iListPhimRepository.findByMaOrTenAndNotId(
                ListPhim.getIdPhim(),
                ListPhim.get_id()
        );

        if (existedListPhim != null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.BAD_REQUEST);
        }

        return iListPhimRepository.edit(ListPhim);
    }

    @Override
    public ListPhim insert(ListPhim ListPhim) throws ServiceException {
        if(findByMaOrTen(ListPhim.getIdPhim())!= null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.NOT_ACCEPTABLE);
        }
        return iListPhimRepository.insert(ListPhim);
    }

    @Override
    public void delete(ListPhim ListPhim) {
        iListPhimRepository.delete(ListPhim);
    }


    public ListPhim findByMaOrTen(String ma) {
        return iListPhimRepository.findByMaOrTen(ma);
    }}
