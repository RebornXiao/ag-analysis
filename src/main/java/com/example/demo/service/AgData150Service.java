package com.example.demo.service;

import com.example.demo.dao.AgDataMakeMoney150Repository;
import com.example.demo.model.AgDataMakeMoney150;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgData150Service {


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


    @Resource
    private AgDataMakeMoney150Repository agDataMakeMoney150Repository;

    @Transactional
    public void save(AgDataMakeMoney150 agData) {
        agDataMakeMoney150Repository.save(agData);
    }

    public List<AgDataMakeMoney150> getAll() {
        return (List<AgDataMakeMoney150>) agDataMakeMoney150Repository.findAll();
    }

    public long count() {
        return agDataMakeMoney150Repository.count();
    }

    public AgDataMakeMoney150 findOne(Integer id) {
        return agDataMakeMoney150Repository.findOne(id);
    }

    @Transactional
    public void save(List<AgDataMakeMoney150> agDataMakeMoney150List) {
        agDataMakeMoney150Repository.save(agDataMakeMoney150List);
    }

    public void test150Data() {
        int day = 0;
        int price = 0;
        int daySum = 0;
        int moneyDay = 0;
        int numMax = 10;
        int number = 0;
        int makeMoney = 0;
        List<AgDataMakeMoney150> moneyDayBig = new ArrayList<>();
        List<AgDataMakeMoney150> moneyByDb = getAll();
        for (int i = 0; i < 2500; i++) {
            AgDataMakeMoney150 agDataMakeMoney = moneyByDb.get(i);
            if (agDataMakeMoney.getAddMoneyProfit() == 200) {
                if (agDataMakeMoney.getDayAll() <= 5000) {
                    day++;
                    price = price + agDataMakeMoney.getClose_price();
                    moneyDay = moneyDay + agDataMakeMoney.getDayAll();
                    number = number + agDataMakeMoney.getHavaNumber();
                    makeMoney = makeMoney + agDataMakeMoney.getProfitAll();
                    if (agDataMakeMoney.getHavaNumber() > 30) {
                        moneyDayBig.add(agDataMakeMoney);
                    }
                    if (numMax < agDataMakeMoney.getHavaNumber()) {
                        numMax = agDataMakeMoney.getHavaNumber();
                        System.out.println("计入脑海的一天:" + agDataMakeMoney.toString());
                    }
                } else if (agDataMakeMoney.getDayAll() > 5000) {
                    daySum++;
                }
                stepNumber(moneyByDb.get(i));
            }
        }
//        System.out.println("赚钱大于30小于5000的天数：" + daySum+";分别是："+moneyDayBig.toString());
        System.out.println("赚钱 共计天数：" + (day - daySum) + ";价格：" + price / (day - daySum) + ";平均持有天数："
                + moneyDay / (day - daySum) + ";平均每次赚钱：" + makeMoney / (day - daySum) + ";平均持仓数量："
                + number / (day - daySum) + ";持仓最大数量:" + numMax);
        System.out.println("最终预计收入:" + makeMoney / (day - daySum) * 5 * 2650 / moneyDay * (day - daySum) / 7);
        System.out.println("天数区间:" +
                "小于10天：" + day10 +
                "；小于20天：" + day20 +
                "；小于30天：" + day30 +
                "；小于40天：" + day40 +
                "；小于50天：" + day50 +
                "；小于60天：" + day60 +
                "；小于70天：" + day70 +
                "；小于80天：" + day80 +
                "；小于90天：" + day90 +
                "；小于100天：" + day100 +
                "；小于120天：" + day120 +
                "；小于150天：" + day150 +
                "；小于200天：" + day200 +
                "；小于250天：" + day250 +
                "；小于300天：" + day300
        );
    }

    private void stepNumber(AgDataMakeMoney150 AgDataMakeMoney150) {
        int day = AgDataMakeMoney150.getDayAll();
        if (day <= 10) {
            day10++;
            return;
        }
        if (day > 10 && day <= 20) {
            day20++;
            return;
        }
        if (day > 20 && day <= 30) {
            day30++;
            return;
        }
        if (day > 30 && day <= 40) {
            day40++;
            return;
        }
        if (day > 40 && day <= 50) {
            day50++;
            return;
        }
        if (day > 50 && day <= 60) {
            day60++;
            return;
        }
        if (day > 60 && day <= 70) {
            day70++;
            return;
        }
        if (day > 70 && day <= 80) {
            day80++;
            return;
        }
        if (day > 80 && day <= 90) {
            day90++;
            return;
        }
        if (day > 90 && day <= 100) {
            day100++;
            return;
        }
        if (day > 100 && day <= 120) {
            day120++;
            return;
        }
        if (day > 120 && day <= 150) {
            day150++;
            return;
        }
        if (day > 150 && day <= 200) {
            day200++;
            return;
        }
        if (day > 200 && day <= 300) {
            day300++;
            return;
        }
        if (day > 300) {
            dayBig++;
            return;
        }
    }

}
