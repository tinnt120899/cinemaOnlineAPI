package com.example.cinemaonline.listgroup.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.listgroup.model.ListRap;

import java.util.List;

public interface IListRapRepository {
	ListRap findById(String id);

	PagingResponse<ListRap> findAll(int pageNumber, int pageSize);

	PagingResponse<ListRap> searchByKey(int pageNumber, int pageSize, String searchKey);

	ListRap edit(ListRap ListRap) ;

	ListRap insert(ListRap ListRap);

	void delete(ListRap ListRap);

	ListRap findByMaOrTen(String ma, String ten);

	ListRap findByMaOrTenAndNotId(String ma, String ten, String id);

	List<ListRap> findByName(String heThongRap, String tinhThanh);
}
