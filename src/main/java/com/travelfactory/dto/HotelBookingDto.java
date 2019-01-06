package com.travelfactory.dto;

import java.io.Serializable;

import com.travelfactory.entities.HotelBookingEntity;

@SuppressWarnings("serial")
public class HotelBookingDto implements Serializable{
	
	private Integer id;
	private String name;
	private String roomNumber;
	
	public HotelBookingDto() {}

	public HotelBookingDto(Integer id, String name, String roomNumber) {
		this.id = id;
		this.name = name;
		this.roomNumber = roomNumber;
	}
	
	public HotelBookingDto(HotelBookingEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.roomNumber = entity.getRoomNumber();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRoomNumber() {
		return roomNumber;
	}
}
