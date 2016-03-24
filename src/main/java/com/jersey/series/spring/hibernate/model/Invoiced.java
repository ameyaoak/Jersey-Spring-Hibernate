package com.jersey.series.spring.hibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;

@Entity  
@Table(name="invoiced")
public class Invoiced {
	@Id
	@SequenceGenerator(name="invoiceSeq", initialValue=1, allocationSize=100)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="invoiceSeq") 
	Long invoiceNo;
	
	
	String inwardNo,dispatchId;
	
	Double qtyKgs,  qtyNos, rateKg,  rateNos,total;
	Date creationDate;
	public String getInvoiceNo() {
		return invoiceNo.toString();
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = Long.parseLong(invoiceNo);
	}
	public String getInwardNo() {
		return inwardNo;
	}
	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}
	public String getDispatchId() {
		return dispatchId;
	}
	public void setDispatchId(String dispatchId) {
		this.dispatchId = dispatchId;
	}
	public Double getQtyKgs() {
		return qtyKgs;
	}
	public void setQtyKgs(Double qtyKgs) {
		this.qtyKgs = qtyKgs;
	}
	public Double getQtyNos() {
		return qtyNos;
	}
	public void setQtyNos(Double qtyNos) {
		this.qtyNos = qtyNos;
	}
	public Double getRateKg() {
		return rateKg;
	}
	public void setRateKg(Double rateKg) {
		this.rateKg = rateKg;
	}
	public Double getRateNos() {
		return rateNos;
	}
	public void setRateNos(Double rateNos) {
		this.rateNos = rateNos;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
