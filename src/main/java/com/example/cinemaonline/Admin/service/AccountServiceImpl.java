package com.example.cinemaonline.Admin.service;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.entity.Account;
import com.example.cinemaonline.Admin.enumeration.CategoryErrorEnum;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.Admin.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService{
	private String error;
	@Autowired
	IAccountRepository iAccountRepository;

	@Override
	public Account findById(String id) throws ServiceException {
		Account Account = iAccountRepository.findById(id);
		if(Account == null) {
			throw new ServiceException(CategoryErrorEnum.TIN_TUC_NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
		}
		return Account;
	}

	@Override
	public PagingResponse<Account> findAll(int pageNumber, int pageSize) {
		return iAccountRepository.findAll(pageNumber, pageSize);
	}

	@Override
	public PagingResponse<Account> searchByKey(int pageNumber, int pageSize, String searchKey) {
		
		if (searchKey == null || searchKey.isEmpty()) {
            return iAccountRepository.findAll(pageNumber, pageSize);
        }		
		return iAccountRepository.searchByKey(pageNumber, pageSize, searchKey);
	}

	@Override
	public Account edit(Account Account) throws ServiceException {
		Account existedAccount = iAccountRepository.findByMaOrTenAndNotId(
				Account.getId(),
				Account.getUsername(),
				Account.getEmail(),
				Account.get_id()
		);

		if (existedAccount != null) {
			throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.BAD_REQUEST);
		}

		return iAccountRepository.edit(Account);
	}

	@Override
	public Account insert(Account Account) throws ServiceException {
		if(findByMaOrTen(Account.getId(), Account.getUsername(), Account.getEmail()) != null) {
			throw new ServiceException(CategoryErrorEnum.TIN_TUC_EXISTED.getDescription(), HttpStatus.NOT_ACCEPTABLE);
		}
		return iAccountRepository.insert(Account);
	}

	@Override
	public void delete(Account Account) {
		iAccountRepository.delete(Account);
	}


	public Account findByMaOrTen(String ma, String ten, String email) {
		return iAccountRepository.findByMaOrTen(ma, ten, email);
	}


	public Account checkLogin(String ma, String ten) {
		return iAccountRepository.checkLogin(ma, ten);
	}
}
