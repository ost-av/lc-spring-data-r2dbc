package net.lecousin.reactive.data.relational.postgres.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import net.lecousin.reactive.data.relational.test.multipleconnections.TestMultipleDatabaseConnections;

@ContextConfiguration(classes = TestMultipleConnections.PgDbUrls.class)
public class TestMultipleConnections extends TestMultipleDatabaseConnections {

	@Configuration
	public static class PgDbUrls implements DbUrls {
		@Override
		@Bean
		@Qualifier("db1Url")
		public String getFirstDbConnectionUrl() {
			return "r2dbc:pool:postgresql://postgres@localhost:" + PostgresTestConfiguration.epg.getPort() + "/first";
		}
		
		@Override
		@Bean
		@Qualifier("db2Url")
		public String getSecondDbConnectionUrl() {
			return "r2dbc:pool:postgresql://postgres@localhost:" + PostgresTestConfiguration.epg.getPort() + "/second";
		}
	}

}
