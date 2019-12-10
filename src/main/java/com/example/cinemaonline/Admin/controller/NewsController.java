package com.example.cinemaonline.Admin.controller;

import com.example.cinemaonline.Admin.constant.APIConstant;
import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.entity.News;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.Admin.service.INewsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(APIConstant.TIN_TUC)
@CrossOrigin
public class NewsController {

	@Autowired
	INewsService iNewsService;

	@GetMapping("/{id}")
	public News findById(@PathVariable("id") String id) throws ServiceException {
		return iNewsService.findById(id);
	}

	@GetMapping()
	public PagingResponse<News> findAllNews(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		return iNewsService.findAll(pageNumber, pageSize);

	}

	@GetMapping(value = "/search", consumes = "application/json", produces = "application/json")
	public PagingResponse<News> searchNews(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,
			@RequestParam(required = false) String keyword
	){
		return iNewsService.searchByKey(page, limit, keyword);
	}

	@PutMapping("/{id}")
	public ResponseEntity<News> edit(@Valid @PathVariable("id") ObjectId id, @RequestBody News news) throws ServiceException {
		news.set_id(id);
		return ResponseEntity.ok(iNewsService.edit(news));
	}

	@PostMapping
	public News insert(@Valid @RequestBody News news) throws ServiceException {
		return iNewsService.insert(news);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) throws ServiceException {
		iNewsService.delete(iNewsService.findById(id));
	}

}
