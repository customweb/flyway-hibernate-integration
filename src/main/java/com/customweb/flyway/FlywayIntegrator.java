package com.customweb.flyway;

import java.sql.Driver;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import com.googlecode.flyway.core.Flyway;
import com.googlecode.flyway.core.util.jdbc.DriverDataSource;

public class FlywayIntegrator implements Integrator {

	public static final Logger logger = Logger.getLogger(FlywayIntegrator.class.getName());

	@Override
	public void integrate(Configuration configuration, SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {

		logger.log(Level.INFO, "Starting Flyway Migration");

		final Flyway flyway = new Flyway();
		
		String url = (String)sessionFactory.getProperties().get("hibernate.connection.url");
		String driverName = (String)sessionFactory.getProperties().get("hibernate.connection.driver_class");
		String password = (String)sessionFactory.getProperties().get("hibernate.connection.password");
		String username = (String)sessionFactory.getProperties().get("hibernate.connection.username");
		
//		DriverDataSource dataSource = new DriverDataSource(new Driver(), url, user, String password);

		
		
//	    Session session = sessionFactory.getJdbcServices().getConnectionProvider().getConnection().get
	    ConnectionInfo connectionInfo = new ConnectionInfo();
//	    session.doWork(connectionInfo);
		
		flyway.setDataSource(new HibernateDataSource(sessionFactory));
		
		flyway.init();
		
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
