package com.example.cinemaonline.listgroup.repository;


import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.listgroup.model.HeThongRap;

import java.util.List;

public interface IHeThongRapRepository {
	HeThongRap findById(String id);

	PagingResponse<HeThongRap> findAll(int pageNumber, int pageSize);

	PagingResponse<HeThongRap> searchByKey(int pageNumber, int pageSize, String searchKey);

	HeThongRap edit(HeThongRap HeThongRap) ;

	HeThongRap insert(HeThongRap HeThongRap);

	void delete(HeThongRap HeThongRap);

	HeThongRap findByMaOrTen(String ma);

	HeThongRap findByMaOrTenAndNotId(String ma, String id);

    List<HeThongRap> findByName(String tinhThanh);
}
