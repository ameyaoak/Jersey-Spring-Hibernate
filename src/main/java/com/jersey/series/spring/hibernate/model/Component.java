package com.jersey.series.spring.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity  
@Table(name="component")
public class Component {

	String partyId, partyName, componentName, componentMaterial,
			componentPartNo, componentProcess, componentPoNo, componentPoDate,
			coreHd, surfaceHd, caseDepth, crack, micro, distortation, sf, wtt,
			layerThickness, apperance, version;

	@Id
	@SequenceGenerator(name="componentSeq", initialValue=1, allocationSize=100)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="componentSeq") 
	Long componentId;
	double rateKg,rateNos;
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getComponentMaterial() {
		return componentMaterial;
	}
	public void setComponentMaterial(String componentMaterial) {
		this.componentMaterial = componentMaterial;
	}
	public String getComponentPartNo() {
		return componentPartNo;
	}
	public void setComponentPartNo(String componentPartNo) {
		this.componentPartNo = componentPartNo;
	}
	public String getComponentProcess() {
		return componentProcess;
	}
	public void setComponentProcess(String componentProcess) {
		this.componentProcess = componentProcess;
	}
	public String getComponentPoNo() {
		return componentPoNo;
	}
	public void setComponentPoNo(String componentPoNo) {
		this.componentPoNo = componentPoNo;
	}
	public String getComponentPoDate() {
		return componentPoDate;
	}
	public void setComponentPoDate(String componentPoDate) {
		this.componentPoDate = componentPoDate;
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getComponentId() {
		return componentId.toString();
	}
	public void setComponentId(String componentId) {
		this.componentId = Long.parseLong(componentId);
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
}
