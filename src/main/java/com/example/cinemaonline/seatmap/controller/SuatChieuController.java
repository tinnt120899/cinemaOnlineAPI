package com.example.cinemaonline.seatmap.controller;

import com.example.cinemaonline.Admin.constant.APIConstant;
import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.seatmap.model.SuatChieu;
import com.example.cinemaonline.seatmap.service.ISuatChieuService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(APIConstant.SUAT_CHIEU)
@CrossOrigin
public class SuatChieuController {

    @Autowired
    ISuatChieuService iSuatChieuService;

    @GetMapping("/danhsachsuatchieu/{idSuatChieu}")
    List<SuatChieu> getSuatChieuById(@PathVariable String idSuatChieu){
        return  iSuatChieuService.findByIdSuatChieu(idSuatChieu);
    }

    @GetMapping("/{id}")
    public SuatChieu findById(@PathVariable("id") String id) throws ServiceException {
        return iSuatChieuService.findById(id);
    }

    @GetMapping()
    public PagingResponse<SuatChieu> findAllSuatChieu(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return iSuatChieuService.findAll(pageNumber, pageSize);

    }

    @GetMapping(value = "/search", consumes = "application/json", produces = "application/json")
    public PagingResponse<SuatChieu> searchSuatChieu(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String keyword
    ){
        return iSuatChieuService.searchByKey(page, limit, keyword);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuatChieu> edit(@Valid @PathVariable("id") ObjectId id, @RequestBody SuatChieu SuatChieu) throws ServiceException {
        SuatChieu.set_id(id);
        return ResponseEntity.ok(iSuatChieuService.edit(SuatChieu));
    }

    @PostMapping
    public SuatChieu insert(@Valid @RequestBody SuatChieu SuatChieu) throws ServiceException {
        return iSuatChieuService.insert(SuatChieu);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws ServiceException {
        iSuatChieuService.delete(iSuatChieuService.findById(id));
    }
}
