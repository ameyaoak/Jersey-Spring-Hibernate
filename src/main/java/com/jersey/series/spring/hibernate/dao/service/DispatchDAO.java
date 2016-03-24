package com.jersey.series.spring.hibernate.dao.service;

import java.util.List;

import com.jersey.series.spring.hibernate.model.Dispatched;

public interface DispatchDAO {

	List<Dispatched> getDispatchListByInwardNo(String inno);

	String update(Dispatched dispatch);

	Dispatched getDispatchByDispatchId(String id);

	List<Dispatched> getAllDispatches();

	String saveDispatch(Dispatched dispatch); 

	String removeDispatch(Dispatched dispatch);
 

}
