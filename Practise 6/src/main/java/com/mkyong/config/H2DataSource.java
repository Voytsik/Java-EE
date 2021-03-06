package com.mkyong.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

@Profile("h2")
@Configuration
public class H2DataSource {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.H2).addScript("db/sql/create-db.sql").addScript("db/sql/insert-data.sql").build();
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server startDBManager() throws SQLException {
		return Server.createWebServer();
	}

}