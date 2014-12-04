package com.customweb.flyway;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.flywaydb.core.Flyway;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class FlywayIntegrator implements Integrator {

	public static final Logger logger = Logger.getLogger(FlywayIntegrator.class.getName());
	
	

	@Override
	public void integrate(Configuration configuration, SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {

		logger.log(Level.INFO, "Starting Flyway Migration");

		final Flyway flyway = new Flyway();
		flyway.setDataSource(new HibernateDataSource(sessionFactory));
		flyway.setValidateOnMigrate(false);
		flyway.migrate();
		
		logger.log(Level.INFO, "Finished Flyway Migration");
	}

	@Override
	public void integrate(MetadataImplementor metadata, SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {
	}

	@Override
	public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
	}

}
