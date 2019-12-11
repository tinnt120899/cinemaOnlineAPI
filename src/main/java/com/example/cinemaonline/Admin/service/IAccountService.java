package com.example.cinemaonline.Admin.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.entity.Account;
import com.example.cinemaonline.Admin.exception.ServiceException;

import java.util.List;

public interface IAccountService {
	
	Account findById(String id) throws ServiceException;

	PagingResponse<Account> findAll(int pageNumber, int pageSize);

	PagingResponse<Account> searchByKey(int pageNumber, int pageSize, String searchKey) ;

	Account edit(Account Account) throws ServiceException;

	Account insert(Account Account) throws ServiceException;

	void delete(Account Account);

	List<Account> checkLogin (String ma, String ten);
	
	
}
