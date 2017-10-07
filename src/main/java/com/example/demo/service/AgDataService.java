package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.model.*;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class AgDataService {

    @Resource
    private AgDataRepository agDataRepository;

    @Resource
    private AgDataMakeMoney50Repository agDataMakeMoney50Repository;
    @Resource
    private AgDataMakeMoney100Repository agDataMakeMoney100Repository;
    @Resource
    private AgDataMakeMoney150Repository agDataMakeMoney150Repository;
    @Resource
    private AgDataMakeMoney200Repository agDataMakeMoney200Repository;

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

    @Transactional
    public void save(AgData agData) {
        agDataRepository.save(agData);
    }

    public List<AgData> getAll() {
        return (List<AgData>) agDataRepository.findAll();
    }

    public long count() {
        return agDataRepository.count();
    }

    public AgData findOne(Integer id) {
        return agDataRepository.findOne(id);
    }

    /**
     * 查询指定目录中电子表格中所有的数据
     *
     * @param file 文件完整路径
     * @return
     */
    public List<AgData> getAllByExcel(String file) {
        List<AgData> list = new ArrayList<AgData>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
            int clos = rs.getColumns();// 得到所有的列
            int rows = rs.getRows();// 得到所有的行

            System.out.println(clos + " rows:" + rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    // 第一个是列数，第二个是行数
                    String date = rs.getCell(j++, i).getContents();// 日期//默认最左边编号也算一列
                    // 所以这里得j++
                    String name = rs.getCell(j++, i).getContents();// 合约名称
                    String open = rs.getCell(j++, i).getContents();// 开盘价
                    String max = rs.getCell(j++, i).getContents();// 最高价
                    String min = rs.getCell(j++, i).getContents();// 最低价
                    String close = rs.getCell(j++, i).getContents();// 收盘价
                    String change = rs.getCell(j++, i).getContents();// 涨跌额
                    String change_range = rs.getCell(j++, i).getContents();// 涨跌幅度
                    String average = rs.getCell(j++, i).getContents();// 加权平均价
                    String turnover = rs.getCell(j++, i).getContents();// 成交量公斤
                    String turnover_money = rs.getCell(j++, i).getContents();// 成交金额
                    AgData agData = new AgData();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    Date time = sdf.parse(date);
                    agData.setTime(date);

                    double openDou = Double.parseDouble(open);
                    Integer open_price = Integer.valueOf((int) (openDou));
                    agData.setOpen_price(open_price);

                    double maxDou = Double.parseDouble(max);
                    Integer max_price = Integer.valueOf((int) (maxDou));
                    agData.setMax_price(max_price);

                    double minDou = Double.parseDouble(min);
                    Integer min_price = Integer.valueOf((int) (minDou));
                    agData.setMin_price(min_price);

                    double closeDou = Double.parseDouble(close);
                    Integer close_price = Integer.valueOf((int) (closeDou));
                    agData.setClose_price(close_price);

                    if (change.startsWith("-")) {
                        change = change.replace("-", "");
                    }
                    double changeDou = Double.parseDouble(change);
                    Integer change_price = Integer.valueOf((int) (changeDou));
                    agData.setChange_amount(change_price);

                    String changeType = "+";

                    String changeStr = change_range.replace("%", "");
                    if (changeStr.startsWith("-")) {
                        changeType = "-";
                    }

                    if (changeStr.equals("--")) {
                        agData.setChange_range(0d);
                        agData.setChange_type("+");
                    } else {
                        double changDou = Double.parseDouble(changeStr);
                        agData.setChange_range(changDou);
                        agData.setChange_type(changeType);
                    }

                    if (average.equals("--")) {
                        agData.setAverage_price(0);
                    } else {
                        double avergeDou = Double.parseDouble(average);
                        Integer avergeInt = Integer.valueOf((int) avergeDou);
                        agData.setAverage_price(avergeInt);
                    }

                    if (turnover.equals("--")) {
                        agData.setTurnover(0);
                    } else {
                        double turnoverDou = Double.parseDouble(turnover);
                        Integer turnoverInt = Integer.valueOf((int) (turnoverDou));
                        agData.setTurnover(turnoverInt);
                    }

                    if (turnover_money.equals("--")) {
                        agData.setTurnover_premium(0L);
                    } else {
                        double turnoverMoneyDou = Double.parseDouble(turnover_money);
                        Long turnoverLong = Long.valueOf((long) (turnoverMoneyDou));
                        agData.setTurnover_premium(turnoverLong);
                    }
                    list.add(agData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    /**
     * 测试得到数据
     */
    public List<AgDataMakeMoney200> testPriceAdd() {
        int failSize = 0;
        List<AgData> allByDb = getAll();
        Collections.reverse(allByDb);// 反向排序
        for (int i = 0, size = allByDb.size(); i < size; i++) {
            makeMoney200List.add(new AgDataMakeMoney200(allByDb.get(i)));
        }
        for (int i = 0; i < 2500; i++) {
            if (!testPrice(allByDb, i, 50, 200)) {
                failSize++;
            }
        }
        System.out.println("失败次数：" + failSize);
        System.out.println("一共赚取利润：" + lirun);// 1250100:100;442600:50
        System.out.println("等待最长时间：" + bigDay + ":" + bigDayTime.toString());
        System.out.println("一共损失利润：" + kuisun + "；损失时间：" + lostList.toString());
        return makeMoney200List;

    }

    public boolean testPrice(List<AgData> allByDb, int number, int price, int superprofit) {

        int profit = 0;// 利润
        int buyNumber = 1;// 购买数量
        int buyPrice = allByDb.get(number).getClose_price();// 购买价
        int buyPriceMin = buyPrice;// 目前购买的最低价
        int buyAverage = buyPrice;// 目前购买的平均价

        System.out.println(allByDb.get(number).getTime() + "进场");
        for (int i = number + 1, j = allByDb.size(); i < j; i++) {
            AgData agData = allByDb.get(i);
            if (agData.getMax_price() - buyAverage >= superprofit) {
                profit = buyNumber * superprofit;
                System.out.println(
                        allByDb.get(i).getTime() + "持有" + buyNumber + "手，赚取利润=" + profit + ",等了" + (i - number) + "天");
                lirun = lirun + profit;
                if (bigDay < i - number) {
                    bigDay = i - number;
                    bigDayTime = allByDb.get(number);
                }
                AgDataMakeMoney200 makeMoney = makeMoney200List.get(number);
                makeMoney.setAddProfitThisModel(price);
                makeMoney.setAddMoneyProfit(superprofit);
                makeMoney.setDayAll(i - number);
                makeMoney.setProfitAll(profit);
                makeMoney.setLossAll(0);
                makeMoney.setHavaNumber(buyNumber);
                makeMoney200List.set(number, makeMoney);
                return true;
            }
            if (buyPriceMin - agData.getMin_price() >= price) {
                int buynumbertmp = (buyPriceMin - agData.getMin_price()) / price;
                buyNumber = buyNumber + buynumbertmp;
                buyPriceMin = buyPriceMin - buynumbertmp * price;
                buyAverage = (buyPrice + buyPriceMin) / 2;
                System.out.println(allByDb.get(i).getTime() + "购买" + buynumbertmp + "手，持有" + buyNumber + "手");
            }
            if (i == (allByDb.size() - 1)) {
                System.out.println("数据全部跑完啦！目前砸手上" + buyNumber + "手,持仓均价" + buyAverage + ",最后收盘价"
                        + allByDb.get(i).getClose_price());
                lostList.add(allByDb.get(number));
                AgDataMakeMoney200 makeMoney = makeMoney200List.get(number);
                makeMoney.setAddProfitThisModel(price);
                makeMoney.setAddMoneyProfit(superprofit);
                makeMoney.setDayAll(i - number);
                makeMoney.setProfitAll(0);
                makeMoney.setLossAll((allByDb.get(i).getClose_price() - buyAverage) * buyNumber);
                makeMoney.setHavaNumber(buyNumber);
                makeMoney200List.set(number, makeMoney);
                kuisun = kuisun + (buyAverage - allByDb.get(i).getClose_price()) * buyNumber;
            }
        }
        return false;
    }



}
