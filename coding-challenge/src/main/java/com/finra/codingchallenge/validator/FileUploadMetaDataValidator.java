package com.finra.codingchallenge.validator;

import com.finra.codingchallenge.model.request.FileMetaDataRequest;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public interface FileUploadMetaDataValidator {

	public boolean isValidFileMetaDataRequest(FileMetaDataRequest fileMetaDataRequest);

}
