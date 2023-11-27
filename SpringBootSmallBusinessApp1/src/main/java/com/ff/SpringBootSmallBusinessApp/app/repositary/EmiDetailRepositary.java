package com.ff.SpringBootSmallBusinessApp.app.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ff.SpringBootSmallBusinessApp.app.model.EmiDetail;

@Repository
public interface EmiDetailRepositary extends JpaRepository<EmiDetail, Integer>
{
	public List<EmiDetail> findByEmiPreStatus(String status); 
	
	public EmiDetail findAllByEmiId(Integer emiId);


}
