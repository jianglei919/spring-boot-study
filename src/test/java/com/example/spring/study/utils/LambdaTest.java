package com.example.spring.study.utils;

import com.example.spring.study.bean.OrderModel;
import com.example.spring.study.bean.Passenger;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * Created by jianglei on 2019/6/26.
 */
public class LambdaTest {

    /**
     * list按个数分组
     */
    @Test
    public void test1() {
        List<String> list = Lists.newArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        List<List<String>> partitionList = Lists.partition(list, 2);
        System.out.println(partitionList.size());
    }

    /**
     * 找到list中第一个满足的
     */
    @Test
    public void test2() {
        List<OrderModel> modelList = getOrderModels();

        Optional<OrderModel> result = modelList.stream().filter(orderModel -> orderModel.getId() == 1).findFirst();
        System.out.println(result.orElse(null));
    }

    /**
     * 两个集合任意有一个匹配
     */
    @Test
    public void test3() {
        List<OrderModel> modelList = getOrderModels();

        List<Passenger> passengerList = getPassengers();

        boolean result = modelList.stream().anyMatch(orderModel -> passengerList.stream().anyMatch(passenger -> {
            return orderModel.getName().equals(passenger.getPassengerName()) || orderModel.getEnName().equals(passenger.getPassengerName());
        }) );
        System.out.println(result);
    }

    /**
     * list按名称去重转换为set
     */
    @Test
    public void test4() {
        List<OrderModel> modelList = getOrderModels();
        Set<String> nameSet = modelList.stream().map(OrderModel::getName).collect(Collectors.toSet());
        System.out.println(nameSet);
    }

    /**
     * list拼接
     */
    @Test
    public void test5() {

        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("a");
        list.add("b");

        Set<String> set = list.stream().map(s -> s + "@@").collect(Collectors.toSet());
        set.forEach(System.out::println);

        String result = list.stream().collect(Collectors.joining(","));
        System.out.println(result);
    }

    /**
     * set转list
     */
    @Test
    public void test6() {
        List<OrderModel> modelList = getOrderModels();
        List<Integer> idList = modelList.stream().map(OrderModel::getId).collect(Collectors.toSet()).stream().collect(Collectors.toList());
        System.out.println(idList);
    }

    /**
     * List ==> Map分组
     */
    @Test
    public void test7() {
        List<OrderModel> modelList = getOrderModels();
        Map<Integer, List<OrderModel>> map = modelList.stream().collect(Collectors.groupingBy(OrderModel::getId));
        System.out.println(map);
    }

    /**
     * list ==> map 按key去重
     */
    @Test
    public void test8() {
        List<OrderModel> modelList = getOrderModels();
        Map<Integer, OrderModel> map = modelList.stream().collect(Collectors.toMap(OrderModel::getId, o -> o, (k1, k2) -> k1));
        System.out.println(map);
    }

    /**
     * 某个属性求和
     */
    @Test
    public void test9() {
        List<OrderModel> modelList = getOrderModels();
        BigDecimal count = modelList.stream().map(OrderModel::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(count);

        int idCount = modelList.stream().collect(Collectors.summingInt(OrderModel::getId));
        System.out.println(idCount);
    }

    /**
     * 取集合中最大值和最小值
     */
    @Test
    public void test10() {

        List<OrderModel> modelList = getOrderModels();

        Optional<OrderModel> maxMoney = modelList.stream().
                collect(Collectors.maxBy(Comparator.comparing(OrderModel::getMoney)));
        maxMoney.ifPresent(System.out::println);

        Optional<OrderModel> minMoney = modelList.stream().
                collect(Collectors.minBy(Comparator.comparing(OrderModel::getMoney)));
        minMoney.ifPresent(System.out::println);

    }

    /**
     * list去重
     */
    @Test
    public void test11() {
        List<OrderModel> modelList = getOrderModels();
        List<OrderModel> uniqueList = modelList.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingLong(OrderModel::getId))), ArrayList::new));
        System.out.println(uniqueList);
    }

    /**
     * 排序
     */
    @Test
    public void test12() {
        List<OrderModel> modelList = getOrderModels();
        Collections.sort(modelList, Comparator.comparingInt(OrderModel::getId));
        System.out.println(modelList);

        modelList.sort(Comparator.comparing(OrderModel::getId).thenComparing(OrderModel::getMoney));
        System.out.println(modelList);

        //反转排序
        modelList.sort(Comparator.comparing(OrderModel::getId).thenComparing(OrderModel::getMoney).reversed());
        System.out.println(modelList);
        Collections.reverse(modelList);
    }



    private List<OrderModel> getOrderModels() {
        List<OrderModel> modelList = Lists.newArrayList();
        OrderModel o1 = new OrderModel();
        o1.setId(1);
        o1.setName("a");
        o1.setMoney(BigDecimal.TEN);

        OrderModel o2 = new OrderModel();
        o2.setId(2);
        o2.setName("b");
        o2.setMoney(new BigDecimal("31.23"));

        OrderModel o3 = new OrderModel();
        o3.setId(2);
        o3.setName("c");
        o3.setMoney(new BigDecimal("76.39"));

        modelList.add(o1);
        modelList.add(o3);
        modelList.add(o2);

        return modelList;
    }

    private List<Passenger> getPassengers() {
        List<Passenger> modelList = Lists.newArrayList();
        Passenger p1 = new Passenger();
        p1.setPassengerName("a");
        modelList.add(p1);

        Passenger p2 = new Passenger();
        p2.setPassengerName("c");
        modelList.add(p2);
        return modelList;
    }
}
