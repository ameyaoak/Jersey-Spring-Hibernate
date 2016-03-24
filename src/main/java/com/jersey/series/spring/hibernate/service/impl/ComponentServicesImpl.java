package com.jersey.series.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.series.spring.hibernate.dao.service.ComponentDAO;
import com.jersey.series.spring.hibernate.model.Component;
import com.jersey.series.spring.hibernate.service.ComponentService;

@Service
public class ComponentServicesImpl implements ComponentService{
	
	@Autowired
	private ComponentDAO componentDAO;
	 
	 
	@Override
	public List<Component> getComponentsByPartyId(String id) { 
	    	return componentDAO.getComponentsByPartyId(id);
	}

	@Override
	public String saveComponent(Component component) {
		return componentDAO.saveComponent(component);
	}

	@Override
	public String updateComponent(String componentId, Component component) {
		component.setComponentId(componentId);
		return componentDAO.updateComponent(component); 
	}

	@Override
	public Component getComponentsById(String componentId) {
		return componentDAO.getComponentsById(componentId);
	}

	@Override
	public String removeComponentById(String componentId) {
		return componentDAO.removeComponentById(componentDAO.getComponentsById(componentId));
	}

	@Override
	public List<Component> getAllComponents() { 
		return componentDAO.getAllComponents();
	}
}
