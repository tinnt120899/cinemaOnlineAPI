package com.example.cinemaonline.seatmap.controller;

import com.example.cinemaonline.Admin.constant.APIConstant;
import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.seatmap.model.NgayChieu;
import com.example.cinemaonline.seatmap.service.INgayChieuService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(APIConstant.NGAY_CHIEU)
@CrossOrigin
public class NgayChieuController {

    @Autowired
    INgayChieuService iNgayChieuService;

    @GetMapping("/phim/{idPhim}")
    List<NgayChieu> getNgayChieuByIdPhim(@PathVariable String idPhim){
        return  iNgayChieuService.findByIdPhim(idPhim);
    }

    @GetMapping("/{id}")
    public NgayChieu findById(@PathVariable("id") String id) throws ServiceException {
        return iNgayChieuService.findById(id);
    }

    @GetMapping()
    public PagingResponse<NgayChieu> findAllNgayChieu(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return iNgayChieuService.findAll(pageNumber, pageSize);

    }

    @GetMapping(value = "/search", consumes = "application/json", produces = "application/json")
    public PagingResponse<NgayChieu> searchNgayChieu(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String keyword
    ){
        return iNgayChieuService.searchByKey(page, limit, keyword);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NgayChieu> edit(@Valid @PathVariable("id") ObjectId id, @RequestBody NgayChieu NgayChieu) throws ServiceException {
        NgayChieu.set_id(id);
        return ResponseEntity.ok(iNgayChieuService.edit(NgayChieu));
    }

    @PostMapping
    public NgayChieu insert(@Valid @RequestBody NgayChieu NgayChieu) throws ServiceException {
        return iNgayChieuService.insert(NgayChieu);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws ServiceException {
        iNgayChieuService.delete(iNgayChieuService.findById(id));
    }
}
