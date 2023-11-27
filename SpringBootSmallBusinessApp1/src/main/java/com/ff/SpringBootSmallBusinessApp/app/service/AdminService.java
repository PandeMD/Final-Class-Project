package com.ff.SpringBootSmallBusinessApp.app.service;

import com.ff.SpringBootSmallBusinessApp.app.model.Admin;

public interface AdminService {

	public Admin saveAdmin(Admin adm);

	public Iterable<Admin> getAdmin();

}
