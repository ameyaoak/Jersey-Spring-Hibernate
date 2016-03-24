package com.jersey.series.spring.hibernate.service;

import java.util.List;

import javax.ws.rs.core.Response;

import com.jersey.series.spring.hibernate.model.Inward;

public interface InwardService {

	List<Inward> getInwardDetailsByPartyId(String partyId); 
	String saveInwardDeltails(Inward inward);
	String removeInwardsEntry(String inwardNo);
	Inward getInwardDetailsByInno(String inno);
	List<Inward> getAllInwards();
	String updateInward(Inward inward);

}
