package com.finra.codingchallenge.model.response;

import java.io.Serializable;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public class FileMetaDataResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8922485076282762973L;
	private String fileName;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
}
