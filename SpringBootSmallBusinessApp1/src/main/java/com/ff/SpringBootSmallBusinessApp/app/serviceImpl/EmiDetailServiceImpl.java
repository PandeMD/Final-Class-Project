package com.ff.SpringBootSmallBusinessApp.app.serviceImpl;

import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ff.SpringBootSmallBusinessApp.app.model.Emi;
import com.ff.SpringBootSmallBusinessApp.app.model.EmiDetail;
import com.ff.SpringBootSmallBusinessApp.app.repositary.EmiDetailRepositary;
import com.ff.SpringBootSmallBusinessApp.app.repositary.EmiRepositary;
import com.ff.SpringBootSmallBusinessApp.app.service.EmiDetailService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class EmiDetailServiceImpl implements EmiDetailService
{
	@Autowired
	EmiDetailRepositary er;
	
	@Autowired
	EmiRepositary em;

	@Override
	public EmiDetail saveEmiDetail(EmiDetail p) {
		
		Set<Emi> semail=new HashSet();
		
		int tenure=p.getEmiTenure();
		double total=p.getEmiTotalAmount();
		double roi=(p.getEmiRoi()/ 12) / 100;
		LocalDate date=LocalDate.now();
		
		double emi=((total * roi) * Math.pow(1 + roi, tenure) / (Math.pow(1 + roi, tenure) - 1));

//		for(int i=0;i<=tenure;i++)
//		{
//			Emi e=new Emi();
//			date=date.plusMonths(1);
//			e.setEmiAmount(total);
//			e.setEmiDate(date);
//			e.setEmiNumber(i+1);
//			e.setEmiStatus("Pending");
////			e.setEmiDetailId();
//		
//			if (total > emi) 
//			{
//				e.setEmiPaid(emi);
//			}
//			else 
//			{
//				e.setEmiPaid(total);
//			}
//			
//			double amount=total-(emi-roi*total);
//			
//			total=amount;
//			
//			semail.add(e);
//		}
		
		for(int i=1;i<=tenure;i++)
		{
			Emi e=new Emi();
			date=date.plusMonths(1);
			e.setEmiAmount(total);
			e.setEmiDate(date);
			e.setEmiNumber(i);
			e.setEmiStatus("Pending");
//			e.setEmiDetailId();
		
			if (total > emi) 
			{
				e.setEmiPaid(emi);
			}
			else 
			{
				e.setEmiPaid(total);
			}
			
			double amount=total-(emi-roi*total);
			
			total=amount;
			
			semail.add(e);
		}
		
		p.setEmi(semail);
		
		return er.save(p);
		
	}
	
	@Override
	public Iterable<EmiDetail> getEmiDetail() {
		return er.findAll();	
	}

	@Override
	public Iterable<EmiDetail> displayAllEmiDetail() {
		return er.findAll();
	}

	@Override
	public void deleteEmiDetail(Integer emiId) {
		er.deleteById(emiId);
	}

	@Override
	public EmiDetail getSingleEmiDetail(Integer emiId) {
		return er.findById(emiId).get();
	}

	@Override
	public Optional<EmiDetail> updateData(Integer emiId, LocalDate date) {
		return er.findById(emiId);
	}


	@Override
	public Iterable<Emi> getEmi() {
		return em.findAll();
	}

	@Override
	public List<EmiDetail> getEmiDefaulter(String status) {
		
//		Set<Emi> all = em.findAll();
//		Optional<EmiDetail> oe=er.findById(emiId);
//		EmiDetail ed=oe.get();
//		
//		Set<Emi> all=ed.getEmi();
//		int n=0;
//		
//		for(Emi e:all)
//		{
//			if(e.getEmiStatus().equals("Not Paid"))
//			{
//				n++;
//			}
//		}
//		
//		if(n==0)
//		{
//			ed.setEmiPreStatus("Regular");
//		}
//		else if(n>0 && n<3)
//		{
//			ed.setEmiPreStatus("Irregular");
//		}
//		else if(n>=3)
//		{
//			ed.setEmiPreStatus("Defaulter");
//		}
//		
//		er.save(ed);
//		
		if(status.equals("Regular"))
		{
			return er.findByEmiPreStatus(status);
		}
		else if(status.equals("Irregular"))
		{
			return er.findByEmiPreStatus(status);
		}
		else if(status.equals("Defaulter"))
		{
			return er.findByEmiPreStatus(status);
		}
		
		return null; 
		
//		List<Emi> all = em.findAll();
//		List<EmiDetail> defa  =new ArrayList();
//		int s=0;
//		int i = 0;
//		
//			for (Emi e : all) {				
//				if (e.getEmiDate().isBefore(LocalDate.now())) {
//					if (e.getEmiStatus().equalsIgnoreCase("Not Paid") || e.getEmiStatus().equalsIgnoreCase("pending")) {
//						i++;
//					}else{
//						i=0;
//					}						
//				}
//				if(i>=3) {
//					s++;
//				 Optional<EmiDetail> findById = er.findById(emiId);
//					if(findById.isPresent()) {
//						EmiDetail EmiDetail = findById.get();
//						defa.add(EmiDetail);
//					}
//				}
//			}
//			return defa;
	}

	@Override
	public Optional<Emi> updateEmiData(Integer emiCalId, LocalDate date) {
		return em.findById(emiCalId);
	}

	@Override
	public Emi saveEmi(Emi p) {
		return em.save(p);
	}

	@Override
	public EmiDetail ChangeEmiDetail(EmiDetail lr) {
		return er.save(lr);
	}
	
	@Override
	public void ganarateExl(HttpServletResponse responce, Integer emiId) 
	{
		EmiDetail e=er.findAllByEmiId(emiId);
		
		Set<Emi> all =e.getEmi();

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);

		 HSSFFont headerFont = workbook.createFont();
		  headerFont.setColor(IndexedColors.WHITE.index);
		  CellStyle headerCellStyle = sheet.getWorkbook().createCellStyle();
		  headerCellStyle.setDataFormat(workbook.createDataFormat().getFormat("#.##"));
		  // fill foreground color ...
		  headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.index);
		  // and solid fill pattern produces solid grey cell fill
		  headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		  headerCellStyle.setFont(headerFont);
		
		HSSFCell cell1 = row.createCell(0);
		cell1.setCellValue("EmiNumber");
		cell1.setCellStyle(headerCellStyle);
		
		HSSFCell cell2 = row.createCell(1);
		cell2.setCellValue("EmiDate");
		cell2.setCellStyle(headerCellStyle);
		
		HSSFCell cell3 = row.createCell(2);
		cell3.setCellValue("EmiAmount");
		cell3.setCellStyle(headerCellStyle);
		
		HSSFCell cell4 = row.createCell(3);
		cell4.setCellValue("EmiPaid");
		cell4.setCellStyle(headerCellStyle);
		
		HSSFCell cell5 = row.createCell(4);
		cell5.setCellValue("EmiStatus");
		cell5.setCellStyle(headerCellStyle);
		
		int i = 1;
		for (Emi al : all) {

			HSSFRow data = sheet.createRow(i);
			data.createCell(0).setCellValue(String.valueOf(i));
			;
			data.createCell(1).setCellValue("" + al.getEmiDate() + "");
			data.createCell(2).setCellValue(al.getEmiAmount());
			data.createCell(3).setCellValue(al.getEmiPaid());
			data.createCell(4).setCellValue(al.getEmiStatus());
			i++;

		}
		ServletOutputStream stream;
		try {
			stream = responce.getOutputStream();
			workbook.write(stream);
			workbook.close();
			stream.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		
	}

	@Override
	public String getSingleEmiDet(Integer emiId) {
		
		return null;
	}

	@Override
	public void ganaratePdf(HttpServletResponse response, Integer emiId) {
//			List<Emi> all =em.findAll();
		
		EmiDetail ede=er.findAllByEmiId(emiId);
		
		Set<Emi> all =ede.getEmi();
		
		 Optional<EmiDetail> edop = er.findById(emiId);
		 EmiDetail ed=edop.get();
		 
		Document document = new Document(PageSize.A4);
		try {
			PdfWriter.getInstance(document, response.getOutputStream());
		} catch (DocumentException e1) {
			e1.getMessage();
		} catch (IOException e1) {
			e1.getMessage();
		}

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.green);

		Paragraph p = new Paragraph("Ladger Report", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		

		document.add(p);
		
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(16);
		font.setColor(Color.black);
		
		Paragraph p1 = new Paragraph("LoanId-"+ed.getEmiId(), font1);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p1);
		
		Paragraph p2 = new Paragraph("Amount-"+ed.getEmiTotalAmount(), font1);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p2);
		PdfPTable table = new PdfPTable(5);
		
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 2.5f, 3.5f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);

		font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.BLUE);

		cell.setPhrase(new Phrase("Emi Number", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Payment Date", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Balance", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("EmiPaid", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Status", font));
		table.addCell(cell);
		int i = 1;
		
		for (Emi e : all) {
			table.addCell(String.valueOf(i));
			table.addCell(String.valueOf(e.getEmiDate()));
			table.addCell(String.valueOf(e.getEmiAmount()));
			table.addCell(String.valueOf(e.getEmiPaid()));
			table.addCell(e.getEmiStatus());
			i++;
		}
		document.add(table);
		document.close();

	}

	@Override
	public Emi getEmiDet(Integer emiDetailId) {
		return em.findById(emiDetailId).get();
	}

	@Override
	public Emi getSingleEmi(Integer emiCalId) {
		return em.findById(emiCalId).get();
	}
	
}
