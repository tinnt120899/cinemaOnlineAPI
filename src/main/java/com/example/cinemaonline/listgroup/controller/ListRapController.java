package com.example.cinemaonline.listgroup.controller;

import com.example.cinemaonline.Admin.constant.APIConstant;
import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.listgroup.model.ListRap;
import com.example.cinemaonline.listgroup.service.IListRapService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(APIConstant.LIST_RAP)
@CrossOrigin
public class ListRapController {

    @Autowired
    IListRapService iListRapService;

    @GetMapping("/dk")
    List<ListRap> getAll(
            @RequestParam("heThongRap") String heThongRap,
            @RequestParam("cumRap") String cumRap
    ){
        return  iListRapService.findByName(heThongRap, cumRap);
    }

    @GetMapping("/{id}")
    public ListRap findById(@PathVariable("id") String id) throws ServiceException {
        System.out.println("id"+id);
        return iListRapService.findById(id);
    }

    @GetMapping()
    public PagingResponse<ListRap> findAllListRap(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return iListRapService.findAll(pageNumber, pageSize);

    }

    @GetMapping(value = "/search", consumes = "application/json", produces = "application/json")
    public PagingResponse<ListRap> searchListRap(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String keyword
    ){
        return iListRapService.searchByKey(page, limit, keyword);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListRap> edit(@Valid @PathVariable("id") ObjectId id, @RequestBody ListRap ListRap) throws ServiceException {
        ListRap.set_id(id);
        return ResponseEntity.ok(iListRapService.edit(ListRap));
    }

    @PostMapping
    public ListRap insert(@Valid @RequestBody ListRap ListRap) throws ServiceException {
        return iListRapService.insert(ListRap);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws ServiceException {
        iListRapService.delete(iListRapService.findById(id));
    }

}
