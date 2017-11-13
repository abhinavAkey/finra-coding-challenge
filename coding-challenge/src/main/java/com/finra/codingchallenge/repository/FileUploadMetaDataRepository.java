package com.finra.codingchallenge.repository;

import java.util.List;

import com.finra.codingchallenge.repository.entity.FileMetaData;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public interface FileUploadMetaDataRepository {

	public long saveFileMetaData(FileMetaData fileMetaData);

	public List<FileMetaData> getAllFileMetaData();

}
