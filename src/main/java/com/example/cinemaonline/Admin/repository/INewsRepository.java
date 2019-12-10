package com.example.cinemaonline.Admin.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.entity.News;

public interface INewsRepository {
	News findById(String id);

	PagingResponse<News> findAll(int pageNumber, int pageSize);

	PagingResponse<News> searchByKey(int pageNumber, int pageSize, String searchKey);

	News edit(News news) ;

	News insert(News news);

	void delete(News news);

	News findByMaOrTen(String ma, String ten);

	News findByMaOrTenAndNotId(String ma, String ten, String id);

}
