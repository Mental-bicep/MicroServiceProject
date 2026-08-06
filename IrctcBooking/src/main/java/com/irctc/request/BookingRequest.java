package com.irctc.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingRequest {
	private Long userId;
	private String fromStation;
	private String toStation;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate journeyDate;
	
	private String passengerName;
	private String gender;
	private Integer age;
	
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "BookingRequest [fromStation=" + fromStation + ", toStation=" + toStation + ", journeyDate="
				+ journeyDate + ", passengerName=" + passengerName + ", gender=" + gender + ", age=" + age + "]";
	}
}