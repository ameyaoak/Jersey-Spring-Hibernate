package com.jersey.series.spring.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jersey.series.spring.hibernate.dao.service.ComponentDAO;
import com.jersey.series.spring.hibernate.model.Component;

@Repository("componentDAO")
@Transactional
public class ComponentDAOImpl implements ComponentDAO {

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
	public List<Component> getComponentsByPartyId(String id) {
		List<Component> lstComponents = this.sessionFactory.getCurrentSession().createCriteria(Component.class)
			    .add( Restrictions.like("partyId", id) ) 
			    .list();  
		return lstComponents;
	}

	@Override
	public String saveComponent(Component component) {
		return sessionFactory.getCurrentSession().save(component).toString();  
	}

	@Override
	public String updateComponent(Component component) {
		sessionFactory.getCurrentSession().update(component);
		return component.getPartyId();
	}

	@Override
	public Component getComponentsById(String componentId) { 
		return (Component) sessionFactory.getCurrentSession().get(Component.class, componentId);
	}

	@Override
	public String removeComponentById(Component component) {
		 sessionFactory.getCurrentSession().delete(component);
			return component.getComponentId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Component> getAllComponents() {
		List<Component> lstComponents = sessionFactory.getCurrentSession().createCriteria(Component.class).list();
		return lstComponents; 
	}

	 
}