package com.ff.SpringBootSmallBusinessApp.app.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ff.SpringBootSmallBusinessApp.app.model.CibilScore;

@Repository
public interface CibilRepository extends JpaRepository<CibilScore, Integer> {
	CibilScore findById(int cibilId);

	Optional<CibilScore> findBycibilId(int cibilId);
}
