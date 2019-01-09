package com.travelfactory.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.travelfactory.entities.FileNameEntity;
import com.travelfactory.entities.HotelBookingEntity;
import com.travelfactory.repositories.FileNameRepository;
import com.travelfactory.repositories.HotelBookingRepository;

@Component
@ConfigurationProperties
public class CSVScanner{
	
	@Value("${scanDirectory}") // should be working ok now
	String scanDirectory = "/Users/romandimitrievich/travelExamples";
	
	@Autowired
	HotelBookingRepository hotelBookings;
	
	@Autowired
	FileNameRepository fileNameRepository;

	public CSVScanner() {}
	
	public void scanDirectory() {
		File directory = new File(scanDirectory);
		File[] directoryContent = directory.listFiles();
		for(File file: directoryContent) {
			String name = file.getName();
			int pointIndex = name.lastIndexOf('.');
			int hyphenIndex = name.indexOf('-');
			String vendor = name.substring(0, hyphenIndex);
	        LocalDate currentDate = LocalDate.parse(name.substring(hyphenIndex+1,pointIndex), 
					DateTimeFormatter.ofPattern( "dd-MM-yyyy" ));
			if (isCSV(name, pointIndex) && !isUsedBefore(name)) {
				writeToMongoDb(file, vendor, currentDate);
			}
		}
	}

	private void writeToMongoDb(File file, String vendor, LocalDate currentDate) {
		String line;
		String cvsSplitBy = ",";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			br.readLine();
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                hotelBookings.save(new HotelBookingEntity(vendor, currentDate, Integer.parseInt(items[0]),
                		items[1],items[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}

	private boolean isUsedBefore(String name) {
		//TODO need to implement existsById method, it's not a part of mongo repository
		//if (!fileNameRepository.existsById(name)) {
		if (!fileNameRepository.exists(name)) {
			fileNameRepository.save(new FileNameEntity(name));
			return false;
		} else {
			System.out.println(name+" has been already used!");
			return true;
		}
	}

	private boolean isCSV(String name, int pointIndex) {
		String extension = name.substring(pointIndex+1);
		return extension.equals("csv");
	}

}
