package com.finra.codingchallenge.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.finra.codingchallenge.exception.CodingChallengeClientValidationException;
import com.finra.codingchallenge.exception.CodingChallengeServiceException;
import com.finra.codingchallenge.model.request.FileMetaDataRequest;
import com.finra.codingchallenge.model.response.FileMetaDataResponse;
import com.finra.codingchallenge.repository.FileUploadMetaDataRepository;
import com.finra.codingchallenge.repository.entity.FileMetaData;
import com.finra.codingchallenge.service.FileUploadMetaDataService;
import com.finra.codingchallenge.validator.FileUploadMetaDataValidator;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
@Service(value = "fileUploadMetaDataService")
public class FileUploadMetaDataServiceImpl implements FileUploadMetaDataService {

	private static final Logger LOG = LoggerFactory.getLogger(FileUploadMetaDataServiceImpl.class);

	@Resource(name = "fileUploadMetaDataRepository")
	private FileUploadMetaDataRepository fileUploadMetaDataRepository;

	@Resource(name = "fileUploadMetaDataValidator")
	private FileUploadMetaDataValidator fileUploadMetaDataValidator;

	@Override
	public boolean saveUploadedFileAndMetaData(FileMetaDataRequest fileMetaDataRequest) {
		try {
			LOG.debug("In saveUploadedFileAndMetaData");
			if (fileUploadMetaDataValidator.isValidFileMetaDataRequest(fileMetaDataRequest)) {
				FileMetaData fileMetaData = createFileMetaDataToSave(fileMetaDataRequest);
				fileUploadMetaDataRepository.saveFileMetaData(fileMetaData);
				return true;
			}
		}catch (CodingChallengeClientValidationException e) {
			LOG.debug("The exception is because of {}", e.getMessage());
			throw e;
		} 
		catch (Exception e) {
			LOG.debug("The exception is because of {}", e.getMessage());
			throw new CodingChallengeServiceException(e.getMessage());
		}
		return false;
	}

	@Override
	public List<FileMetaDataResponse> getAllFileNamesAndMetaData() {
		try {
			List<FileMetaData> filesAndMetaData = fileUploadMetaDataRepository.getAllFileMetaData();
			if (!CollectionUtils.isEmpty(filesAndMetaData))
				return toFileMetaDataResponses(filesAndMetaData);
			else
				return null;
		} catch (Exception e) {
			LOG.debug("The exception is because of {}", e.getMessage());
			throw new CodingChallengeServiceException(e.getMessage());
		}
	}

	private FileMetaData createFileMetaDataToSave(FileMetaDataRequest fileMetaDataRequest) throws IOException {
		FileMetaData fileMetaData = new FileMetaData();
		fileMetaData.setFileName(fileMetaDataRequest.getFile().getOriginalFilename());
		fileMetaData.setData(fileMetaDataRequest.getFile().getBytes());
		fileMetaData.setFirstName(fileMetaDataRequest.getFirstName());
		fileMetaData.setLastName(fileMetaDataRequest.getLastName());
		fileMetaData.setPhoneNumber(fileMetaDataRequest.getPhoneNumber());
		fileMetaData.setEmail(fileMetaDataRequest.getEmail());
		return fileMetaData;
	}

	private List<FileMetaDataResponse> toFileMetaDataResponses(List<FileMetaData> filesAndMetaData) {
		List<FileMetaDataResponse> fileMetaDataResponses = new ArrayList<FileMetaDataResponse>();
		filesAndMetaData.forEach(fileAndMetaData -> {
			FileMetaDataResponse fileMetaDataResponse = new FileMetaDataResponse();
			fileMetaDataResponse.setFileName(fileAndMetaData.getFileName());
			fileMetaDataResponse.setFirstName(fileAndMetaData.getFirstName());
			fileMetaDataResponse.setLastName(fileAndMetaData.getLastName());
			fileMetaDataResponse.setPhoneNumber(fileAndMetaData.getPhoneNumber());
			fileMetaDataResponse.setEmail(fileAndMetaData.getEmail());
			fileMetaDataResponses.add(fileMetaDataResponse);
		});
		return fileMetaDataResponses;
	}

}
