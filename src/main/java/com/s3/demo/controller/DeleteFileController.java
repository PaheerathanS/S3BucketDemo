package com.s3.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.s3.demo.services.S3Services;

@RestController
public class DeleteFileController {
	@Autowired
	S3Services s3Services;

	@DeleteMapping("/api/file/delete/{keyname}")
	public String uploadMultipartFile(@PathVariable String keyname) {
		try {
			s3Services.deleteFile(keyname);
		} catch (Exception e) {
			return "Cannot Delete File -> Keyname = " + keyname;
		}
		return "Deleted Successfully -> Keyname = " + keyname;
	}
}
