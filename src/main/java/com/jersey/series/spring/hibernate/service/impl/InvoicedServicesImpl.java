package com.jersey.series.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.series.spring.hibernate.dao.service.InvoicedDAO;
import com.jersey.series.spring.hibernate.model.Invoiced;
import com.jersey.series.spring.hibernate.service.InvoicedServices;

@Service
public class InvoicedServicesImpl implements InvoicedServices{
	
	@Autowired
	private InvoicedDAO invoicedDAO;

	@Override
	public Invoiced getInvoiceByInvoiceId(String id) { 
		return invoicedDAO.getInvoiceByInvoiceId(id);
	}

	@Override
	public List<Invoiced> getAllInvoices() { 
		return invoicedDAO.getAllInvoices();
	}

	@Override
	public String saveInvoiceDeltails(Invoiced invoice) {
		return invoicedDAO.saveInvoiceDeltails(invoice);
	}

	@Override
	public String updateInvoice(String invoiceId, Invoiced invoice) {
		return invoicedDAO.updateInvoice(invoice);
	}

	@Override
	public String removeInvoice(String invoiceId) {
		return invoicedDAO.removeInvoice(invoiceId);
	} 

	 
 

}
