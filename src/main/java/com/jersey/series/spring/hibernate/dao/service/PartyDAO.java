package com.jersey.series.spring.hibernate.dao.service;

import java.util.List;

import com.jersey.series.spring.hibernate.model.Party;

public interface PartyDAO {

	public String insertParty(Party p);
	public String updateParty(Party updateParty);
	public String removePartyInfo(Party removeParty);
	public List<Party> getAllParties();
	public Party getParty(String partyId, String PartyName);
}