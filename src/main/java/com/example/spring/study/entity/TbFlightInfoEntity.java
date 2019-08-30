package com.example.spring.study.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by jianglei on 2019/8/27.
 */
@Entity
@Table(name = "tb_flight_info", schema = "f_fin_srm", catalog = "")
public class TbFlightInfoEntity {
    private long id;
    private long orderId;
    private String orderNo;
    private String airlineCompanyCode;
    private String departureCityCode;
    private String arrivalCityCode;
    private String departureAirportCode;
    private String arrivalAirportCode;
    private String stopAirportCode;
    private String flightNo;
    private byte luggageNum;
    private BigDecimal luggageWeight;
    private Date departureDate;
    private Time departureTime;
    private Time arrivalTime;
    private short constructionFee;
    private short fuelFee;
    private String planeType;
    private short stayDays;
    private Timestamp createTime;
    private Timestamp updateTime;
    private byte voyageNo;
    private String takeoffTerminal;
    private String landingTerminal;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_no")
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Basic
    @Column(name = "airline_company_code")
    public String getAirlineCompanyCode() {
        return airlineCompanyCode;
    }

    public void setAirlineCompanyCode(String airlineCompanyCode) {
        this.airlineCompanyCode = airlineCompanyCode;
    }

    @Basic
    @Column(name = "departure_city_code")
    public String getDepartureCityCode() {
        return departureCityCode;
    }

    public void setDepartureCityCode(String departureCityCode) {
        this.departureCityCode = departureCityCode;
    }

    @Basic
    @Column(name = "arrival_city_code")
    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        this.arrivalCityCode = arrivalCityCode;
    }

    @Basic
    @Column(name = "departure_airport_code")
    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    @Basic
    @Column(name = "arrival_airport_code")
    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    @Basic
    @Column(name = "stop_airport_code")
    public String getStopAirportCode() {
        return stopAirportCode;
    }

    public void setStopAirportCode(String stopAirportCode) {
        this.stopAirportCode = stopAirportCode;
    }

    @Basic
    @Column(name = "flight_no")
    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    @Basic
    @Column(name = "luggage_num")
    public byte getLuggageNum() {
        return luggageNum;
    }

    public void setLuggageNum(byte luggageNum) {
        this.luggageNum = luggageNum;
    }

    @Basic
    @Column(name = "luggage_weight")
    public BigDecimal getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(BigDecimal luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    @Basic
    @Column(name = "departure_date")
    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Basic
    @Column(name = "departure_time")
    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "arrival_time")
    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "construction_fee")
    public short getConstructionFee() {
        return constructionFee;
    }

    public void setConstructionFee(short constructionFee) {
        this.constructionFee = constructionFee;
    }

    @Basic
    @Column(name = "fuel_fee")
    public short getFuelFee() {
        return fuelFee;
    }

    public void setFuelFee(short fuelFee) {
        this.fuelFee = fuelFee;
    }

    @Basic
    @Column(name = "plane_type")
    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    @Basic
    @Column(name = "stay_days")
    public short getStayDays() {
        return stayDays;
    }

    public void setStayDays(short stayDays) {
        this.stayDays = stayDays;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "voyage_no")
    public byte getVoyageNo() {
        return voyageNo;
    }

    public void setVoyageNo(byte voyageNo) {
        this.voyageNo = voyageNo;
    }

    @Basic
    @Column(name = "takeoff_terminal")
    public String getTakeoffTerminal() {
        return takeoffTerminal;
    }

    public void setTakeoffTerminal(String takeoffTerminal) {
        this.takeoffTerminal = takeoffTerminal;
    }

    @Basic
    @Column(name = "landing_terminal")
    public String getLandingTerminal() {
        return landingTerminal;
    }

    public void setLandingTerminal(String landingTerminal) {
        this.landingTerminal = landingTerminal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbFlightInfoEntity that = (TbFlightInfoEntity) o;
        return id == that.id &&
                orderId == that.orderId &&
                luggageNum == that.luggageNum &&
                constructionFee == that.constructionFee &&
                fuelFee == that.fuelFee &&
                stayDays == that.stayDays &&
                voyageNo == that.voyageNo &&
                Objects.equals(orderNo, that.orderNo) &&
                Objects.equals(airlineCompanyCode, that.airlineCompanyCode) &&
                Objects.equals(departureCityCode, that.departureCityCode) &&
                Objects.equals(arrivalCityCode, that.arrivalCityCode) &&
                Objects.equals(departureAirportCode, that.departureAirportCode) &&
                Objects.equals(arrivalAirportCode, that.arrivalAirportCode) &&
                Objects.equals(stopAirportCode, that.stopAirportCode) &&
                Objects.equals(flightNo, that.flightNo) &&
                Objects.equals(luggageWeight, that.luggageWeight) &&
                Objects.equals(departureDate, that.departureDate) &&
                Objects.equals(departureTime, that.departureTime) &&
                Objects.equals(arrivalTime, that.arrivalTime) &&
                Objects.equals(planeType, that.planeType) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(takeoffTerminal, that.takeoffTerminal) &&
                Objects.equals(landingTerminal, that.landingTerminal);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, orderId, orderNo, airlineCompanyCode, departureCityCode, arrivalCityCode, departureAirportCode, arrivalAirportCode, stopAirportCode, flightNo, luggageNum, luggageWeight, departureDate, departureTime, arrivalTime, constructionFee, fuelFee, planeType, stayDays, createTime, updateTime, voyageNo, takeoffTerminal, landingTerminal);
    }
}
