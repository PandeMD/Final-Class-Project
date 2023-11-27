package com.ff.SpringBootSmallBusinessApp.app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.SpringBootSmallBusinessApp.app.model.Emi;
import com.ff.SpringBootSmallBusinessApp.app.model.EmiDetail;
import com.ff.SpringBootSmallBusinessApp.app.repositary.EmiDetailRepositary;
import com.ff.SpringBootSmallBusinessApp.app.repositary.EmiRepositary;
import com.ff.SpringBootSmallBusinessApp.app.service.EmiDetailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmiDetailController 
{
	@Autowired
	EmiDetailService ls;
	
	@Autowired
	EmiDetailRepositary er;
	
	@Autowired
	EmiRepositary em;
	
		//Post API
		@PostMapping(value = "/detail")
		public ResponseEntity<EmiDetail> saveEmiDetail(@RequestBody EmiDetail p)
		{
			try {
			EmiDetail lr=ls.saveEmiDetail(p);
			Set<Emi> se=lr.getEmi();
			for(Emi e:se)
			{
				e.setEmiDetailId(lr.getEmiId());
//				em.save(e);
			}

			lr.setEmi(se);
			EmiDetail lre=ls.ChangeEmiDetail(lr);
			
			return new ResponseEntity<EmiDetail>(lre,HttpStatus.CREATED);
			}
			catch(Exception ex)
			{
				ex.getMessage();
			}
			return new ResponseEntity<EmiDetail>(HttpStatus.CREATED);
		}
		

		//Update API
		@PutMapping(value = "/detail/{emiId}")
		public ResponseEntity<EmiDetail> updateEmiDetail(@PathVariable("emiId") Integer emiId,@RequestBody EmiDetail p)
		{
			Optional<EmiDetail> ip=ls.updateData(emiId,LocalDate.now());
			if(ip.isPresent())
			{
				p.setEmiId(ip.get().getEmiId());
				EmiDetail g=ls.saveEmiDetail(p);
				return new ResponseEntity<EmiDetail>(g,HttpStatus.OK);	
			}
			return null;
		}
		
		@PutMapping(value = "/emidetail/{emiCalId}")
		public ResponseEntity<Emi> updateEmi(@PathVariable("emiCalId") Integer emiCalId,@RequestBody Emi p)
		{
			Optional<Emi> ip=ls.updateEmiData(emiCalId,LocalDate.now());
			if(ip.isPresent())
			{
				p.setEmiCalId(ip.get().getEmiCalId());
				Emi g=ls.saveEmi(p);
				
				Optional<EmiDetail> oe=er.findById(g.getEmiDetailId());
				EmiDetail ed=oe.get();
				
				Set<Emi> all=ed.getEmi();
				System.out.println(all.size());
				int n=0;
				
				for(Emi e:all)
				{
					System.out.println(e.getEmiStatus());
					if(e.getEmiStatus().equals("NotPaid"))
					{
						System.out.println(n);
						n++;
					}
				}
				System.out.println(n);
				if(n==0)
				{
					ed.setEmiPreStatus("Regular");
				}
				else if(n>0 && n<3)
				{
					ed.setEmiPreStatus("Irregular");
				}
				else if(n>=3)
				{
					ed.setEmiPreStatus("Defaulter");
				}
				
				er.save(ed);
				
				return new ResponseEntity<Emi>(g,HttpStatus.OK);	
			}
			return null;
		}
		
		//GetAPI
		@GetMapping(value = "/detail")
		public ResponseEntity<Iterable<EmiDetail>> getEmiDetail()
		{
			Iterable<EmiDetail> ed=ls.getEmiDetail();
			Iterable<EmiDetail> ip=ls.displayAllEmiDetail();
			return new ResponseEntity<Iterable<EmiDetail>>(ed,HttpStatus.OK);	
		}
		
		@GetMapping(value = "/emidetail")
		public ResponseEntity<Iterable<Emi>> getEmi()
		{
			Iterable<Emi> ed=ls.getEmi();
			return new ResponseEntity<Iterable<Emi>>(ed,HttpStatus.OK);	
		}
		
		@GetMapping(value = "/defaultdetail/{status}")
		public ResponseEntity<List<EmiDetail>> getEmiDefaulter(@PathVariable("status") String status)
		{
			List<EmiDetail> ed=ls.getEmiDefaulter(status);
			return new ResponseEntity<List<EmiDetail>>(ed,HttpStatus.OK);	
		}
		
		@GetMapping(value = "/emidetail/{emiCalId}")
		public ResponseEntity<Iterable<Emi>> getSingleEmi(@PathVariable("emiCalId") Integer emiCalId)
		{
			Emi ed=ls.getSingleEmi(emiCalId);
			return new ResponseEntity<Iterable<Emi>>(HttpStatus.OK);	
		}
		
		@GetMapping(value = "/emidetail/{emiDetailId}")
		public ResponseEntity<Iterable<Emi>> getSingleEmiDet(@PathVariable("emiDetailId") Integer emiDetailId)
		{
			Emi ed=ls.getEmiDet(emiDetailId);
			return new ResponseEntity<Iterable<Emi>>(HttpStatus.OK);	
		}
		
		//GetAPI ID
		@GetMapping(value = "/detail/{emiId}")
		public ResponseEntity<EmiDetail> getSingleEmiDetail(@PathVariable("emiId") Integer emiId)
		{
			EmiDetail e=ls.getSingleEmiDetail(emiId);
			return new ResponseEntity<EmiDetail>(e,HttpStatus.FOUND);	
		}
		
		//Delete API
		@DeleteMapping(value = "/detail/{emiId}")
		public ResponseEntity<String> deleteEmiDetail(@PathVariable("emiId") Integer emiId)
		{
			ls.deleteEmiDetail(emiId);
			
			Iterable<EmiDetail> ip=ls.displayAllEmiDetail();
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);	
		}
		
		//Excel Pdf
		
		@GetMapping("/excel/{emiId}")
		public void getExcl(HttpServletResponse responce,@PathVariable Integer emiId ) {
			responce.setContentType("application/octet-stream");
			String hk="Content-Disposition";
			String val="attachment;filename=data.xls";
			responce.setHeader(hk, val);
			ls.ganarateExl(responce, emiId);
		}
		
		@GetMapping("/genPdf/{emiId}")
		public void getPdf(HttpServletResponse response,@PathVariable Integer emiId) {
			response.setContentType("application/pdf");
			String EmiCal = ls.getSingleEmiDet(emiId);
			String hk="Content-Disposition";
			String val="attachment;filename="+EmiCal+".pdf";
			
			response.setHeader(hk, val);
			ls.ganaratePdf(response, emiId);		
		}


}
