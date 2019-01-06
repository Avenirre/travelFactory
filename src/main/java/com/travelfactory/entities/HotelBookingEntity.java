package com.travelfactory.entities;

import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bookings")
public class HotelBookingEntity {
	
	private String vendor;
	private LocalDate date;
	private Integer id;
	private String name;
	private String roomNumber;
	
	public HotelBookingEntity(String vendor, LocalDate date, Integer id, String name, String roomNumber) {
		this.vendor = vendor;
		this.date = date;
		this.id = id;
		this.name = name;
		this.roomNumber = roomNumber;
	}

	public HotelBookingEntity() {
		super();
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
}
