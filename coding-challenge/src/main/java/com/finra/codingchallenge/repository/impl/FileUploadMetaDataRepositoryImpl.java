package com.finra.codingchallenge.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finra.codingchallenge.repository.FileUploadMetaDataRepository;
import com.finra.codingchallenge.repository.entity.FileMetaData;
import com.finra.codingchallenge.utils.Constants;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
@Repository(value = "fileUploadMetaDataRepository")
public class FileUploadMetaDataRepositoryImpl implements FileUploadMetaDataRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadMetaDataRepositoryImpl.class);

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public long saveFileMetaData(FileMetaData fileMetaData) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(fileMetaData);
		entityManager.flush();
		long id = fileMetaData.getId();
		entityManager.getTransaction().commit();
		entityManager.close();
		return id;
	}

	@Override
	public List<FileMetaData> getAllFileMetaData() {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			List<FileMetaData> filesMetaData = entityManager
					.createQuery(RepositoryConstants.FIND_LIST_OF_FILE_META_DATA, FileMetaData.class).getResultList();
			entityManager.close();
			return filesMetaData;
		} catch (NoResultException exception) {
			LOGGER.debug(Constants.FILE_META_DATA_NOT_FOUND);
			return null;
		}
	}

}
