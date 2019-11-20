package com.example.cinemaonline.tabset.controller;

import com.example.cinemaonline.tabset.model.ListPhim;
import com.example.cinemaonline.tabset.service.IListPhimService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListPhimController {

    @Autowired
    IListPhimService iListPhimService;

    @GetMapping("/lichchieu")
    List<ListPhim> getListPhimDangChieu(){
        return  iListPhimService.getListPhimDangChieu();
    }

    @GetMapping("/{routeName}")
    List<ListPhim> getLichChieu(@PathVariable String routeName){
        return  iListPhimService.findByNameRap(routeName);
    }

    @GetMapping("thongtinphim/{_id}")
    List<ListPhim> getThongTinPhim(@PathVariable String _id){
        return  iListPhimService.findById(_id);
    }

    @GetMapping("lichchieu/{tinhThanh}")
    List<ListPhim> getTinhThanh(@PathVariable String tinhThanh){
        return  iListPhimService.findByTinhThanh(tinhThanh);
    }
}
