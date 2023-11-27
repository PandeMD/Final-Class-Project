package com.ff.SpringBootSmallBusinessApp.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ff.SpringBootSmallBusinessApp.app.model.Emi;

@Repository
public interface EmiRepositary extends JpaRepository<Emi,Integer> {

}
