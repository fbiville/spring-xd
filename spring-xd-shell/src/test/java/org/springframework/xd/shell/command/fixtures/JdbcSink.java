/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.xd.shell.command.fixtures;

import java.util.Properties;

import org.hsqldb.jdbc.JDBCDriver;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.xd.dirt.job.HSQLServerBean;


/**
 * 
 * @author Florent Biville
 */
public class JdbcSink extends AbstractModuleFixture implements Disposable {

	private int port = AvailableSocketPorts.nextAvailablePort();

	private JdbcTemplate jdbcTemplate;

	private HSQLServerBean hsqlServerBean;

	private SimpleDriverDataSource dataSource;

	private String jdbcUrl;


	public JdbcSink start() throws Exception {
		initDatasource();
		jdbcTemplate = new JdbcTemplate(dataSource);

		return this;
	}

	/**
	 * @return
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	protected String toDSL() {
		return String.format("jdbc --initializeDatabase=true --url=%s", jdbcUrl);
	}

	/**
	 * @param port
	 * @return
	 * @throws Exception
	 */
	private void initDatasource() throws Exception {
		Properties hsqlProps = new Properties();
		hsqlProps.setProperty("port", String.valueOf(port));

		hsqlServerBean = new HSQLServerBean();
		hsqlServerBean.setServerProperties(hsqlProps);
		hsqlServerBean.afterPropertiesSet();

		jdbcUrl = String.format("jdbc:hsqldb:hsql//localhost:%d/jdbcSink", port);

		dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(JDBCDriver.class);
		dataSource.setUrl(jdbcUrl);
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Auto-generated method stub");
	}

}
