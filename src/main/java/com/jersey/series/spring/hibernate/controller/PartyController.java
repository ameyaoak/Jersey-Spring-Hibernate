package com.jersey.series.spring.hibernate.controller;

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

import com.jersey.series.spring.hibernate.model.Party;
import com.jersey.series.spring.hibernate.service.PartyService;


@Controller
@Path("/party")
public class PartyController {

	@Autowired
	PartyService partyServices;

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/party/1
	@GET
	@Path("/{partyId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Party getPartyByPartyId(@PathParam("partyId") String id) { 
		return partyServices.getPartyByPartyId(id,null);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/party/name/eg
	@GET
	@Path("/name/{partyName}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Party getPartyByPartyName(@PathParam("partyName") String partyName) { 
		return partyServices.getPartyByPartyName(null,partyName);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/party/parties/all
	@GET
	@Path("/parties/all") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public List<Party> getAllParties() {
		return partyServices.getAllParties();
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/party
	@POST
	//@Path("/saveParty") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String saveParty(Party partyInput) { 
		return partyServices.saveParty(partyInput);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/party/updateParty/1
	@PUT
	@Path("/{partyId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String updateParty(@PathParam("partyId") String partyId,Party partyInput) { 
		return partyServices.updateParty(partyId,partyInput);
	}


	@DELETE
	@Path("/{partyId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String removePartyByPartyId(@PathParam("partyId") String partyId) { 
		return partyServices.removePartyByPartyId(partyId);
	}
}

