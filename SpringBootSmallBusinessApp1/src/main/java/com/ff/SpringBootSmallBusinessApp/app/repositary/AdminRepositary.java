package com.ff.SpringBootSmallBusinessApp.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ff.SpringBootSmallBusinessApp.app.model.Admin;

@Repository
public interface AdminRepositary extends JpaRepository<Admin, Integer>
{

}
