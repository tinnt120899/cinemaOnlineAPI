package com.example.cinemaonline.tabset.controller;

import com.example.cinemaonline.Admin.constant.APIConstant;
import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.tabset.model.ListPhim;
import com.example.cinemaonline.tabset.service.IListPhimService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(APIConstant.LIST_PHIM)
@CrossOrigin
public class ListPhimController {

    @Autowired
    IListPhimService iListPhimService;

    @GetMapping("/lichchieu/{routeName}")
    List<ListPhim> getLichChieu(@PathVariable() String routeName){
        return  iListPhimService.findByNameRap(routeName);
    }

    @GetMapping("/rap/{tinhThanh}")
    List<ListPhim> getTinhThanh(@PathVariable() String tinhThanh){
        return  iListPhimService.findByTinhThanh(tinhThanh);
    }

    @GetMapping("/{id}")
    public ListPhim findById(@PathVariable("id") String id) throws ServiceException {
        return iListPhimService.findById(id);
    }

    @GetMapping()
    public PagingResponse<ListPhim> findAllListPhim(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "100") int pageSize) {
        return iListPhimService.findAll(pageNumber, pageSize);

    }

    @GetMapping(value = "/search", consumes = "application/json", produces = "application/json")
    public PagingResponse<ListPhim> searchListPhim(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String keyword
    ){
        return iListPhimService.searchByKey(page, limit, keyword);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListPhim> edit(@Valid @PathVariable("id") ObjectId id, @RequestBody ListPhim ListPhim) throws ServiceException {
        ListPhim.set_id(id);
        return ResponseEntity.ok(iListPhimService.edit(ListPhim));
    }

    @PostMapping
    public ListPhim insert(@Valid @RequestBody ListPhim ListPhim) throws ServiceException {
        return iListPhimService.insert(ListPhim);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws ServiceException {
        iListPhimService.delete(iListPhimService.findById(id));
    }
}
