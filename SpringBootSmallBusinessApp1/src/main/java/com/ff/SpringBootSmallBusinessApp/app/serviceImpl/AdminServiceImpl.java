package com.ff.SpringBootSmallBusinessApp.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ff.SpringBootSmallBusinessApp.app.model.Admin;
import com.ff.SpringBootSmallBusinessApp.app.repositary.AdminRepositary;
import com.ff.SpringBootSmallBusinessApp.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	AdminRepositary adr;
	
	@Override
	public Admin saveAdmin(Admin adm) {
		return adr.save(adm);
	}

	@Override
	public Iterable<Admin> getAdmin() {
		return adr.findAll();
	}

}
