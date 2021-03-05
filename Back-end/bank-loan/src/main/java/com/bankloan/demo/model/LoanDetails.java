package com.bankloan.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="loan_details")
public class LoanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanDetailsId;
	
	@Column(name="loan_type")
	private String loanType;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="insterest_rate")
	private String insterestRate;
	
	public LoanDetails() {}
	
	public LoanDetails(String loanType, String duration, String insterestRate) {
		super();
		this.loanType = loanType;
		this.duration = duration;
		this.insterestRate = insterestRate;
	}

	public int getLoanDetailsId() {
		return loanDetailsId;
	}

	public void setLoanDetailsId(int loanDetailsId) {
		this.loanDetailsId = loanDetailsId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getInsterestRate() {
		return insterestRate;
	}

	public void setInsterestRate(String insterestRate) {
		this.insterestRate = insterestRate;
	}

	
	
}
