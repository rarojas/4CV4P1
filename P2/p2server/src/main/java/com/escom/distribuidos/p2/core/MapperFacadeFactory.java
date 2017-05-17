package com.escom.distribuidos.p2.core;

import org.springframework.beans.factory.FactoryBean;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

//@Component
public class MapperFacadeFactory implements FactoryBean<MapperFacade> {
	public MapperFacade getObject() throws Exception {
		return new DefaultMapperFactory.Builder().build().getMapperFacade();
	}

	public Class<?> getObjectType() {
		return MapperFacade.class;
	}

	public boolean isSingleton() {
		return true;
	}
}