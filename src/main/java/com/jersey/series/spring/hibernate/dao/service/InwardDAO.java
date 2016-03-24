package com.jersey.series.spring.hibernate.dao.service;

import java.util.List;

import com.jersey.series.spring.hibernate.model.Inward;

public interface InwardDAO {

	public List<Inward> getInwardDetailsByPartyId(String partyId);   
	public String saveInwardDeltails(Inward inward); 
	public Inward getInwardDetailsByInno(String inno);
	String removeInwardsEntry(Inward inward);
	public List<Inward> getAllInwards();
	public String updateInward(Inward inward);

}
