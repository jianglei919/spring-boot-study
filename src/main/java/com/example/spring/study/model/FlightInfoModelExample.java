package com.example.spring.study.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FlightInfoModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public FlightInfoModelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeIsNull() {
            addCriterion("airline_company_code is null");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeIsNotNull() {
            addCriterion("airline_company_code is not null");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeEqualTo(String value) {
            addCriterion("airline_company_code =", value, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeNotEqualTo(String value) {
            addCriterion("airline_company_code <>", value, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeGreaterThan(String value) {
            addCriterion("airline_company_code >", value, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("airline_company_code >=", value, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeLessThan(String value) {
            addCriterion("airline_company_code <", value, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("airline_company_code <=", value, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeLike(String value) {
            addCriterion("airline_company_code like", value, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeNotLike(String value) {
            addCriterion("airline_company_code not like", value, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeIn(List<String> values) {
            addCriterion("airline_company_code in", values, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeNotIn(List<String> values) {
            addCriterion("airline_company_code not in", values, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeBetween(String value1, String value2) {
            addCriterion("airline_company_code between", value1, value2, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andAirlineCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("airline_company_code not between", value1, value2, "airlineCompanyCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeIsNull() {
            addCriterion("departure_city_code is null");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeIsNotNull() {
            addCriterion("departure_city_code is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeEqualTo(String value) {
            addCriterion("departure_city_code =", value, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeNotEqualTo(String value) {
            addCriterion("departure_city_code <>", value, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeGreaterThan(String value) {
            addCriterion("departure_city_code >", value, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("departure_city_code >=", value, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeLessThan(String value) {
            addCriterion("departure_city_code <", value, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeLessThanOrEqualTo(String value) {
            addCriterion("departure_city_code <=", value, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeLike(String value) {
            addCriterion("departure_city_code like", value, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeNotLike(String value) {
            addCriterion("departure_city_code not like", value, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeIn(List<String> values) {
            addCriterion("departure_city_code in", values, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeNotIn(List<String> values) {
            addCriterion("departure_city_code not in", values, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeBetween(String value1, String value2) {
            addCriterion("departure_city_code between", value1, value2, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureCityCodeNotBetween(String value1, String value2) {
            addCriterion("departure_city_code not between", value1, value2, "departureCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeIsNull() {
            addCriterion("arrival_city_code is null");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeIsNotNull() {
            addCriterion("arrival_city_code is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeEqualTo(String value) {
            addCriterion("arrival_city_code =", value, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeNotEqualTo(String value) {
            addCriterion("arrival_city_code <>", value, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeGreaterThan(String value) {
            addCriterion("arrival_city_code >", value, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("arrival_city_code >=", value, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeLessThan(String value) {
            addCriterion("arrival_city_code <", value, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeLessThanOrEqualTo(String value) {
            addCriterion("arrival_city_code <=", value, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeLike(String value) {
            addCriterion("arrival_city_code like", value, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeNotLike(String value) {
            addCriterion("arrival_city_code not like", value, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeIn(List<String> values) {
            addCriterion("arrival_city_code in", values, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeNotIn(List<String> values) {
            addCriterion("arrival_city_code not in", values, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeBetween(String value1, String value2) {
            addCriterion("arrival_city_code between", value1, value2, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andArrivalCityCodeNotBetween(String value1, String value2) {
            addCriterion("arrival_city_code not between", value1, value2, "arrivalCityCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeIsNull() {
            addCriterion("departure_airport_code is null");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeIsNotNull() {
            addCriterion("departure_airport_code is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeEqualTo(String value) {
            addCriterion("departure_airport_code =", value, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeNotEqualTo(String value) {
            addCriterion("departure_airport_code <>", value, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeGreaterThan(String value) {
            addCriterion("departure_airport_code >", value, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("departure_airport_code >=", value, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeLessThan(String value) {
            addCriterion("departure_airport_code <", value, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeLessThanOrEqualTo(String value) {
            addCriterion("departure_airport_code <=", value, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeLike(String value) {
            addCriterion("departure_airport_code like", value, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeNotLike(String value) {
            addCriterion("departure_airport_code not like", value, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeIn(List<String> values) {
            addCriterion("departure_airport_code in", values, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeNotIn(List<String> values) {
            addCriterion("departure_airport_code not in", values, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeBetween(String value1, String value2) {
            addCriterion("departure_airport_code between", value1, value2, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepartureAirportCodeNotBetween(String value1, String value2) {
            addCriterion("departure_airport_code not between", value1, value2, "departureAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeIsNull() {
            addCriterion("arrival_airport_code is null");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeIsNotNull() {
            addCriterion("arrival_airport_code is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeEqualTo(String value) {
            addCriterion("arrival_airport_code =", value, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeNotEqualTo(String value) {
            addCriterion("arrival_airport_code <>", value, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeGreaterThan(String value) {
            addCriterion("arrival_airport_code >", value, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("arrival_airport_code >=", value, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeLessThan(String value) {
            addCriterion("arrival_airport_code <", value, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeLessThanOrEqualTo(String value) {
            addCriterion("arrival_airport_code <=", value, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeLike(String value) {
            addCriterion("arrival_airport_code like", value, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeNotLike(String value) {
            addCriterion("arrival_airport_code not like", value, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeIn(List<String> values) {
            addCriterion("arrival_airport_code in", values, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeNotIn(List<String> values) {
            addCriterion("arrival_airport_code not in", values, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeBetween(String value1, String value2) {
            addCriterion("arrival_airport_code between", value1, value2, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrivalAirportCodeNotBetween(String value1, String value2) {
            addCriterion("arrival_airport_code not between", value1, value2, "arrivalAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeIsNull() {
            addCriterion("stop_airport_code is null");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeIsNotNull() {
            addCriterion("stop_airport_code is not null");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeEqualTo(String value) {
            addCriterion("stop_airport_code =", value, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeNotEqualTo(String value) {
            addCriterion("stop_airport_code <>", value, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeGreaterThan(String value) {
            addCriterion("stop_airport_code >", value, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("stop_airport_code >=", value, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeLessThan(String value) {
            addCriterion("stop_airport_code <", value, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeLessThanOrEqualTo(String value) {
            addCriterion("stop_airport_code <=", value, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeLike(String value) {
            addCriterion("stop_airport_code like", value, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeNotLike(String value) {
            addCriterion("stop_airport_code not like", value, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeIn(List<String> values) {
            addCriterion("stop_airport_code in", values, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeNotIn(List<String> values) {
            addCriterion("stop_airport_code not in", values, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeBetween(String value1, String value2) {
            addCriterion("stop_airport_code between", value1, value2, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andStopAirportCodeNotBetween(String value1, String value2) {
            addCriterion("stop_airport_code not between", value1, value2, "stopAirportCode");
            return (Criteria) this;
        }

        public Criteria andFlightNoIsNull() {
            addCriterion("flight_no is null");
            return (Criteria) this;
        }

        public Criteria andFlightNoIsNotNull() {
            addCriterion("flight_no is not null");
            return (Criteria) this;
        }

        public Criteria andFlightNoEqualTo(String value) {
            addCriterion("flight_no =", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoNotEqualTo(String value) {
            addCriterion("flight_no <>", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoGreaterThan(String value) {
            addCriterion("flight_no >", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoGreaterThanOrEqualTo(String value) {
            addCriterion("flight_no >=", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoLessThan(String value) {
            addCriterion("flight_no <", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoLessThanOrEqualTo(String value) {
            addCriterion("flight_no <=", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoLike(String value) {
            addCriterion("flight_no like", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoNotLike(String value) {
            addCriterion("flight_no not like", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoIn(List<String> values) {
            addCriterion("flight_no in", values, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoNotIn(List<String> values) {
            addCriterion("flight_no not in", values, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoBetween(String value1, String value2) {
            addCriterion("flight_no between", value1, value2, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoNotBetween(String value1, String value2) {
            addCriterion("flight_no not between", value1, value2, "flightNo");
            return (Criteria) this;
        }

        public Criteria andLuggageNumIsNull() {
            addCriterion("luggage_num is null");
            return (Criteria) this;
        }

        public Criteria andLuggageNumIsNotNull() {
            addCriterion("luggage_num is not null");
            return (Criteria) this;
        }

        public Criteria andLuggageNumEqualTo(Integer value) {
            addCriterion("luggage_num =", value, "luggageNum");
            return (Criteria) this;
        }

        public Criteria andLuggageNumNotEqualTo(Integer value) {
            addCriterion("luggage_num <>", value, "luggageNum");
            return (Criteria) this;
        }

        public Criteria andLuggageNumGreaterThan(Integer value) {
            addCriterion("luggage_num >", value, "luggageNum");
            return (Criteria) this;
        }

        public Criteria andLuggageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("luggage_num >=", value, "luggageNum");
            return (Criteria) this;
        }

        public Criteria andLuggageNumLessThan(Integer value) {
            addCriterion("luggage_num <", value, "luggageNum");
            return (Criteria) this;
        }

        public Criteria andLuggageNumLessThanOrEqualTo(Integer value) {
            addCriterion("luggage_num <=", value, "luggageNum");
            return (Criteria) this;
        }

        public Criteria andLuggageNumIn(List<Integer> values) {
            addCriterion("luggage_num in", values, "luggageNum");
            return (Criteria) this;
        }

        public Criteria andLuggageNumNotIn(List<Integer> values) {
            addCriterion("luggage_num not in", values, "luggageNum");
            return (Criteria) this;
        }

        public Criteria andLuggageNumBetween(Integer value1, Integer value2) {
            addCriterion("luggage_num between", value1, value2, "luggageNum");
            return (Criteria) this;
        }

        public Criteria andLuggageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("luggage_num not between", value1, value2, "luggageNum");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightIsNull() {
            addCriterion("luggage_weight is null");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightIsNotNull() {
            addCriterion("luggage_weight is not null");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightEqualTo(BigDecimal value) {
            addCriterion("luggage_weight =", value, "luggageWeight");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightNotEqualTo(BigDecimal value) {
            addCriterion("luggage_weight <>", value, "luggageWeight");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightGreaterThan(BigDecimal value) {
            addCriterion("luggage_weight >", value, "luggageWeight");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("luggage_weight >=", value, "luggageWeight");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightLessThan(BigDecimal value) {
            addCriterion("luggage_weight <", value, "luggageWeight");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("luggage_weight <=", value, "luggageWeight");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightIn(List<BigDecimal> values) {
            addCriterion("luggage_weight in", values, "luggageWeight");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightNotIn(List<BigDecimal> values) {
            addCriterion("luggage_weight not in", values, "luggageWeight");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("luggage_weight between", value1, value2, "luggageWeight");
            return (Criteria) this;
        }

        public Criteria andLuggageWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("luggage_weight not between", value1, value2, "luggageWeight");
            return (Criteria) this;
        }

        public Criteria andDepartureDateIsNull() {
            addCriterion("departure_date is null");
            return (Criteria) this;
        }

        public Criteria andDepartureDateIsNotNull() {
            addCriterion("departure_date is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureDateEqualTo(String value) {
            addCriterion("departure_date =", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateNotEqualTo(String value) {
            addCriterion("departure_date <>", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateGreaterThan(String value) {
            addCriterion("departure_date >", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateGreaterThanOrEqualTo(String value) {
            addCriterion("departure_date >=", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateLessThan(String value) {
            addCriterion("departure_date <", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateLessThanOrEqualTo(String value) {
            addCriterion("departure_date <=", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateIn(List<String> values) {
            addCriterion("departure_date in", values, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateNotIn(List<String> values) {
            addCriterion("departure_date not in", values, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateBetween(String value1, String value2) {
            addCriterion("departure_date between", value1, value2, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateNotBetween(String value1, String value2) {
            addCriterion("departure_date not between", value1, value2, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNull() {
            addCriterion("departure_time is null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNotNull() {
            addCriterion("departure_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time =", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time <>", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("departure_time >", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time >=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThan(Date value) {
            addCriterionForJDBCTime("departure_time <", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time <=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIn(List<Date> values) {
            addCriterionForJDBCTime("departure_time in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("departure_time not in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("departure_time between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("departure_time not between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNull() {
            addCriterion("arrival_time is null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNotNull() {
            addCriterion("arrival_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeEqualTo(Date value) {
            addCriterionForJDBCTime("arrival_time =", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("arrival_time <>", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("arrival_time >", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("arrival_time >=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThan(Date value) {
            addCriterionForJDBCTime("arrival_time <", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("arrival_time <=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIn(List<Date> values) {
            addCriterionForJDBCTime("arrival_time in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("arrival_time not in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("arrival_time between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("arrival_time not between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeIsNull() {
            addCriterion("construction_fee is null");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeIsNotNull() {
            addCriterion("construction_fee is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeEqualTo(Integer value) {
            addCriterion("construction_fee =", value, "constructionFee");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeNotEqualTo(Integer value) {
            addCriterion("construction_fee <>", value, "constructionFee");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeGreaterThan(Integer value) {
            addCriterion("construction_fee >", value, "constructionFee");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("construction_fee >=", value, "constructionFee");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeLessThan(Integer value) {
            addCriterion("construction_fee <", value, "constructionFee");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeLessThanOrEqualTo(Integer value) {
            addCriterion("construction_fee <=", value, "constructionFee");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeIn(List<Integer> values) {
            addCriterion("construction_fee in", values, "constructionFee");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeNotIn(List<Integer> values) {
            addCriterion("construction_fee not in", values, "constructionFee");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeBetween(Integer value1, Integer value2) {
            addCriterion("construction_fee between", value1, value2, "constructionFee");
            return (Criteria) this;
        }

        public Criteria andConstructionFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("construction_fee not between", value1, value2, "constructionFee");
            return (Criteria) this;
        }

        public Criteria andFuelFeeIsNull() {
            addCriterion("fuel_fee is null");
            return (Criteria) this;
        }

        public Criteria andFuelFeeIsNotNull() {
            addCriterion("fuel_fee is not null");
            return (Criteria) this;
        }

        public Criteria andFuelFeeEqualTo(Integer value) {
            addCriterion("fuel_fee =", value, "fuelFee");
            return (Criteria) this;
        }

        public Criteria andFuelFeeNotEqualTo(Integer value) {
            addCriterion("fuel_fee <>", value, "fuelFee");
            return (Criteria) this;
        }

        public Criteria andFuelFeeGreaterThan(Integer value) {
            addCriterion("fuel_fee >", value, "fuelFee");
            return (Criteria) this;
        }

        public Criteria andFuelFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fuel_fee >=", value, "fuelFee");
            return (Criteria) this;
        }

        public Criteria andFuelFeeLessThan(Integer value) {
            addCriterion("fuel_fee <", value, "fuelFee");
            return (Criteria) this;
        }

        public Criteria andFuelFeeLessThanOrEqualTo(Integer value) {
            addCriterion("fuel_fee <=", value, "fuelFee");
            return (Criteria) this;
        }

        public Criteria andFuelFeeIn(List<Integer> values) {
            addCriterion("fuel_fee in", values, "fuelFee");
            return (Criteria) this;
        }

        public Criteria andFuelFeeNotIn(List<Integer> values) {
            addCriterion("fuel_fee not in", values, "fuelFee");
            return (Criteria) this;
        }

        public Criteria andFuelFeeBetween(Integer value1, Integer value2) {
            addCriterion("fuel_fee between", value1, value2, "fuelFee");
            return (Criteria) this;
        }

        public Criteria andFuelFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("fuel_fee not between", value1, value2, "fuelFee");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeIsNull() {
            addCriterion("plane_type is null");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeIsNotNull() {
            addCriterion("plane_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeEqualTo(String value) {
            addCriterion("plane_type =", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeNotEqualTo(String value) {
            addCriterion("plane_type <>", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeGreaterThan(String value) {
            addCriterion("plane_type >", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeGreaterThanOrEqualTo(String value) {
            addCriterion("plane_type >=", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeLessThan(String value) {
            addCriterion("plane_type <", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeLessThanOrEqualTo(String value) {
            addCriterion("plane_type <=", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeLike(String value) {
            addCriterion("plane_type like", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeNotLike(String value) {
            addCriterion("plane_type not like", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeIn(List<String> values) {
            addCriterion("plane_type in", values, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeNotIn(List<String> values) {
            addCriterion("plane_type not in", values, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeBetween(String value1, String value2) {
            addCriterion("plane_type between", value1, value2, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeNotBetween(String value1, String value2) {
            addCriterion("plane_type not between", value1, value2, "planeType");
            return (Criteria) this;
        }

        public Criteria andStayDaysIsNull() {
            addCriterion("stay_days is null");
            return (Criteria) this;
        }

        public Criteria andStayDaysIsNotNull() {
            addCriterion("stay_days is not null");
            return (Criteria) this;
        }

        public Criteria andStayDaysEqualTo(Integer value) {
            addCriterion("stay_days =", value, "stayDays");
            return (Criteria) this;
        }

        public Criteria andStayDaysNotEqualTo(Integer value) {
            addCriterion("stay_days <>", value, "stayDays");
            return (Criteria) this;
        }

        public Criteria andStayDaysGreaterThan(Integer value) {
            addCriterion("stay_days >", value, "stayDays");
            return (Criteria) this;
        }

        public Criteria andStayDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("stay_days >=", value, "stayDays");
            return (Criteria) this;
        }

        public Criteria andStayDaysLessThan(Integer value) {
            addCriterion("stay_days <", value, "stayDays");
            return (Criteria) this;
        }

        public Criteria andStayDaysLessThanOrEqualTo(Integer value) {
            addCriterion("stay_days <=", value, "stayDays");
            return (Criteria) this;
        }

        public Criteria andStayDaysIn(List<Integer> values) {
            addCriterion("stay_days in", values, "stayDays");
            return (Criteria) this;
        }

        public Criteria andStayDaysNotIn(List<Integer> values) {
            addCriterion("stay_days not in", values, "stayDays");
            return (Criteria) this;
        }

        public Criteria andStayDaysBetween(Integer value1, Integer value2) {
            addCriterion("stay_days between", value1, value2, "stayDays");
            return (Criteria) this;
        }

        public Criteria andStayDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("stay_days not between", value1, value2, "stayDays");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andVoyageNoIsNull() {
            addCriterion("voyage_no is null");
            return (Criteria) this;
        }

        public Criteria andVoyageNoIsNotNull() {
            addCriterion("voyage_no is not null");
            return (Criteria) this;
        }

        public Criteria andVoyageNoEqualTo(Integer value) {
            addCriterion("voyage_no =", value, "voyageNo");
            return (Criteria) this;
        }

        public Criteria andVoyageNoNotEqualTo(Integer value) {
            addCriterion("voyage_no <>", value, "voyageNo");
            return (Criteria) this;
        }

        public Criteria andVoyageNoGreaterThan(Integer value) {
            addCriterion("voyage_no >", value, "voyageNo");
            return (Criteria) this;
        }

        public Criteria andVoyageNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("voyage_no >=", value, "voyageNo");
            return (Criteria) this;
        }

        public Criteria andVoyageNoLessThan(Integer value) {
            addCriterion("voyage_no <", value, "voyageNo");
            return (Criteria) this;
        }

        public Criteria andVoyageNoLessThanOrEqualTo(Integer value) {
            addCriterion("voyage_no <=", value, "voyageNo");
            return (Criteria) this;
        }

        public Criteria andVoyageNoIn(List<Integer> values) {
            addCriterion("voyage_no in", values, "voyageNo");
            return (Criteria) this;
        }

        public Criteria andVoyageNoNotIn(List<Integer> values) {
            addCriterion("voyage_no not in", values, "voyageNo");
            return (Criteria) this;
        }

        public Criteria andVoyageNoBetween(Integer value1, Integer value2) {
            addCriterion("voyage_no between", value1, value2, "voyageNo");
            return (Criteria) this;
        }

        public Criteria andVoyageNoNotBetween(Integer value1, Integer value2) {
            addCriterion("voyage_no not between", value1, value2, "voyageNo");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalIsNull() {
            addCriterion("takeoff_terminal is null");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalIsNotNull() {
            addCriterion("takeoff_terminal is not null");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalEqualTo(String value) {
            addCriterion("takeoff_terminal =", value, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalNotEqualTo(String value) {
            addCriterion("takeoff_terminal <>", value, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalGreaterThan(String value) {
            addCriterion("takeoff_terminal >", value, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalGreaterThanOrEqualTo(String value) {
            addCriterion("takeoff_terminal >=", value, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalLessThan(String value) {
            addCriterion("takeoff_terminal <", value, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalLessThanOrEqualTo(String value) {
            addCriterion("takeoff_terminal <=", value, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalLike(String value) {
            addCriterion("takeoff_terminal like", value, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalNotLike(String value) {
            addCriterion("takeoff_terminal not like", value, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalIn(List<String> values) {
            addCriterion("takeoff_terminal in", values, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalNotIn(List<String> values) {
            addCriterion("takeoff_terminal not in", values, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalBetween(String value1, String value2) {
            addCriterion("takeoff_terminal between", value1, value2, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andTakeoffTerminalNotBetween(String value1, String value2) {
            addCriterion("takeoff_terminal not between", value1, value2, "takeoffTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalIsNull() {
            addCriterion("landing_terminal is null");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalIsNotNull() {
            addCriterion("landing_terminal is not null");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalEqualTo(String value) {
            addCriterion("landing_terminal =", value, "landingTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalNotEqualTo(String value) {
            addCriterion("landing_terminal <>", value, "landingTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalGreaterThan(String value) {
            addCriterion("landing_terminal >", value, "landingTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalGreaterThanOrEqualTo(String value) {
            addCriterion("landing_terminal >=", value, "landingTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalLessThan(String value) {
            addCriterion("landing_terminal <", value, "landingTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalLessThanOrEqualTo(String value) {
            addCriterion("landing_terminal <=", value, "landingTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalLike(String value) {
            addCriterion("landing_terminal like", value, "landingTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalNotLike(String value) {
            addCriterion("landing_terminal not like", value, "landingTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalIn(List<String> values) {
            addCriterion("landing_terminal in", values, "landingTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalNotIn(List<String> values) {
            addCriterion("landing_terminal not in", values, "landingTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalBetween(String value1, String value2) {
            addCriterion("landing_terminal between", value1, value2, "landingTerminal");
            return (Criteria) this;
        }

        public Criteria andLandingTerminalNotBetween(String value1, String value2) {
            addCriterion("landing_terminal not between", value1, value2, "landingTerminal");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}