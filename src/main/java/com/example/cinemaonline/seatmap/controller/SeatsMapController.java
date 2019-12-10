package com.example.cinemaonline.seatmap.controller;

import com.example.cinemaonline.Admin.constant.APIConstant;
import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.exception.ServiceException;
import com.example.cinemaonline.seatmap.model.SeatsMap;
import com.example.cinemaonline.seatmap.service.ISeatsMapService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(APIConstant.SEAT_MAP)
@CrossOrigin
public class SeatsMapController {

    @Autowired
    ISeatsMapService iSeatsMapService;

    @GetMapping("/danhsachghe/{idSeatMap}")
    SeatsMap getSeatMapById(@PathVariable String idSeatMap){
        return  iSeatsMapService.findByIdSeatMap(idSeatMap);
    }

    @GetMapping("/{id}")
    public SeatsMap findById(@PathVariable("id") String id) throws ServiceException {
        return iSeatsMapService.findById(id);
    }

    @GetMapping()
    public PagingResponse<SeatsMap> findAllSeatsMap(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return iSeatsMapService.findAll(pageNumber, pageSize);

    }

    @GetMapping(value = "/search", consumes = "application/json", produces = "application/json")
    public PagingResponse<SeatsMap> searchSeatsMap(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String keyword
    ){
        return iSeatsMapService.searchByKey(page, limit, keyword);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeatsMap> edit(@Valid @PathVariable("id") ObjectId id, @RequestBody SeatsMap SeatsMap) throws ServiceException {
        SeatsMap.set_id(id);
        return ResponseEntity.ok(iSeatsMapService.edit(SeatsMap));
    }

    @PostMapping
    public SeatsMap insert(@Valid @RequestBody SeatsMap SeatsMap) throws ServiceException {
        return iSeatsMapService.insert(SeatsMap);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws ServiceException {
        iSeatsMapService.delete(iSeatsMapService.findById(id));
    }
}
