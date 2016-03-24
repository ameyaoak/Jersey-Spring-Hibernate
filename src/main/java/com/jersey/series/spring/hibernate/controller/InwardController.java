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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import com.jersey.series.spring.hibernate.model.Inward;
import com.jersey.series.spring.hibernate.service.InwardService;


@Controller
@Path("/inward")
public class InwardController {

	@Autowired
	InwardService inwardService;

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/inward/1
	@GET
	@Path("/{inwardId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Inward getInwardByPartyId(@PathParam("inwardId") String id) { 
		return inwardService.getInwardDetailsByInno(id);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/inward/partyId/eg
	@GET
	@Path("/partyId/{partyId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public List<Inward> getInwardByPartyName(@PathParam("partyId") String partyId) { 
		return inwardService.getInwardDetailsByPartyId(partyId);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/inward/inwards/all
	@GET
	@Path("/inwards/all") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public List<Inward> getAllInwards() {
		return inwardService.getAllInwards();
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/inward
	@POST
	//@Path("/saveParty") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String saveInward(Inward inward) { 
		inward.setCreationDate(new Date());
		return inwardService.saveInwardDeltails(inward);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/inward/1
	@PUT
	@Path("/{inwardId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Response updateInward(@PathParam("inwardId") String inwardId,Inward inward) { 
		//inward.setCreationDate(CommonUtils.newDateTime().toString()); 
		if(inwardService.updateInward(inwardId,inward)==null)
		{
			return Response.status(Status.BAD_REQUEST).entity(inward.getInwardNo()).build();
		}
		return Response.status(Status.OK).entity(inward.getInwardNo()).build();
	}


	@DELETE
	@Path("/{inwardId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String removeInwardsEntry(@PathParam("inwardId") String inwardId) { 
		return inwardService.removeInwardsEntry(inwardId);
	}
}

