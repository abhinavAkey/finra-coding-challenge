package com.finra.codingchallenge.controller;

import org.springframework.web.multipart.MultipartFile;

import com.finra.codingchallenge.model.request.FileMetaDataRequest;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public class BaseController {

	public FileMetaDataRequest toFileMetaDataRequest(final MultipartFile file, final String firstName,
			final String lastName, final String phoneNumber, final String email) {
		FileMetaDataRequest fileMetaDataRequest = new FileMetaDataRequest();
		fileMetaDataRequest.setFile(file);
		fileMetaDataRequest.setFirstName(firstName);
		fileMetaDataRequest.setLastName(lastName);
		fileMetaDataRequest.setPhoneNumber(phoneNumber);
		fileMetaDataRequest.setEmail(email);
		return fileMetaDataRequest;
	}

}
