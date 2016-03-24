package com.jersey.series.spring.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity  
@Table(name="party") 
public class Party {

	String partyName;
	 
	@Id
	@SequenceGenerator(name="partySeq", initialValue=1, allocationSize=100)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="partySeq") 
	Long partyId;
	String partyAddress;
	String partyPhone; 
	String partyEmail;
	String partySupplierCode;

	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) { 
		this.partyName = partyName;
	}
	public String getPartyId() {
		return partyId.toString();  
	}
	public void setPartyId(String partyId) {
		this.partyId = Long.parseLong(partyId);
	}
	public String getPartyAddress() {
		return partyAddress;
	}
	public void setPartyAddress(String partyAddress) {
		this.partyAddress = partyAddress;
	}
	public String getPartyPhone() {
		return partyPhone;
	}
	public void setPartyPhone(String partyPhone) {
		this.partyPhone = partyPhone;
	}
	public String getPartyEmail() {
		return partyEmail;
	}
	public void setPartyEmail(String partyEmail) {
		this.partyEmail = partyEmail;
	}
	public String getPartySupplierCode() {
		return partySupplierCode;
	}
	public void setPartySupplierCode(String partySupplierCode) {
		this.partySupplierCode = partySupplierCode;
	}
}
