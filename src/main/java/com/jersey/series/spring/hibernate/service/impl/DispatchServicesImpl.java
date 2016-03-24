package com.jersey.series.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.series.spring.hibernate.dao.service.DispatchDAO;
import com.jersey.series.spring.hibernate.model.Dispatched;
import com.jersey.series.spring.hibernate.service.DispatchServices;

@Service
public class DispatchServicesImpl implements DispatchServices{
	
	@Autowired
	private DispatchDAO dispatchedDAO; 

	@Override
	public List<Dispatched> getDispatchListByInwardNo(String inno) { 
		return dispatchedDAO.getDispatchListByInwardNo(inno);
	} 
	
	@Override
	public String updateDispatch(Dispatched dispatch) {
		return dispatchedDAO.update(dispatch);
	}

	@Override
	public Dispatched getDispatchByDispatchId(String id) {
		return dispatchedDAO.getDispatchByDispatchId(id); 
	}

	@Override
	public List<Dispatched> getAllDispatches() { 
		return dispatchedDAO.getAllDispatches();
	}

	@Override
	public String saveDispatch(Dispatched dispatch) { 
		return dispatchedDAO.saveDispatch(dispatch);
	}

	@Override
	public String removeDispatch(Dispatched dispatch) {
		return dispatchedDAO.removeDispatch(dispatch);
	}
}
