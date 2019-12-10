package com.example.cinemaonline.seatmap.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.seatmap.model.SeatsMap;

public interface ISeatMapRepository {
	SeatsMap findById(String id);

	PagingResponse<SeatsMap> findAll(int pageNumber, int pageSize);

	PagingResponse<SeatsMap> searchByKey(int pageNumber, int pageSize, String searchKey);

	SeatsMap edit(SeatsMap SeatMap) ;

	SeatsMap insert(SeatsMap SeatMap);

	void delete(SeatsMap SeatMap);

	SeatsMap findByMaOrTen(String ma);

	SeatsMap findByMaOrTenAndNotId(String ma, String id);

}
