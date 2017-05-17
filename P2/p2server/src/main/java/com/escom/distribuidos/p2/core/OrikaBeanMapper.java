package com.escom.distribuidos.p2.core;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.escom.distribuidos.p2.core.mappers.AlumnoToAlumnoDtoMapper;
import com.escom.distribuidos.p2.core.mappers.CarreraDtoToCarreraMapper;
import com.escom.distribuidos.p2.core.mappers.ExamenToExamenDtoMapper;
import com.escom.distribuidos.p2.core.mappers.MateriaToMateriaDtoMapper;
import com.escom.distribuidos.p2.core.mappers.PreguntaToPreguntaDtoMapper;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class OrikaBeanMapper extends ConfigurableMapper implements ApplicationContextAware {

	private MapperFactory factory;

	@Override
	protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
		// customize the factoryBuilder as needed
		// factoryBuilder.compilerStrategy(new CodeGenerationStrategy());
		// factoryBuilder.unenhanceStrategy(new HibernateUnenhanceStrategy());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(final MapperFactory factory) {
		this.factory = factory;
		this.factory.registerMapper(new AlumnoToAlumnoDtoMapper());
		this.factory.registerMapper(new CarreraDtoToCarreraMapper());
		this.factory.registerMapper(new ExamenToExamenDtoMapper());
		this.factory.registerMapper(new MateriaToMateriaDtoMapper());
		this.factory.registerMapper(new PreguntaToPreguntaDtoMapper());

		// customize the factory as needed
	}

	/**
	 * {@inheritDoc}
	 */
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		addAllSpringBeans(applicationContext);
	}

	/**
	 * Adds all managed beans of type {@link Mapper} or {@link Converter} to the
	 * parent {@link MapperFactory}.
	 *
	 * @param applicationContext
	 *            The application context to look for managed beans in.
	 */
	private void addAllSpringBeans(final ApplicationContext applicationContext) {
		final Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);
		for (final Converter converter : converters.values()) {
			addConverter(converter);
		}

		final Map<String, CustomMapper> mappers = applicationContext.getBeansOfType(CustomMapper.class);
		for (final Mapper mapper : mappers.values()) {
			addMapper(mapper);
		}
	}

	/**
	 * Add a {@link Converter}.
	 *
	 * @param converter
	 *            The converter.
	 */
	public void addConverter(final Converter<?, ?> converter) {
		factory.getConverterFactory().registerConverter(converter);
	}

	/**
	 * Add a {@link Mapper}.
	 *
	 * @param mapper
	 *            The mapper.
	 */
	public void addMapper(final Mapper<?, ?> mapper) {
		// factory.classMap(mapper.getAType(),
		// mapper.getBType()).byDefault().customize((Mapper) mapper).register();
	}
}