package com.finra.codingchallenge.utils;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public interface Constants {

	public static final String REPOSITORY_PACKAGE = "com.finra.codingchallenge.repository";
	
	public static final String FAILURE = "fail";
	public static final String SUCCESS = "success";
	
	public static final String WEB_FILE_REQUEST = "/file";
	public static final String GET_FILE_META_DATA = "/getFileMetaData";
	public static final String ADD_FILE_META_DATA = "/upload/addFileMetaData";
	public static final String GET_FILE_META_DATA_WITH_FILE = "/file/getFileMetaData";
	public static final String UAS_ACTION_ERROR = "/errorPage";
	public static final String UAS_SERVICE_ERROR = "/errorPage?errorCode=500";
	public static final String UAS_CLIENT_ERROR = "/errorPage?errorCode=400";
	public static final String REDIRECT = "redirect:";
	
	
	public static final String FILE_META_DATA_REQUEST_NULL = "The fileMetaData request is null";
	public static final String PHONE_NUMBER_NOT_VALID = "The Phone number is not valid";
	public static final String INVALID_EMAIL = "The customer email is invalid";
	public static final String URL_PARAM_ERROR_CODE = "errorCode";
	public static final String FILE_DATA_NULL = "There is no file uploaded";
	public static final String INVALID_FIRSTNAME = "The first name is invalid";
	public static final String INVALID_LASTNAME = "The last anme is invalid";
	public static final String ERROR_DATA_NOT_SAVED = "There is some issue saving the data";
	public static final String FILE_META_DATA_NOT_FOUND = "There is no data for FileMetaData";
	public static final String FILE_AND_META_DATA_RESPONSES = "fileAndMetaDataResponses";
	public static final String EXCEPTION_REDIRECT = "Exception while Redirect";
	
	
	public static final String ERROR_PAGE = "error-page";
	public static final String GET_FILE_META_DATA_VIEW = "file/get-file-metadata";
	public static final String UPLOAD_VIEW = "file/upload-ui";
	public static final String WELCOME_VIEW = "welcome";

}
