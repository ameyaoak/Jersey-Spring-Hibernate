package com.jersey.series.spring.hibernate.controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import com.jersey.series.spring.hibernate.model.Dispatched;
import com.jersey.series.spring.hibernate.service.DispatchServices;


@Controller
@Path("/dispatch")
public class DispatchController {

	@Autowired
	DispatchServices dispatchServices;

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/dispatch/1
	@GET
	@Path("/{dispatchId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Dispatched getDispatchByDispatchId(@PathParam("dispatchId") String id) { 
		return dispatchServices.getDispatchByDispatchId(id);
	}
 

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/dispatch/dispatches/all
	@GET
	@Path("/dispatches/all") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public List<Dispatched> getAllDispatches() {
		return dispatchServices.getAllDispatches();
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/dispatch
	@POST
	//@Path("/saveParty") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String saveDispatch(Dispatched dispatch) { 
		dispatch.setCreationDate(new Date());
		return dispatchServices.saveDispatch(dispatch);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/dispatch/1
	@PUT
	@Path("/{dispatchId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE) 
	@Consumes(MediaType.APPLICATION_JSON_VALUE) 
	public String updateInvoice(@PathParam("dispatchId") String dispatchId,Dispatched dispatch) {  
		return dispatchServices.updateDispatch(dispatch);
	}


	@DELETE
	@Path("/{dispatchId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String removeInvoice(@PathParam("dispatchId") String dispatchId) { 
		Dispatched dispatch = dispatchServices.getDispatchByDispatchId(dispatchId);
		return dispatchServices.removeDispatch(dispatch);
	}
}

