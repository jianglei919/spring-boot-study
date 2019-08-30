package com.example.spring.study.model;

import java.math.BigDecimal;
import java.util.Date;

public class FlightInfoModel {
    private Long id;

    private Long orderId;

    private String orderNo;

    private String airlineCompanyCode;

    private String departureCityCode;

    private String arrivalCityCode;

    private String departureAirportCode;

    private String arrivalAirportCode;

    private String stopAirportCode;

    private String flightNo;

    private Integer luggageNum;

    private BigDecimal luggageWeight;

    private String departureDate;

    private Date departureTime;

    private Date arrivalTime;

    private Integer constructionFee;

    private Integer fuelFee;

    private String planeType;

    private Integer stayDays;

    private String createTime;

    private Date updateTime;

    private Integer voyageNo;

    private String takeoffTerminal;

    private String landingTerminal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getAirlineCompanyCode() {
        return airlineCompanyCode;
    }

    public void setAirlineCompanyCode(String airlineCompanyCode) {
        this.airlineCompanyCode = airlineCompanyCode == null ? null : airlineCompanyCode.trim();
    }

    public String getDepartureCityCode() {
        return departureCityCode;
    }

    public void setDepartureCityCode(String departureCityCode) {
        this.departureCityCode = departureCityCode == null ? null : departureCityCode.trim();
    }

    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        this.arrivalCityCode = arrivalCityCode == null ? null : arrivalCityCode.trim();
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode == null ? null : departureAirportCode.trim();
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode == null ? null : arrivalAirportCode.trim();
    }

    public String getStopAirportCode() {
        return stopAirportCode;
    }

    public void setStopAirportCode(String stopAirportCode) {
        this.stopAirportCode = stopAirportCode == null ? null : stopAirportCode.trim();
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo == null ? null : flightNo.trim();
    }

    public Integer getLuggageNum() {
        return luggageNum;
    }

    public void setLuggageNum(Integer luggageNum) {
        this.luggageNum = luggageNum;
    }

    public BigDecimal getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(BigDecimal luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getConstructionFee() {
        return constructionFee;
    }

    public void setConstructionFee(Integer constructionFee) {
        this.constructionFee = constructionFee;
    }

    public Integer getFuelFee() {
        return fuelFee;
    }

    public void setFuelFee(Integer fuelFee) {
        this.fuelFee = fuelFee;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType == null ? null : planeType.trim();
    }

    public Integer getStayDays() {
        return stayDays;
    }

    public void setStayDays(Integer stayDays) {
        this.stayDays = stayDays;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVoyageNo() {
        return voyageNo;
    }

    public void setVoyageNo(Integer voyageNo) {
        this.voyageNo = voyageNo;
    }

    public String getTakeoffTerminal() {
        return takeoffTerminal;
    }

    public void setTakeoffTerminal(String takeoffTerminal) {
        this.takeoffTerminal = takeoffTerminal == null ? null : takeoffTerminal.trim();
    }

    public String getLandingTerminal() {
        return landingTerminal;
    }

    public void setLandingTerminal(String landingTerminal) {
        this.landingTerminal = landingTerminal == null ? null : landingTerminal.trim();
    }
}