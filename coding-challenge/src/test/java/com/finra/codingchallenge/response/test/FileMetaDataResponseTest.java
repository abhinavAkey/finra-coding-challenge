package com.finra.codingchallenge.response.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.finra.codingchallenge.model.response.FileMetaDataResponse;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public class FileMetaDataResponseTest {

	FileMetaDataResponse fileMetaDataResponse= new FileMetaDataResponse();
	
	@Before
	public void init() throws Exception {
		fileMetaDataResponse.setFileName("file");
		fileMetaDataResponse.setFirstName("firstName");
		fileMetaDataResponse.setLastName("lastName");
		fileMetaDataResponse.setEmail("email@email.com");
		fileMetaDataResponse.setPhoneNumber("1234567890");
	}
	
	@Test
	public void testFileName(){
		assertEquals(fileMetaDataResponse.getFileName(), "file");
	}
	
	@Test
	public void testFirstName(){
		assertEquals(fileMetaDataResponse.getFirstName(), "firstName");
	}
	
	@Test
	public void testLastName(){
		assertEquals(fileMetaDataResponse.getLastName(), "lastName");
	}
	
	@Test
	public void testPhoneNumber(){
		assertEquals(fileMetaDataResponse.getPhoneNumber(), "1234567890");
	}
	
	@Test
	public void testEmail(){
		assertEquals(fileMetaDataResponse.getEmail(), "email@email.com");
	}
}
