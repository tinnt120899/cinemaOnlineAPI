package com.example.cinemaonline.listgroup.controller;

import com.example.cinemaonline.Admin.constant.APIConstant;
import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.listgroup.model.HeThongRap;
import com.example.cinemaonline.listgroup.service.IHeThongRapService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(APIConstant.HE_THONG_RAP)
@RestController
@CrossOrigin
public class HeThongRapController {
    @Autowired
    IHeThongRapService iHeThongRapService;

    @GetMapping("/tinhthanh")
    List<HeThongRap> getAll(
            @RequestParam("tinhThanh") String tinhThanh
    ){
        return iHeThongRapService.findByName(tinhThanh);
    }

    @GetMapping("/{id}")
    public HeThongRap findById(@PathVariable("id") String id) throws ServiceException {
        System.out.println("id"+id);
        return iHeThongRapService.findById(id);
    }

    @GetMapping()
    public PagingResponse<HeThongRap> findAllHeThongRap(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return iHeThongRapService.findAll(pageNumber, pageSize);

    }

    @GetMapping(value = "/search", consumes = "application/json", produces = "application/json")
    public PagingResponse<HeThongRap> searchHeThongRap(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String keyword
    ){
        return iHeThongRapService.searchByKey(page, limit, keyword);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeThongRap> edit(@Valid @PathVariable("id") ObjectId id, @RequestBody HeThongRap HeThongRap) throws ServiceException {
        HeThongRap.set_id(id);
        return ResponseEntity.ok(iHeThongRapService.edit(HeThongRap));
    }

    @PostMapping
    public HeThongRap insert(@Valid @RequestBody HeThongRap HeThongRap) throws ServiceException {
        return iHeThongRapService.insert(HeThongRap);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws ServiceException {
        iHeThongRapService.delete(iHeThongRapService.findById(id));
    }
}
