package com.jersey.series.spring.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jersey.series.spring.hibernate.dao.service.DispatchDAO;
import com.jersey.series.spring.hibernate.model.Dispatched;

@Repository("dispatchedDAO")
@Transactional
public class DispatchedDAOImpl implements DispatchDAO {

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
	public List<Dispatched> getDispatchListByInwardNo(String inno) {
		List<Dispatched> dispatchToReturn = sessionFactory.getCurrentSession().createCriteria(Dispatched.class)
			    .add( Restrictions.like("inwardNo", inno)) 
			    .list();
        return dispatchToReturn; 
	}  
 
	@Override
	public String update(Dispatched dispatch) {
		sessionFactory.getCurrentSession().update(dispatch);
		return dispatch.getInwardNo();
	}

	@Override
	public Dispatched getDispatchByDispatchId(String dispatchId) {
		return (Dispatched) sessionFactory.getCurrentSession().get(Dispatched.class, dispatchId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dispatched> getAllDispatches() {
		return sessionFactory.getCurrentSession().createCriteria(Dispatched.class).list();
	}

	@Override
	public String saveDispatch(Dispatched dispatch) {
		return sessionFactory.getCurrentSession().save(dispatch).toString();
	}

	@Override
	public String removeDispatch(Dispatched dispatch) {
		sessionFactory.getCurrentSession().delete(dispatch); 
		return dispatch.getDispatchId();
	}

	 
}