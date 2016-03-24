package com.jersey.series.spring.hibernate.service;

import java.util.List;

import com.jersey.series.spring.hibernate.model.Dispatched;
import com.jersey.series.spring.hibernate.model.Inward_Dispatched;

public interface DispatchServices { 
	
	List<Dispatched> getDispatchListByInwardNo(String inno);
 
	String updateDispatch(Dispatched dispatch);

	Dispatched getDispatchByDispatchId(String id);

	List<Dispatched> getAllDispatches();

	String saveDispatch(Dispatched dispatch); 

	String removeDispatch(Dispatched dispatch); 
}
