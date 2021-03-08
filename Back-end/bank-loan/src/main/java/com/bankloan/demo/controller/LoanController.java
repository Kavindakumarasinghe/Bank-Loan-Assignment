package com.bankloan.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.bankloan.demo.exceptions.ResourceNotFoundException;
import com.bankloan.demo.model.LoanDetails;
import com.bankloan.demo.repository.LoanDetailsRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class LoanDetailsController {
	
	@Autowired
	private LoanDetailsRepository loanDetailsRepository;
	
	//get all loan details
	
	@GetMapping("/loandetails")
	public List<LoanDetails> getAllLoanDetails(){
		return loanDetailsRepository.findAll();
	}
	
	
	
	@GetMapping("/loandetails/{loan_details_id}")
	public ResponseEntity<LoanDetails> getLoanDetailsById(@PathVariable int loan_details_id){
		LoanDetails loanDetails = loanDetailsRepository.findById(loan_details_id)
				.orElseThrow(() ->new ResourceNotFoundException("Customer not exist with id:"+ loan_details_id));
		return ResponseEntity.ok(loanDetails);
	}

	
	//post loan details
	
	@PostMapping("/loandetails")
	public LoanDetails loanDetails (@RequestBody LoanDetails loanDetails)
	{
		return loanDetailsRepository.save(loanDetails);
	}

	// update loan details
	
	@PutMapping("/loandetails/{loan_details_id}")
	public ResponseEntity<LoanDetails> updateLoanDetails(@PathVariable int loan_details_id, @RequestBody LoanDetails loanDetails){
		
	 
		LoanDetails loanDetailsNew = loanDetailsRepository.findById(loan_details_id)
		 .orElseThrow(() ->new ResourceNotFoundException("Loan Details not exist with id:"+ loan_details_id));
				 
		loanDetailsNew.setDuration(loanDetails.getDuration());
		loanDetailsNew.setInsterestRate(loanDetails.getInsterestRate());
		loanDetailsNew.setLoanType(loanDetails.getLoanType());
		
		LoanDetails updatedLoanDetails = loanDetailsRepository.save(loanDetailsNew);
		return ResponseEntity.ok(updatedLoanDetails);
		
		
	}
	
	//delete loan details 
	
	@DeleteMapping("/loandetails/{loan_details_id}")
	public ResponseEntity<Map<String, Boolean>> deleteLoanDetails(@PathVariable int loan_details_id){
		
		LoanDetails loanDetails = loanDetailsRepository.findById(loan_details_id)
				.orElseThrow(() -> new ResourceNotFoundException("Loan Details not exist with id:"+ loan_details_id));
		loanDetailsRepository.delete(loanDetails);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	} 
}
