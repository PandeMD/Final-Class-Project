package com.ff.SpringBootSmallBusinessApp.app.service;

import java.util.List;

import com.ff.SpringBootSmallBusinessApp.app.model.DocumentUpload;

public interface DocumentUploadService {

	public DocumentUpload saveDocument(DocumentUpload documentUpload);

	public List<DocumentUpload> getDocument();

	public DocumentUpload getSingleDocument(int id);

	public DocumentUpload updateDocument(DocumentUpload documentUpload);

	public List<DocumentUpload> deleteDocument(int id);

}

