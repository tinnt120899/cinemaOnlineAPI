package com.example.cinemaonline.Admin.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.entity.News;
import com.example.cinemaonline.Admin.exception.ServiceException;

public interface INewsService {
	
	News findById(String id) throws ServiceException;

	PagingResponse<News> findAll(int pageNumber, int pageSize);

	PagingResponse<News> searchByKey(int pageNumber, int pageSize, String searchKey) ;

	News edit(News news) throws ServiceException;

	News insert(News news) throws ServiceException;

	void delete(News news);
	
	
}
