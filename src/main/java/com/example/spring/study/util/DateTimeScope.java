package com.example.spring.study.util;

import java.util.Date;

/**
 * 时间范围
 * 
 */
public class DateTimeScope {

	private Date startTime;

	private Date endTime;

	private int code;
	
	private String token;

	public DateTimeScope() {

	}

	public DateTimeScope(Date startTime, Date endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
