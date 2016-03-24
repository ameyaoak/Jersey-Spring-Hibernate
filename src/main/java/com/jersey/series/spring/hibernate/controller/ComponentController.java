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

import com.jersey.series.spring.hibernate.model.Component;
import com.jersey.series.spring.hibernate.service.ComponentService;


@Controller
@Path("/component")
public class ComponentController {

	@Autowired
	ComponentService componentService;

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/component/partyId/11
	@GET
	@Path("/partyId/{partyId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public List<Component> getComponentsByPartyId(@PathParam("partyId") String id) { 
		return componentService.getComponentsByPartyId(id);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/component/name
	@GET
	@Path("/{componentId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Component getComponentsById(@PathParam("componentId") String componentId) { 
		return componentService.getComponentsById(componentId);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/component/components/all
	@GET
	@Path("components/all") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public List<Component> getAllComponents() {
		return componentService.getAllComponents();
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/component/
	@POST
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String saveComponent(Component component) { 
		return componentService.saveComponent(component);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/component/
	@PUT
	@Path("{componentId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String updateComponent(@PathParam("componentId") String componentId,Component component) { 
		return componentService.updateComponent(componentId,component);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/component/
	@DELETE
	@Path("{componentId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String removeComponentById(@PathParam("componentId") String componentId) { 
		return componentService.removeComponentById(componentId);
	}
}

