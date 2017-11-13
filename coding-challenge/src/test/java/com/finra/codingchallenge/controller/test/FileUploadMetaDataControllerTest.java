package com.finra.codingchallenge.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.finra.codingchallenge.controller.FileUploadMetaDataController;
import com.finra.codingchallenge.model.request.FileMetaDataRequest;
import com.finra.codingchallenge.service.FileUploadMetaDataService;
import com.finra.codingchallenge.service.impl.FileUploadMetaDataServiceImpl;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = FileUploadMetaDataController.class, secure = false)
@ContextConfiguration(classes = { FileUploadMetaDataController.class })
public class FileUploadMetaDataControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FileUploadMetaDataService fileUploadMetaDataService;

	@ComponentScan(basePackageClasses = { FileUploadMetaDataController.class })
	static class Config {
		@Bean
		public FileUploadMetaDataService fileUploadMetaDataService() {
			return new FileUploadMetaDataServiceImpl();
		}
	}

	@Test
	public void testFileUploadView() throws Exception {

		this.mockMvc.perform(get("/file/upload/addFileMetaData")).andExpect(status().isOk());
	}

	@Test
	public void testFileUploadReturnFalse() throws Exception {

		String sample = "This is a Sample File";

		MockMultipartFile sampleFile = new MockMultipartFile("file", "filename.txt", "text/plain", sample.getBytes());

		this.mockMvc.perform(MockMvcRequestBuilders.multipart("/file/upload/addFileMetaData").file(sampleFile)
				.param("firstName", "firstName").param("lastName", "lastName").param("phoneNumber", "1234567890")
				.param("email", "sample@sample.com")).andExpect(status().isFound());
	}
	
	@Test
	public void testFileUploadReturnTrue() throws Exception {

		String sample = "This is a Sample File";
		
		FileMetaDataRequest fileMetaDataRequest = new FileMetaDataRequest();
		Mockito.when(fileUploadMetaDataService.saveUploadedFileAndMetaData(fileMetaDataRequest)).thenReturn(true);

		MockMultipartFile sampleFile = new MockMultipartFile("file", "filename.txt", "text/plain", sample.getBytes());

		this.mockMvc.perform(MockMvcRequestBuilders.multipart("/file/upload/addFileMetaData").file(sampleFile)
				.param("firstName", "firstName").param("lastName", "lastName").param("phoneNumber", "1234567890")
				.param("email", "sample@sample.com")).andExpect(status().isFound());
	}
	
	@Test
	public void testGetAllFileUploadMetaData() throws Exception {

		Mockito.when(fileUploadMetaDataService.getAllFileNamesAndMetaData()).thenReturn(null);

		this.mockMvc.perform(get("/file/getFileMetaData")).andExpect(status().isOk());
	}
}
