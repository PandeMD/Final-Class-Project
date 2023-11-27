package com.ff.SpringBootSmallBusinessApp.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ff.SpringBootSmallBusinessApp.app.model.DocumentUpload;
import com.ff.SpringBootSmallBusinessApp.app.serviceImpl.DocumentUploadServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class DocumentUploadController {

	@Autowired
	DocumentUploadServiceImpl documentUploadServiceImpl;

	//post api to save documents of customer in the database

	@RequestMapping(value = "/save-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<DocumentUpload> saveDocument(
			@RequestPart(required = true, value = "pancard") MultipartFile pancard,
			@RequestPart(required = true, value = "aadhaarcard") MultipartFile aadhaarcard,
			@RequestPart(required = true, value = "photocopy") MultipartFile photocopy,
			@RequestPart(required = true, value = "bankstatement") MultipartFile bankstatement,
			@RequestPart(required = true, value = "registrationproof") MultipartFile registrationproof,
			@RequestPart(required = true, value = "addressproof") MultipartFile addressproof,
			@RequestPart(required = true, value = "sign") MultipartFile sign,
			@RequestPart(required = true, value = "blankcheque") MultipartFile blankcheque,
			@RequestPart(required = true, value = "itrcopy") MultipartFile itrcopy,
			@RequestPart(required = true, value = "documentid") String documentId) {

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// convert JSON to java
			DocumentUpload documentUpload = objectMapper.readValue(documentId, DocumentUpload.class);

			System.out.println(documentUpload);

			// convert java to JSON
			String json = objectMapper.writeValueAsString(documentUpload);

			System.out.println(json);

			DocumentUpload upload = new DocumentUpload();

			upload.setDocumentId(documentUpload.getDocumentId());
			upload.setPancard(pancard.getBytes());
			upload.setAadhaarCard(aadhaarcard.getBytes());
			upload.setPhotoCopy(photocopy.getBytes());
			upload.setBankStatement(bankstatement.getBytes());
			upload.setRegistrationProof(registrationproof.getBytes());
			upload.setAddressProof(addressproof.getBytes());
			upload.setSignature(sign.getBytes());
			upload.setBlankCheque(blankcheque.getBytes());
			upload.setItrCopy(itrcopy.getBytes());

			DocumentUpload doUpload = documentUploadServiceImpl.saveDocument(upload);

			return new ResponseEntity<DocumentUpload>(doUpload, HttpStatus.CREATED);

		}

		catch (JsonMappingException e) {

			e.printStackTrace();

			return new ResponseEntity<DocumentUpload>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (JsonProcessingException e) {

			e.printStackTrace();

			return new ResponseEntity<DocumentUpload>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (IOException e) {

			e.printStackTrace();

			return new ResponseEntity<DocumentUpload>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	//get api to retrieve documents of all customers from the database

	@RequestMapping(value = "/get-document", method = RequestMethod.GET)
	public ResponseEntity<List<DocumentUpload>> getDocument() {

		List<DocumentUpload> list = documentUploadServiceImpl.getDocument();

		return new ResponseEntity<List<DocumentUpload>>(list, HttpStatus.OK);

	}

	//get api to retrieve documents of a particular customer from the database

	@RequestMapping(value = "/get-document/{id}", method = RequestMethod.GET)
	public ResponseEntity<DocumentUpload> getDocumentbyId(@PathVariable(value = "id") int documentId) {
		System.out.println(documentId);
		DocumentUpload documentUpload = documentUploadServiceImpl.getSingleDocument(documentId);

		return new ResponseEntity<DocumentUpload>(documentUpload, HttpStatus.OK);

	}

	//delete api to delete documents of a particular customer from the database

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/delete-document/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteDocument(@PathVariable(value = "id") int documentId) {

		documentUploadServiceImpl.deleteDocument(documentId);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	//update api to update documents of a particular customer in the database

	@RequestMapping(value = "/update-document", method = RequestMethod.PATCH, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<DocumentUpload> updateDocument(
			@RequestPart(required = true, value = "pancard") MultipartFile pancard,
			@RequestPart(required = true, value = "aadhaarcard") MultipartFile aadhaarcard,
			@RequestPart(required = true, value = "photocopy") MultipartFile photocopy,
			@RequestPart(required = true, value = "bankstatement") MultipartFile bankstatement,
			@RequestPart(required = true, value = "registrationproof") MultipartFile registrationproof,
			@RequestPart(required = true, value = "addressproof") MultipartFile addressproof,
			@RequestPart(required = true, value = "sign") MultipartFile sign,
			@RequestPart(required = true, value = "blankcheque") MultipartFile blankcheque,
			@RequestPart(required = true, value = "itrcopy") MultipartFile itrcopy,
			@RequestPart(required = true, value = "documentid") String documentId) {

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// convert JSON to java
			DocumentUpload documentUpload = objectMapper.readValue(documentId, DocumentUpload.class);

			System.out.println(documentUpload);

			// convert java to JSON
			String json = objectMapper.writeValueAsString(documentUpload);

			System.out.println(json);

			DocumentUpload upload = new DocumentUpload();

			upload.setDocumentId(documentUpload.getDocumentId());
			upload.setPancard(pancard.getBytes());
			upload.setAadhaarCard(aadhaarcard.getBytes());
			upload.setPhotoCopy(photocopy.getBytes());
			upload.setBankStatement(bankstatement.getBytes());
			upload.setRegistrationProof(registrationproof.getBytes());
			upload.setAddressProof(addressproof.getBytes());
			upload.setSignature(sign.getBytes());
			upload.setBlankCheque(blankcheque.getBytes());
			upload.setItrCopy(itrcopy.getBytes());

			DocumentUpload doUpload = documentUploadServiceImpl.updateDocument(upload);

			return new ResponseEntity<DocumentUpload>(doUpload, HttpStatus.OK);

		}

		catch (JsonMappingException e) {

			e.printStackTrace();

			return new ResponseEntity<DocumentUpload>(HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (JsonProcessingException e) {

			e.printStackTrace();

			return new ResponseEntity<DocumentUpload>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (IOException e) {

			e.printStackTrace();

			return new ResponseEntity<DocumentUpload>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}