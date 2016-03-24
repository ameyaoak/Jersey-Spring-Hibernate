package com.jersey.series.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.series.spring.hibernate.dao.service.PartyDAO;
import com.jersey.series.spring.hibernate.model.Party;
import com.jersey.series.spring.hibernate.service.PartyService;

@Service
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyDAO partyDAO; 


	@Override
	public String removePartyByPartyId(String partyId) { 
		return partyDAO.removePartyInfo(partyDAO.getParty(partyId, null));
	}

	@Override
	public Party getPartyByPartyName(String partyId, String partyName) {
		return partyDAO.getParty(partyId, partyName);
	}

	@Override
	public Party getPartyByPartyId(String partyId, String partyName) { 
		return partyDAO.getParty(partyId, partyName);
	}

	@Override
	public List<Party> getAllParties() { 
		return partyDAO.getAllParties();
	}

	@Override
	public String saveParty(Party partyInput) {
		return partyDAO.insertParty(partyInput); 
	} 

	@Override
	public String updateParty(String partyId, Party partyInput) { 
		partyInput.setPartyId(partyId); 
		return partyDAO.updateParty(partyInput); 
	}




}