package com.finra.codingchallenge.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import com.finra.codingchallenge.exception.CodingChallengeClientValidationException;
import com.finra.codingchallenge.model.request.FileMetaDataRequest;
import com.finra.codingchallenge.model.response.FileMetaDataResponse;
import com.finra.codingchallenge.repository.FileUploadMetaDataRepository;
import com.finra.codingchallenge.repository.entity.FileMetaData;
import com.finra.codingchallenge.service.FileUploadMetaDataService;
import com.finra.codingchallenge.service.impl.FileUploadMetaDataServiceImpl;
import com.finra.codingchallenge.validator.FileUploadMetaDataValidator;
import com.finra.codingchallenge.validator.impl.FileUploadMetaDataValidatorImpl;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
@ContextConfiguration(classes = {FileUploadMetaDataServiceImpl.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FileUploadMetaDataServiceTest {

	private FileUploadMetaDataService fileUploadMetaDataService;
	
	private FileUploadMetaDataValidator fileUploadMetaDataValidator;
	
	private FileUploadMetaDataRepository fileUploadMetaDataRepositoryMock;
	
	@Before
    public void init() throws Exception{
		fileUploadMetaDataService = new FileUploadMetaDataServiceImpl();
		fileUploadMetaDataValidator = new FileUploadMetaDataValidatorImpl();
		fileUploadMetaDataRepositoryMock = Mockito.mock(FileUploadMetaDataRepository.class);
		ReflectionTestUtils.setField(fileUploadMetaDataService, "fileUploadMetaDataRepository", fileUploadMetaDataRepositoryMock);     
		ReflectionTestUtils.setField(fileUploadMetaDataService, "fileUploadMetaDataValidator", fileUploadMetaDataValidator);     
    }
	
	@Test
	public void testSaveUploadedFileAndMetaData() {
		FileMetaDataRequest fileMetaDataRequest = createDummyFileMetaDataRequest();
		FileMetaData fileMetaData = new FileMetaData();
		when(fileUploadMetaDataRepositoryMock.saveFileMetaData(fileMetaData)).thenReturn(new Long(10));
		boolean isSaved = fileUploadMetaDataService.saveUploadedFileAndMetaData(fileMetaDataRequest);
		assertEquals(isSaved, true);
    }
	
	@Test(expected = CodingChallengeClientValidationException.class)
	public void testSaveUploadedFileAndMetaDataNullFile() {
		FileMetaDataRequest fileMetaDataRequest = createDummyFileMetaDataRequest();
		fileMetaDataRequest.setFile(null);
		FileMetaData fileMetaData = new FileMetaData();
		when(fileUploadMetaDataRepositoryMock.saveFileMetaData(fileMetaData)).thenReturn(10l);
		fileUploadMetaDataService.saveUploadedFileAndMetaData(fileMetaDataRequest);
    }
	
	@Test(expected = CodingChallengeClientValidationException.class)
	public void testSaveUploadedFileAndMetaDataInvalidFirstName() {
		FileMetaDataRequest fileMetaDataRequest = createDummyFileMetaDataRequest();
		fileMetaDataRequest.setFirstName("NM^%$^");
		FileMetaData fileMetaData = new FileMetaData();
		when(fileUploadMetaDataRepositoryMock.saveFileMetaData(fileMetaData)).thenReturn(10l);
		fileUploadMetaDataService.saveUploadedFileAndMetaData(fileMetaDataRequest);
    }
	
	@Test(expected = CodingChallengeClientValidationException.class)
	public void testSaveUploadedFileAndMetaDataInvalidLastName() {
		FileMetaDataRequest fileMetaDataRequest = createDummyFileMetaDataRequest();
		fileMetaDataRequest.setLastName("");
		FileMetaData fileMetaData = new FileMetaData();
		when(fileUploadMetaDataRepositoryMock.saveFileMetaData(fileMetaData)).thenReturn(10l);
		fileUploadMetaDataService.saveUploadedFileAndMetaData(fileMetaDataRequest);
    }
	
	@Test(expected = CodingChallengeClientValidationException.class)
	public void testSaveUploadedFileAndMetaDataInvalidEmail() {
		FileMetaDataRequest fileMetaDataRequest = createDummyFileMetaDataRequest();
		fileMetaDataRequest.setPhoneNumber("Phone");
		FileMetaData fileMetaData = new FileMetaData();
		when(fileUploadMetaDataRepositoryMock.saveFileMetaData(fileMetaData)).thenReturn(10l);
		fileUploadMetaDataService.saveUploadedFileAndMetaData(fileMetaDataRequest);
    }
	
	@Test(expected = CodingChallengeClientValidationException.class)
	public void testSaveUploadedFileAndMetaDataInvalidPhone() {
		FileMetaDataRequest fileMetaDataRequest = createDummyFileMetaDataRequest();
		fileMetaDataRequest.setEmail("email");
		FileMetaData fileMetaData = new FileMetaData();
		when(fileUploadMetaDataRepositoryMock.saveFileMetaData(fileMetaData)).thenReturn(10l);
		fileUploadMetaDataService.saveUploadedFileAndMetaData(fileMetaDataRequest);
    }
	
	@Test
	public void testGetAllFileMetaData() {
		when(fileUploadMetaDataRepositoryMock.getAllFileMetaData()).thenReturn(new ArrayList<FileMetaData>());
		List<FileMetaDataResponse> files = fileUploadMetaDataService.getAllFileNamesAndMetaData();
		assertEquals(files, null);
    }

	private FileMetaDataRequest createDummyFileMetaDataRequest() {
		FileMetaDataRequest fileMetaDataRequest = new FileMetaDataRequest();
		String sample = "This is a Sample File";
		MockMultipartFile sampleFile = new MockMultipartFile("file", "filename.txt", "text/plain", sample.getBytes());
		fileMetaDataRequest.setFile(sampleFile);
		fileMetaDataRequest.setFirstName("firstName");
		fileMetaDataRequest.setLastName("lastName");
		fileMetaDataRequest.setEmail("email@email.com");
		fileMetaDataRequest.setPhoneNumber("1234567890");
		return fileMetaDataRequest;
	}
}
