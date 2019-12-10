package com.example.cinemaonline.seatmap.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.seatmap.model.SuatChieu;

public interface ISuatChieuRepository {
	SuatChieu findById(String id);

	PagingResponse<SuatChieu> findAll(int pageNumber, int pageSize);

	PagingResponse<SuatChieu> searchByKey(int pageNumber, int pageSize, String searchKey);

	SuatChieu edit(SuatChieu SuatChieu) ;

	SuatChieu insert(SuatChieu SuatChieu);

	void delete(SuatChieu SuatChieu);

	SuatChieu findByMaOrTen(String ma, String ten);

	SuatChieu findByMaOrTenAndNotId(String ma, String ten, String id);

}
