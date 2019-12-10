package com.example.cinemaonline.Admin.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.entity.News;
import com.example.cinemaonline.Admin.enumeration.CategoryErrorEnum;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.Admin.repository.INewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements INewsService{
	
	@Autowired
	INewsRepository iNewsRepository;

	@Override
	public News findById(String id) throws ServiceException {
		News News = iNewsRepository.findById(id);
		if(News == null) {
			throw new ServiceException(CategoryErrorEnum.TIN_TUC_NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
		}
		return News;
	}

	@Override
	public PagingResponse<News> findAll(int pageNumber, int pageSize) {
		return iNewsRepository.findAll(pageNumber, pageSize);
	}

	@Override
	public PagingResponse<News> searchByKey(int pageNumber, int pageSize, String searchKey) {
		
		if (searchKey == null || searchKey.isEmpty()) {
            return iNewsRepository.findAll(pageNumber, pageSize);
        }		
		return iNewsRepository.searchByKey(pageNumber, pageSize, searchKey);
	}

	@Override
	public News edit(News news) throws ServiceException {
		News existedNews = iNewsRepository.findByMaOrTenAndNotId(
				news.getMaTinTuc(),
				news.getTieuDe(),
				news.get_id()
		);

		if (existedNews != null) {
			throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.BAD_REQUEST);
		}

		return iNewsRepository.edit(news);
	}

	@Override
	public News insert(News news) throws ServiceException {
		if(findByMaOrTen(news.getMaTinTuc(), news.getTieuDe()) != null) {
			throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.NOT_ACCEPTABLE);
		}
		return iNewsRepository.insert(news);
	}

	@Override
	public void delete(News news) {
		iNewsRepository.delete(news);
	}


	public News findByMaOrTen(String ma, String ten) {
		return iNewsRepository.findByMaOrTen(ma, ten);
	}
}
