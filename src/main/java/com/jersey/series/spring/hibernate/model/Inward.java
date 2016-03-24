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
@Table(name="inward")
public class Inward {
	@Id
	@SequenceGenerator(name="inwardSeq", initialValue=1, allocationSize=100)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="inwardSeq") 
	Long inwardNo;
	String party,component, material, partNo, process,  poNo,  coreHd,  surfaceHd, caseDepth,  crack,  micro,  distortation,sf, wtt, remark, layerThickness,  apperance;
	Double qtyKgs,  qtyNos, rateKg,  rateNos;
	String poDate; 
	
	Date creationDate;
	
	public String getInwardNo() {
		return inwardNo.toString();
	}
	public void setInwardNo(String inwardNo) {
		this.inwardNo = Long.parseLong(inwardNo);
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public String getCoreHd() {
		return coreHd;
	}
	public void setCoreHd(String coreHd) {
		this.coreHd = coreHd;
	}
	public String getSurfaceHd() {
		return surfaceHd;
	}
	public void setSurfaceHd(String surfaceHd) {
		this.surfaceHd = surfaceHd;
	}
	public String getCaseDepth() {
		return caseDepth;
	}
	public void setCaseDepth(String caseDepth) {
		this.caseDepth = caseDepth;
	}
	public String getCrack() {
		return crack;
	}
	public void setCrack(String crack) {
		this.crack = crack;
	}
	public String getMicro() {
		return micro;
	}
	public void setMicro(String micro) {
		this.micro = micro;
	}
	public String getDistortation() {
		return distortation;
	}
	public void setDistortation(String distortation) {
		this.distortation = distortation;
	}
	public String getSf() {
		return sf;
	}
	public void setSf(String sf) {
		this.sf = sf;
	}
	public String getWtt() {
		return wtt;
	}
	public void setWtt(String wtt) {
		this.wtt = wtt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLayerThickness() {
		return layerThickness;
	}
	public void setLayerThickness(String layerThickness) {
		this.layerThickness = layerThickness;
	}
	public String getApperance() {
		return apperance;
	}
	public void setApperance(String apperance) {
		this.apperance = apperance;
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
	public String getCreationDate() {
		return CommonUtils.formatDate(creationDate);
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	} 
	public String getPoDate() {
		return poDate;
	}
	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}
	
}
