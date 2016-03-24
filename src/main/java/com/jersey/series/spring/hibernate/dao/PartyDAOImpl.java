package com.jersey.series.spring.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jersey.series.spring.hibernate.dao.service.PartyDAO;
import com.jersey.series.spring.hibernate.model.Party;

@Repository("partyDAO")
@Transactional
public class PartyDAOImpl implements PartyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String insertParty(Party p) {
		
		return sessionFactory.getCurrentSession().save(p).toString();  
		 
	}

	@Override
	public Party getParty(String PartyId,String partyName) {
		
		 
        Party PartyToReturn=null; 
        if(partyName==null){  
        	PartyToReturn = (Party) sessionFactory.getCurrentSession().get(Party.class, Long.parseLong(PartyId));
        }
        else{
        	
        	PartyToReturn = (Party) this.sessionFactory.getCurrentSession().createCriteria(Party.class)
    			    .add( Restrictions.like("partyName", partyName) ) 
    			    .list();   
        }
        return PartyToReturn; 
	}

	@Override
	public String updateParty(Party updateParty) {
		sessionFactory.getCurrentSession().update(updateParty);
		return updateParty.getPartyId();
	}

	@Override
	public String removePartyInfo(Party removeParty) { 
		 sessionFactory.getCurrentSession().delete(removeParty);
		return removeParty.getPartyId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Party> getAllParties() { 
		List<Party> lstParties = sessionFactory.getCurrentSession().createCriteria(Party.class).list();
		return lstParties; 
	}

	 
}