package com.ff.SpringBootSmallBusinessApp.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.ff.SpringBootSmallBusinessApp.app.model.Emi;
import com.ff.SpringBootSmallBusinessApp.app.model.EmiDetail;

public interface EmiDetailService 
{

	public EmiDetail saveEmiDetail(EmiDetail p);

	public Optional<EmiDetail> updateData(Integer emiId,LocalDate date);

	public Iterable<EmiDetail> getEmiDetail();

	public Iterable<EmiDetail> displayAllEmiDetail();

	public void deleteEmiDetail(Integer emiId);

	public EmiDetail getSingleEmiDetail(Integer emiId);

	public Iterable<Emi> getEmi();

	public List<EmiDetail> getEmiDefaulter(String status);

	public Optional<Emi> updateEmiData(Integer emiCalId, LocalDate date);

	public Emi saveEmi(Emi p);

	public EmiDetail ChangeEmiDetail(EmiDetail lr);

	public void ganarateExl(HttpServletResponse responce, Integer emiId);

	public String getSingleEmiDet(Integer emiId);

	public void ganaratePdf(HttpServletResponse response, Integer emiId);

	public Emi getEmiDet(Integer emiDetailId);

	public Emi getSingleEmi(Integer emiCalId);
}
