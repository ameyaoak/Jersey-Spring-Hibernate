package com.jersey.series.spring.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jersey.series.spring.hibernate.dao.service.InwardDAO;
import com.jersey.series.spring.hibernate.model.Inward;
import com.jersey.series.spring.hibernate.model.Party;

@Repository("inwardDAO")
@Transactional
public class InwardDAOImpl implements InwardDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	 
	@Override
	public String removeInwardsEntry(Inward inward) { 
		 sessionFactory.getCurrentSession().delete(inward);
		return inward.getInwardNo();
	}

	 
	@SuppressWarnings("unchecked")
	@Override
	public List<Inward> getInwardDetailsByPartyId(String partyId) {
		List<Inward> inwardsToReturn = sessionFactory.getCurrentSession().createCriteria(Inward.class)
			    .add( Restrictions.like("partyId", partyId) ) 
			    .list();
        return inwardsToReturn; 
	}

	@Override
	public Inward getInwardDetailsByInno(String inno) {
		return (Inward) sessionFactory.getCurrentSession().get(Inward.class, Long.parseLong(inno));
	}

	@Override
	public String saveInwardDeltails(Inward inward) {
		return sessionFactory.getCurrentSession().save(inward).toString();  
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inward> getAllInwards() {
		List<Inward> lstInward = sessionFactory.getCurrentSession().createCriteria(Inward.class)
				.add( Restrictions.ne("qtyKgs", new Double(0) ) )
				.add( Restrictions.ne("qtyNos", new Double(0) ) )
				.list();
		return lstInward;   
	}

	@Override
	public String updateInward(Inward inward) { 
		sessionFactory.getCurrentSession().update(inward);
		return inward.getInwardNo(); 
	}

	 
}