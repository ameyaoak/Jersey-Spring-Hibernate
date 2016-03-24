package com.jersey.series.spring.hibernate.service;

import java.util.List;

import com.jersey.series.spring.hibernate.model.Invoiced;

public interface InvoicedServices {

	Invoiced getInvoiceByInvoiceId(String id); 

	List<Invoiced> getAllInvoices();

	String saveInvoiceDeltails(Invoiced invoice);

	String updateInvoice(String invoiceId, Invoiced invoice);

	String removeInvoice(String invoiceId); 
}
