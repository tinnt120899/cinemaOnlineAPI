package com.example.cinemaonline.seatmap.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.seatmap.model.NgayChieu;

public interface INgayChieuRepository {
	NgayChieu findById(String id);

	PagingResponse<NgayChieu> findAll(int pageNumber, int pageSize);

	PagingResponse<NgayChieu> searchByKey(int pageNumber, int pageSize, String searchKey);

	NgayChieu edit(NgayChieu NgayChieu) ;

	NgayChieu insert(NgayChieu NgayChieu);

	void delete(NgayChieu NgayChieu);

	NgayChieu findByMaOrTen(String ma);

	NgayChieu findByMaOrTenAndNotId(String ma, String id);

}
