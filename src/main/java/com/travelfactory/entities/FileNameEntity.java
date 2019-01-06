package com.travelfactory.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="filenames")
public class FileNameEntity {
	
	@Id
	private String name;

	public FileNameEntity() {}
	
	public FileNameEntity(String name) {
		super();
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	

}
