package com.finra.codingchallenge.model.request.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.finra.codingchallenge.model.request.FileMetaDataRequest;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public class FileMetaDataRequestTest {

	FileMetaDataRequest fileMetaDataRequest= new FileMetaDataRequest();
	
	@Before
	public void init() throws Exception {
		fileMetaDataRequest.setFirstName("firstName");
		fileMetaDataRequest.setLastName("lastName");
		fileMetaDataRequest.setEmail("email@email.com");
		fileMetaDataRequest.setPhoneNumber("1234567890");
	}
	
	@Test
	public void testFirstName(){
		assertEquals(fileMetaDataRequest.getFirstName(), "firstName");
	}
	
	@Test
	public void testLastName(){
		assertEquals(fileMetaDataRequest.getLastName(), "lastName");
	}
	
	@Test
	public void testPhoneNumber(){
		assertEquals(fileMetaDataRequest.getPhoneNumber(), "1234567890");
	}
	
	@Test
	public void testEmail(){
		assertEquals(fileMetaDataRequest.getEmail(), "email@email.com");
	}
}
