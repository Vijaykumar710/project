package com.curdoperation.entity;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Entity//identify the class
public class Student {//encapulation_process

	@Id//indicate primary key
	@GeneratedValue//provide specification values to primary key
	private Long id;

	private String name;

	private String passportNumber;

	private String filename;
    private String downloadUri;
    private long size;
	public static void saveFile(String fileName, MultipartFile multipartFile) throws IOException {
		{
			Path uploadDirectory = Paths.get("D://Download");
			try (InputStream inputStream = multipartFile.getInputStream())
			{
				Path filePath = uploadDirectory.resolve(fileName);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
				
			}catch(IOException ioe) {
				throw new IOException("Error saving upload file: " + fileName, ioe);
				
			}
			
	}


	}
}
