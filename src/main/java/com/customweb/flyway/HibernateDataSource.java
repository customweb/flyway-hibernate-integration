package com.customweb.flyway;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.engine.spi.SessionFactoryImplementor;

public class HibernateDataSource implements DataSource{
	
	private SessionFactoryImplementor sessionFactory;
	
	
	public HibernateDataSource(SessionFactoryImplementor sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		throw new UnsupportedOperationException("getLogWriter");
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		throw new UnsupportedOperationException("setLogWriter");
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		throw new UnsupportedOperationException("setLoginTimeout");
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		throw new UnsupportedOperationException("getLoginTimeout");
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		throw new UnsupportedOperationException("unwrap");
	}

	@Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return DataSource.class.equals(iface);
    }

	@Override
	public Connection getConnection() throws SQLException {
		return this.sessionFactory.getJdbcServices().getConnectionProvider().getConnection();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return this.sessionFactory.getJdbcServices().getConnectionProvider().getConnection();
	}

}
