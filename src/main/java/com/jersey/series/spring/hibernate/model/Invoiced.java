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
@Table(name="invoiced")
public class Invoiced {
	@Id
	@SequenceGenerator(name="invoiceSeq", initialValue=1, allocationSize=100)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="invoiceSeq") 
	Long invoiceNo;
	String inwardNo,dispatchId,party,component, material;
	 
	Double qtyKgs,  qtyNos, rateKg,  rateNos,total;
	Date creationDate;
	
	public String getInvoiceNo() {
		return invoiceNo.toString();
	}
	public String getInwardNo() {
		return inwardNo;
	}
	public String getDispatchId() {
		return dispatchId;
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
	public Double getQtyKgs() {
		return qtyKgs;
	}
	public Double getQtyNos() {
		return qtyNos;
	}
	public Double getRateKg() {
		return rateKg;
	}
	public Double getRateNos() {
		return rateNos;
	}
	public Double getTotal() {
		return total;
	}
	public String getCreationDate() {
		return CommonUtils.formatDate(creationDate);
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = Long.parseLong(invoiceNo);
	}
	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}
	public void setDispatchId(String dispatchId) {
		this.dispatchId = dispatchId;
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
	public void setQtyKgs(Double qtyKgs) {
		this.qtyKgs = qtyKgs;
	}
	public void setQtyNos(Double qtyNos) {
		this.qtyNos = qtyNos;
	}
	public void setRateKg(Double rateKg) {
		this.rateKg = rateKg;
	}
	public void setRateNos(Double rateNos) {
		this.rateNos = rateNos;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	 
}