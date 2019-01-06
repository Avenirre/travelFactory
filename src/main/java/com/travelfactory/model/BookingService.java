package com.travelfactory.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelfactory.dto.HotelBookingDto;
import com.travelfactory.entities.HotelBookingEntity;
import com.travelfactory.exceptions.NoSuchRecordExistsException;
import com.travelfactory.repositories.HotelBookingRepository;

@Service
public class BookingService {
	
	@Autowired
	HotelBookingRepository hotelBookings;
	
	public HotelBookingDto consume(String vendor, LocalDate date, Integer id){
		HotelBookingEntity entity = hotelBookings.findByVendorAndDateAndId(vendor, date, id);
		if (entity == null) {
			throw new NoSuchRecordExistsException();
		}
		return new HotelBookingDto(entity);
	}

}
