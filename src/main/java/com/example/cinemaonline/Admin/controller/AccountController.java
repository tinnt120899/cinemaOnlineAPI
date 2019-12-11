package com.example.cinemaonline.Admin.controller;

import com.example.cinemaonline.Admin.constant.APIConstant;
import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.entity.Account;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.Admin.service.IAccountService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(APIConstant.ACCOUNT)
@CrossOrigin
public class AccountController {

	@Autowired
	IAccountService iAccountService;

	@GetMapping("/{id}")
	public Account findById(@PathVariable("id") String id) throws ServiceException {
		return iAccountService.findById(id);
	}

	@GetMapping("/signin")
	List<Account> getAll(
			@RequestParam("username") String username,
			@RequestParam("password") String password
	){
		return  iAccountService.checkLogin(username, password);
	}

	@GetMapping()
	public PagingResponse<Account> findAllAccount(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		return iAccountService.findAll(pageNumber, pageSize);

	}

	@GetMapping(value = "/search", consumes = "application/json", produces = "application/json")
	public PagingResponse<Account> searchAccount(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,
			@RequestParam(required = false) String keyword
	){
		return iAccountService.searchByKey(page, limit, keyword);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> edit(@Valid @PathVariable("id") ObjectId id, @RequestBody Account Account) throws ServiceException {
		Account.set_id(id);
		return ResponseEntity.ok(iAccountService.edit(Account));
	}

	@PostMapping
	public Account insert(@Valid @RequestBody Account Account) throws ServiceException {
		return iAccountService.insert(Account);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) throws ServiceException {
		iAccountService.delete(iAccountService.findById(id));
	}

}
