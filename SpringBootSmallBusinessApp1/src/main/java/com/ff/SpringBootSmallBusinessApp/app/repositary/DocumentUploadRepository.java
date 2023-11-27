package com.ff.SpringBootSmallBusinessApp.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ff.SpringBootSmallBusinessApp.app.model.DocumentUpload;

@Repository
public interface DocumentUploadRepository extends JpaRepository<DocumentUpload, Integer> {

}