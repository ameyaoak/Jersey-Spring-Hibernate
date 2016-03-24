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

import com.jersey.series.spring.hibernate.model.Invoiced;
import com.jersey.series.spring.hibernate.service.InvoicedServices;


@Controller
@Path("/invoice")
public class InvoiceController {

	@Autowired
	InvoicedServices invoicedServices;

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/invoice/1
	@GET
	@Path("/{invoiceId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Invoiced getInvoiceByInwardId(@PathParam("invoiceId") String id) { 
		return invoicedServices.getInvoiceByInvoiceId(id);
	}
 

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/invoice/invoices/all
	@GET
	@Path("/invoices/all") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public List<Invoiced> getAllInwards() {
		return invoicedServices.getAllInvoices();
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/invoice
	@POST
	//@Path("/saveParty") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String saveInvoice(Invoiced invoice) { 
		invoice.setCreationDate(new Date());
		return invoicedServices.saveInvoiceDeltails(invoice);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/invoice/1
	@PUT
	@Path("/{invoiceId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE) 
	@Consumes(MediaType.APPLICATION_JSON_VALUE) 
	public String updateInvoice(@PathParam("invoiceId") String invoiceId,Invoiced invoice) {  
		return invoicedServices.updateInvoice(invoiceId,invoice);
	}


	@DELETE
	@Path("/{invoiceId}") 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public String removeInvoice(@PathParam("invoiceId") String invoiceId) { 
		return invoicedServices.removeInvoice(invoiceId);
	}
}

