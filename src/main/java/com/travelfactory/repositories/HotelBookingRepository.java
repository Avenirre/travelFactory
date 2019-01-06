package com.travelfactory.repositories;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travelfactory.entities.HotelBookingEntity;

public interface HotelBookingRepository extends MongoRepository<HotelBookingEntity, Integer>{

	HotelBookingEntity findByVendorAndDateAndId(String vendor, LocalDate date, Integer id);

}
