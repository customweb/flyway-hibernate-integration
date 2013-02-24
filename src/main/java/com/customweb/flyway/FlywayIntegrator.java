package com.customweb.flyway;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import com.googlecode.flyway.core.Flyway;

public class FlywayIntegrator implements Integrator {

	public static final Logger logger = Logger.getLogger(FlywayIntegrator.class.getName());

	@Override
	public void integrate(Configuration configuration, SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {

		logger.log(Level.INFO, "Starting Flyway Migration");

		final Flyway flyway = new Flyway();
		// flyway.setDataSource(new DriverDataSource(new Driver(),
		// "jdbc:mysql://localhost:8889/testdb", "root", "root"));
		flyway.migrate();
		logger.log(Level.INFO, "Finished Flyway Migration");

	}

	@Override
	public void integrate(MetadataImplementor metadata, SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
		// TODO Auto-generated method stub

	}

}
