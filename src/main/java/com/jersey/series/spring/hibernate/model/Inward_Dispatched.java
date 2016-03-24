package com.jersey.series.spring.hibernate.model;


public class Inward_Dispatched extends Dispatched{

	
	String party,component, material;

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
