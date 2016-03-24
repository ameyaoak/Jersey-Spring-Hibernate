package com.jersey.series.spring.hibernate.dao.service;

import java.util.List;

import com.jersey.series.spring.hibernate.model.Invoiced;

public interface InvoicedDAO {

	Invoiced getInvoiceByInvoiceId(String id);

	List<Invoiced> getAllInvoices(); 

	List<Invoiced> getInvoiceListByInwardNo(String inno);

	List<Invoiced> getInvoiceListByDispatchId(String dispatchId);

	String removeInvoice(String invNo);

	String updateInvoice(Invoiced inv);

	String saveInvoiceDeltails(Invoiced inv);
 
}
