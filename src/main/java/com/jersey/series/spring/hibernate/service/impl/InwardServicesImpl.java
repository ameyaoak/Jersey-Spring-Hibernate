package com.jersey.series.spring.hibernate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.series.spring.hibernate.dao.service.DispatchDAO;
import com.jersey.series.spring.hibernate.dao.service.InwardDAO;
import com.jersey.series.spring.hibernate.model.Dispatched;
import com.jersey.series.spring.hibernate.model.Inward;
import com.jersey.series.spring.hibernate.service.InwardService;

@Service
public class InwardServicesImpl implements InwardService{

	@Autowired
	private InwardDAO inwardDAO; 

	@Autowired
	private DispatchDAO dispatchDAO;

	@Override
	public List<Inward> getInwardDetailsByPartyId(String partyId) {
		return inwardDAO.getInwardDetailsByPartyId(partyId);
	}

	@Override
	public Inward getInwardDetailsByInno(String inno) {
		return inwardDAO.getInwardDetailsByInno(inno);
	}

	@Override
	public String saveInwardDeltails(Inward inward) {
		return inwardDAO.saveInwardDeltails(inward);
	}

	@Override
	public String removeInwardsEntry(String inwardNo) {
		return inwardDAO.removeInwardsEntry(inwardDAO.getInwardDetailsByInno(inwardNo));
	}

	@Override
	public List<Inward> getAllInwards() {
		return inwardDAO.getAllInwards(); 
	}

	@Override
	public String updateInward(Inward inward) {
		Inward originalInward = getInwardDetailsByInno(inward.getInwardNo());
		if(isQtyValid(inward, originalInward)){
			Double dispatchedQtyKg = inward.getQtyKgs();
			Double dispatchedQtyNos = inward.getQtyNos(); 
			if(dispatchedQtyKg.isNaN() && dispatchedQtyNos.isNaN())
			inward.setQtyKgs(originalInward.getQtyKgs()-dispatchedQtyKg);
			inward.setQtyNos(originalInward.getQtyNos()-dispatchedQtyNos);
			inward.setInwardNo(inward.getInwardNo());   
			dispatchDAO.saveDispatch(dispatchFactory(originalInward, dispatchedQtyKg, dispatchedQtyNos));
			return inwardDAO.updateInward(inward); 
		}

		return null;
	}

	private boolean isQtyValid(Inward inward, Inward originalInward) {
		boolean cond1 = inward.getQtyKgs() >= 0.0 && inward.getQtyNos() >= 0.0;
		boolean cond2 = inward.getQtyKgs() <= originalInward.getQtyKgs() && inward.getQtyNos() <= originalInward.getQtyNos();  
		return cond1&&cond2;
	}

	private Dispatched dispatchFactory(Inward inward,Double dispatchedQtyKg, Double dispatchedQtyNos) {
		Dispatched dispatch = new Dispatched();
		dispatch.setCreationDate(new Date());
		dispatch.setInwardNo(inward.getInwardNo());
		dispatch.setQtyKgs(dispatchedQtyKg);
		dispatch.setQtyNos(dispatchedQtyNos);
		dispatch.setRateKg(inward.getRateKg()); 
		dispatch.setRateNos(inward.getRateNos());
		dispatch.setParty(inward.getParty());
		dispatch.setComponent(inward.getComponent());
		dispatch.setMaterial(inward.getMaterial());
		Double total = dispatchedQtyKg*inward.getRateKg() + dispatchedQtyNos*inward.getRateNos();
		dispatch.setTotal(total);
		return dispatch;
	}

}
