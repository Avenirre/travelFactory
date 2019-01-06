package com.travelfactory.controller;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.travelfactory.dto.HotelBookingDto;
import com.travelfactory.model.BookingService;
import com.travelfactory.model.CSVScanner;

@RestController
@RequestMapping(value="/catalog")
public class BookingController {
	
	@Autowired
	BookingService hotelBooking;
	
	@Autowired
	CSVScanner csvScanner;
	
	@PostConstruct
	void scanDirectory() {
		csvScanner.scanDirectory();
	}
	
	@GetMapping(value="/{vendor}/{date}/{id}")
	HotelBookingDto test(@PathVariable("vendor") String vendor, 
			@PathVariable("date") @DateTimeFormat(pattern="dd-MM-yyyy")LocalDate date, 
			@PathVariable("id") Integer id) {
		return hotelBooking.consume(vendor, date, id);
	}
	
	
	
	

}
