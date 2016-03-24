package com.jersey.series.spring.hibernate.service;

import java.util.List;

import com.jersey.series.spring.hibernate.model.Component;

public interface ComponentService {
 

	List<Component> getComponentsByPartyId(String id);

	String saveComponent(Component component);

	String updateComponent(String componentId, Component component);

	Component getComponentsById(String componentId);

	String removeComponentById(String componentId);

	List<Component> getAllComponents();

}
