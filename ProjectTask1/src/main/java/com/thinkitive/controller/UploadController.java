package com.thinkitive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thinkitive.serviceimpl.UploadService;

@RestController
public class UploadController {
	@Autowired
	UploadService uploadService;
	@PostMapping(value = "/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws Throwable
	{
		uploadService.upload(file);
		return "Added Successfully";
	}

}
