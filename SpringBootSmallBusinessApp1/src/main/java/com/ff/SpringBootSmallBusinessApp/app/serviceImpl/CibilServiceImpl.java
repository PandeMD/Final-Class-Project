package com.ff.SpringBootSmallBusinessApp.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ff.SpringBootSmallBusinessApp.app.model.CibilScore;
import com.ff.SpringBootSmallBusinessApp.app.repositary.CibilRepository;
import com.ff.SpringBootSmallBusinessApp.app.service.CibilService;

@Service
public class CibilServiceImpl implements CibilService {
	
@Autowired
CibilRepository cr;

	@Override
	public Iterable<CibilScore> displayCibil() {
		return cr.findAll();
	}
	@Override
	public CibilScore findCibilById(int cibilId) {
		return cr.findById(cibilId);
	}
	@Override
	public CibilScore saveCibil(CibilScore c) {
		return cr.save(c);
	}
	@Override
	public Optional<CibilScore> updateCibil(int cibilId) {
		return cr.findBycibilId(cibilId);
	}
	@Override
	public void deleteCibil(int cibilId) {
		cr.deleteById(cibilId);
	}
}
