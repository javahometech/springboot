package com.rayala.aws;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rayala.aws.service.S3Service;

@SpringBootApplication
@RestController
public class Application {
	
	@Autowired
	private S3Service s3Service;

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }
    
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile file,@RequestParam("file2") MultipartFile file2) throws IOException {
    	s3Service.uploadFile(file.getInputStream());
        return "Success";
    }
    
    
    @RequestMapping("/welcome")
    public String welcome() {
        return "Hello Spring Boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
