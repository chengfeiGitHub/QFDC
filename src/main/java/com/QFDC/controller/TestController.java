package com.QFDC.controller;

import com.QFDC.bean.YanData;
import com.QFDC.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private DataBaseService dataBaseService;

    @RequestMapping(value = "/getData",method = RequestMethod.GET)
    public List<YanData> getData(){
        return dataBaseService.getData();
    }



}
