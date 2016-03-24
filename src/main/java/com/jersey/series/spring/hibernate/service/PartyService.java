package com.jersey.series.spring.hibernate.service;

import java.util.List;

import com.jersey.series.spring.hibernate.model.Party;

public interface PartyService {

	// Basic CRUD operations for Book Service

	 
	public String removePartyByPartyId(String partyId);

	public Party getPartyByPartyName(String partyId, String partyName);
 

	public List<Party> getAllParties();

	public String saveParty(Party partyInput);

	public String updateParty(String partyId, Party partyInput);

	public Party getPartyByPartyId(String partyId, String partyName);

	 
 
}