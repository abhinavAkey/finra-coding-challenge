package com.finra.codingchallenge.service;

import java.util.List;

import com.finra.codingchallenge.model.request.FileMetaDataRequest;
import com.finra.codingchallenge.model.response.FileMetaDataResponse;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public interface FileUploadMetaDataService {

	public boolean saveUploadedFileAndMetaData(FileMetaDataRequest fileMetaDataRequest);

	public List<FileMetaDataResponse> getAllFileNamesAndMetaData();

}
