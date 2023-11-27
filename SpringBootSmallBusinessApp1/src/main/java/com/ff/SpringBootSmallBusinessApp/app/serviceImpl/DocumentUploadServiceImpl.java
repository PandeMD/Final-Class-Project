package com.ff.SpringBootSmallBusinessApp.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ff.SpringBootSmallBusinessApp.app.model.DocumentUpload;
import com.ff.SpringBootSmallBusinessApp.app.repositary.DocumentUploadRepository;
import com.ff.SpringBootSmallBusinessApp.app.service.DocumentUploadService;

@Service
public class DocumentUploadServiceImpl implements DocumentUploadService {

	@Autowired
	DocumentUploadRepository documentUploadRepository;

	@Override
	public DocumentUpload saveDocument(DocumentUpload documentUpload) {

		return documentUploadRepository.save(documentUpload);

	}

	@Override
	public List<DocumentUpload> getDocument() {

		List<DocumentUpload> list = documentUploadRepository.findAll();

		return list;
	}

	@Override
	public DocumentUpload getSingleDocument(int id) {

		Optional<DocumentUpload> optional = documentUploadRepository.findById(id);

		DocumentUpload documentUpload = optional.get();

		return documentUpload;
	}

	@Override
	public List<DocumentUpload> deleteDocument(int id) {

		documentUploadRepository.findById(id);

		return documentUploadRepository.findAll();
	}

	@Override
	public DocumentUpload updateDocument(DocumentUpload documentUpload) {

		return documentUploadRepository.save(documentUpload);

	}

}

