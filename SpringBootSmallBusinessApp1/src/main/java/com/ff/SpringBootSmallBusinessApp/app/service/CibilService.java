package com.ff.SpringBootSmallBusinessApp.app.service;


import java.util.Optional;

import com.ff.SpringBootSmallBusinessApp.app.model.CibilScore;

public interface CibilService {
public CibilScore saveCibil(CibilScore c);
public Optional<CibilScore> updateCibil(int cibilId);
public Iterable<CibilScore> displayCibil();
public CibilScore findCibilById(int cibilId);
public void deleteCibil(int cibilId);
}
