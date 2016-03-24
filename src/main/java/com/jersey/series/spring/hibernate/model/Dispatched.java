package com.jersey.series.spring.hibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jersey.series.spring.hibernate.utils.CommonUtils;

@Entity  
@Table(name="dispatched")
public class Dispatched {


	@Id
	@SequenceGenerator(name="dispatchSeq", initialValue=1, allocationSize=100)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="dispatchSeq") 
	Long dispatchId;

	Date creationDate;

	double qtyKgs,qtyNos,rateKg,rateNos,total;

	String inwardNo;
	
	String party,component, material;

	public String getCreationDate() {
		return CommonUtils.formatDate(creationDate);
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public double getQtyKgs() {
		return qtyKgs;
	}
	public void setQtyKgs(double qtyKgs) {
		this.qtyKgs = qtyKgs;
	}
	public double getQtyNos() {
		return qtyNos;
	}
	public void setQtyNos(double qtyNos) { 
		this.qtyNos = qtyNos;
	}
	public String getInwardNo() {
		return inwardNo;
	}
	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}
	public String getDispatchId() {
		return dispatchId.toString();
	}
	public void setDispatchId(String dispatchId) {
		this.dispatchId = Long.parseLong(dispatchId);
	}
	public double getRateKg() {
		return rateKg;
	}
	public void setRateKg(double rateKg) {
		this.rateKg = rateKg;
	}
	public double getRateNos() {
		return rateNos;
	}
	public void setRateNos(double rateNos) {
		this.rateNos = rateNos;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getParty() {
		return party;
	}
	public String getComponent() {
		return component;
	}
	public String getMaterial() {
		return material;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

}
