package com.example.cinemaonline.listgroup.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.enumeration.CategoryErrorEnum;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.listgroup.model.ListRap;
import com.example.cinemaonline.listgroup.repository.IListRapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListRapServiceImpl implements IListRapService {
    @Autowired
    IListRapRepository iListRapRepository;

    @Override
    public List<ListRap> findByName(String heThongRap, String cumRap) {
        return iListRapRepository.findByName(heThongRap, cumRap);
    }

    @Override
    public ListRap findById(String id) throws ServiceException {
        ListRap ListRap = iListRapRepository.findById(id);
        if(ListRap == null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
        }
        return ListRap;
    }

    @Override
    public PagingResponse<ListRap> findAll(int pageNumber, int pageSize) {
        return iListRapRepository.findAll(pageNumber, pageSize);
    }

    @Override
    public PagingResponse<ListRap> searchByKey(int pageNumber, int pageSize, String searchKey) {

        if (searchKey == null || searchKey.isEmpty()) {
            return iListRapRepository.findAll(pageNumber, pageSize);
        }
        return iListRapRepository.searchByKey(pageNumber, pageSize, searchKey);
    }

    @Override
    public ListRap edit(ListRap ListRap) throws ServiceException {
        ListRap existedListRap = iListRapRepository.findByMaOrTenAndNotId(
                ListRap.getTenRap(),
                ListRap.getRouteName(),
                ListRap.get_id()
        );

        if (existedListRap != null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.BAD_REQUEST);
        }

        return iListRapRepository.edit(ListRap);
    }

    @Override
    public ListRap insert(ListRap ListRap) throws ServiceException {
        if(findByMaOrTen(ListRap.getTenRap(), ListRap.getRouteName()) != null) {
            throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.NOT_ACCEPTABLE);
        }
        return iListRapRepository.insert(ListRap);
    }

    @Override
    public void delete(ListRap ListRap) {
        iListRapRepository.delete(ListRap);
    }


    public ListRap findByMaOrTen(String ma, String ten) {
        return iListRapRepository.findByMaOrTen(ma, ten);
    }

}
