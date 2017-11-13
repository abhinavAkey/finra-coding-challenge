package com.finra.codingchallenge.validator.impl;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.finra.codingchallenge.exception.CodingChallengeClientValidationException;
import com.finra.codingchallenge.model.request.FileMetaDataRequest;
import com.finra.codingchallenge.utils.Constants;
import com.finra.codingchallenge.validator.FileUploadMetaDataValidator;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
@Component(value = "fileUploadMetaDataValidator")
public class FileUploadMetaDataValidatorImpl implements FileUploadMetaDataValidator {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadMetaDataValidatorImpl.class);

	private static final Pattern EMAIL_REGEX_PATTERN = Pattern
			.compile("^[_\\pL\\pN-\\*\\+]+(\\.[_\\pL\\pN-]+)*@[\\pL\\pN-]+(\\.[\\pL\\pN]+)*(\\.[\\pL]{2,})$");
	
	private static final Pattern NAME_REGEX_PATTERN = Pattern.compile("^[a-zA-Z0-9 ]+$");

	private static final Pattern NUMBER_REGEX_PATTERN = Pattern.compile("^[0-9]+$");

	@Override
	public boolean isValidFileMetaDataRequest(FileMetaDataRequest fileMetaDataRequest) {
		LOGGER.info("In validateCustomerEmailAndSeats");
		if (fileMetaDataRequest == null) {
			throw new CodingChallengeClientValidationException(Constants.FILE_META_DATA_REQUEST_NULL);
		}
		if (fileMetaDataRequest.getFile() == null || StringUtils.isEmpty(fileMetaDataRequest.getFile().getName())) {
			throw new CodingChallengeClientValidationException(Constants.FILE_DATA_NULL);
		}
		if (StringUtils.isEmpty(fileMetaDataRequest.getFirstName())
				|| !NAME_REGEX_PATTERN.matcher(fileMetaDataRequest.getFirstName()).matches()) {
			throw new CodingChallengeClientValidationException(Constants.INVALID_FIRSTNAME);
		}
		if (StringUtils.isEmpty(fileMetaDataRequest.getLastName())
				|| !NAME_REGEX_PATTERN.matcher(fileMetaDataRequest.getLastName()).matches()) {
			throw new CodingChallengeClientValidationException(Constants.INVALID_LASTNAME);
		}
		if (StringUtils.isEmpty(fileMetaDataRequest.getPhoneNumber())
				|| !NUMBER_REGEX_PATTERN.matcher(fileMetaDataRequest.getPhoneNumber()).matches()
				|| fileMetaDataRequest.getPhoneNumber().length() > 10) {
			throw new CodingChallengeClientValidationException(Constants.PHONE_NUMBER_NOT_VALID);
		}
		if (StringUtils.isEmpty(fileMetaDataRequest.getEmail())
				|| !EMAIL_REGEX_PATTERN.matcher(fileMetaDataRequest.getEmail()).matches()) {
			throw new CodingChallengeClientValidationException(Constants.INVALID_EMAIL);
		}
		return true;
	}

}
