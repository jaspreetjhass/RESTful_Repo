package utility;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConnectionFactory {

	@Autowired
	private BasicDataSource datasource;

	public void setDatasource(BasicDataSource datasource) {
		this.datasource = datasource;
	}

	public Connection getConnection() throws SQLException {

		return datasource.getConnection();
	}

}
