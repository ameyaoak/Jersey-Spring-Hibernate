package com.jersey.series.spring.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jersey.series.spring.hibernate.dao.service.InvoicedDAO;
import com.jersey.series.spring.hibernate.model.Invoiced;

@Repository("invoicedDAO")
@Transactional
public class InvoicedDAOImpl implements InvoicedDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<Invoiced> getInvoiceListByInwardNo(String inno) {
		List<Invoiced> invoiceToReturn = sessionFactory.getCurrentSession().createCriteria(Invoiced.class)
			    .add( Restrictions.like("inwardNo", inno)) 
			    .list();
        return invoiceToReturn; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoiced> getInvoiceListByDispatchId(String dispatchId) {
		List<Invoiced> invoiceToReturn = sessionFactory.getCurrentSession().createCriteria(Invoiced.class)
			    .add( Restrictions.like("dispatchId", dispatchId)) 
			    .list();
        return invoiceToReturn; 
	}

	@Override
	public Invoiced getInvoiceByInvoiceId(String invoiceNo) {
		return (Invoiced) sessionFactory.getCurrentSession().get(Invoiced.class, invoiceNo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoiced> getAllInvoices() {
		List<Invoiced> invoiceToReturn = sessionFactory.getCurrentSession().createCriteria(Invoiced.class).list();
        return invoiceToReturn; 
	}

	@Override
	public String saveInvoiceDeltails(Invoiced inv) {
		return sessionFactory.getCurrentSession().save(inv).toString();
	}

	@Override
	public String updateInvoice(Invoiced inv) {
		sessionFactory.getCurrentSession().update(inv);
		return inv.getInvoiceNo();
	}

	@Override
	public String removeInvoice(String invNo) {
		sessionFactory.getCurrentSession().delete(invNo); 
		return "success";
	}
 
	 
}