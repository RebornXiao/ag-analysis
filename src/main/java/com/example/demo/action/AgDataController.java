package com.example.demo.action;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("ag")
public class AgDataController {

    @Resource
    AgDataService agDataService;

    @Resource
    AgData50Service agData50Service;

    @Resource
    AgData100Service agData100Service;

    @Resource
    AgData150Service agData150Service;

    @Resource
    AgData200Service agData200Service;

    int lirun = 0;
    int kuisun = 0;
    List<AgData> lostList = new ArrayList<>();
    List<AgDataMakeMoney50> makeMoney50List = new ArrayList<>();
    List<AgDataMakeMoney100> makeMoney100List = new ArrayList<>();
    List<AgDataMakeMoney150> makeMoney150List = new ArrayList<>();
    List<AgDataMakeMoney200> makeMoney200List = new ArrayList<>();
    int bigDay = 0;
    AgData bigDayTime;

    int day10 = 0;
    int day20 = 0;
    int day30 = 0;
    int day40 = 0;
    int day50 = 0;
    int day60 = 0;
    int day70 = 0;
    int day80 = 0;
    int day90 = 0;
    int day100 = 0;
    int day120 = 0;
    int day150 = 0;
    int day200 = 0;
    int day250 = 0;
    int day300 = 0;
    int dayBig = 0;


    @RequestMapping("put")
    public String put() {
        AgData agData = new AgData();
        agDataService.save(agData);
        return "ok";
    }

    @RequestMapping("all")
    public Iterable<AgData> getAll() {
        return agDataService.getAll();
    }

    @RequestMapping("one")
    public AgData getOne(Integer id) {
        return agDataService.findOne(id);
    }

    @RequestMapping("init")
    public String initData() {
        // 得到表格中所有的数据
        List<AgData> listExcel = agDataService.getAllByExcel("d://ag.xls");
        if (listExcel.size() > 0) {
            for (int i = 0, size = listExcel.size(); i < size; i++) {
                agDataService.save(listExcel.get(i));
            }
        }
        return "ok";
    }


    @RequestMapping("test50")
    public String test50() {
        agData50Service.test50Data();
        return "ok";
    }

    @RequestMapping("test100")
    public String test100() {
        agData100Service.test100Data();
        return "ok";
    }

    @RequestMapping("test150")
    public String test150() {
        agData150Service.test150Data();
        return "ok";
    }

    @RequestMapping("test200")
    public String test200() {
        agData200Service.test200Data();
        return "ok";
    }

    @RequestMapping("data")
    public void getData(){
        agData200Service.save(agDataService.testPriceAdd());
    }




}
