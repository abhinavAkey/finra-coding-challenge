package com.finra.codingchallenge.model.request;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public class FileMetaDataRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9186653756237613919L;
	
	private MultipartFile file;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "FileMetaDataRequest [file=" + file.getName() + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
}
