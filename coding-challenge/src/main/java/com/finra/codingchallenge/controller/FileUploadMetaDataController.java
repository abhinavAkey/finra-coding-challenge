package com.finra.codingchallenge.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finra.codingchallenge.exception.CodingChallengeClientValidationException;
import com.finra.codingchallenge.exception.CodingChallengeServiceException;
import com.finra.codingchallenge.model.request.FileMetaDataRequest;
import com.finra.codingchallenge.model.response.FileMetaDataResponse;
import com.finra.codingchallenge.service.FileUploadMetaDataService;
import com.finra.codingchallenge.utils.Constants;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
@Controller
@RequestMapping(Constants.WEB_FILE_REQUEST)
public class FileUploadMetaDataController extends BaseController{

	private static final Logger LOG = LoggerFactory.getLogger(FileUploadMetaDataController.class);

	@Resource(name = "fileUploadMetaDataService")
	private FileUploadMetaDataService fileUploadMetaDataService;

	@RequestMapping(value = Constants.ADD_FILE_META_DATA, method = RequestMethod.GET)
	public String uploadFileMetaDataView(HttpServletRequest request, HttpServletResponse response)
			throws CodingChallengeServiceException, CodingChallengeClientValidationException {
		LOG.debug("File to be uploaded UI");
		return Constants.UPLOAD_VIEW;
	}

	@RequestMapping(value = Constants.ADD_FILE_META_DATA, method = RequestMethod.POST)
	public String uploadFileMetaData(
			@RequestParam(value = "file", required = true) final MultipartFile file,
			@RequestParam(value = "firstName", required = true) final String firstName,
			@RequestParam(value = "lastName", required = true) final String lastName,
			@RequestParam(value = "phoneNumber", required = true) final String phoneNumber,
			@RequestParam(value = "email", required = true) final String email,
			HttpServletRequest request,
			HttpServletResponse response)
			throws CodingChallengeServiceException, CodingChallengeClientValidationException {
		LOG.debug("File to be uploaded for the request with firstname {}", firstName);
		FileMetaDataRequest fileMetaDataRequest = toFileMetaDataRequest(file, firstName, lastName, phoneNumber, email);
		LOG.debug("The request is valid {}", fileMetaDataRequest.toString());
		boolean isDataSaved = fileUploadMetaDataService.saveUploadedFileAndMetaData(fileMetaDataRequest);
		if(isDataSaved)
			return Constants.REDIRECT + Constants.GET_FILE_META_DATA_WITH_FILE;
		else 
			return Constants.REDIRECT + Constants.UAS_SERVICE_ERROR;
	}
	
	@RequestMapping(value = Constants.GET_FILE_META_DATA, method = RequestMethod.GET)
	public String getFileMetaData(Model model, HttpServletRequest request, HttpServletResponse response)
			throws CodingChallengeServiceException, CodingChallengeClientValidationException {
		LOG.debug("File to be uploaded UI");
		List<FileMetaDataResponse> responses = fileUploadMetaDataService.getAllFileNamesAndMetaData();
		model.addAttribute(Constants.FILE_AND_META_DATA_RESPONSES, responses);
		return Constants.GET_FILE_META_DATA_VIEW;
	}
}
