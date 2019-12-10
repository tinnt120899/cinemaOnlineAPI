package com.example.cinemaonline.tabset.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.tabset.model.ListPhim;

import java.util.List;

public interface IListPhimRepository {
	ListPhim findById(String id);

	PagingResponse<ListPhim> findAll(int pageNumber, int pageSize);

	PagingResponse<ListPhim> searchByKey(int pageNumber, int pageSize, String searchKey);

	ListPhim edit(ListPhim ListPhim) ;

	ListPhim insert(ListPhim ListPhim);

	void delete(ListPhim ListPhim);

	ListPhim findByMaOrTen(String ma);

	ListPhim findByMaOrTenAndNotId(String ma, String id);

	List<ListPhim> findByNameRap(String routeName);

	List<ListPhim> findByTinhThanh(String tinhThanh);
}
