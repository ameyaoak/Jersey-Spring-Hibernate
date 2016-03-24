package com.jersey.series.spring.hibernate.dao.service;

import java.util.List;

import com.jersey.series.spring.hibernate.model.Component;

public interface ComponentDAO { 
	
	 
	public List<Component> getComponentsByPartyId(String id);

	public String saveComponent(Component component);

	public String updateComponent(Component component);

	public Component getComponentsById(String componentId);
 
	public List<Component> getAllComponents();

	String removeComponentById(Component component);
}