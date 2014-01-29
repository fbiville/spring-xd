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

package org.springframework.xd.shell.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.springframework.xd.shell.command.fixtures.HttpSource;
import org.springframework.xd.shell.command.fixtures.JdbcSink;


/**
 * 
 * @author Florent Biville
 */
public class JdbcModulesTests extends AbstractStreamIntegrationTest {

	@Test
	public void testJdbcSinkWith1InsertionAndDefaultConfiguration() throws Exception {
		System.out.println("totototo");
		JdbcSink jdbcSink = newJdbcSink().start();

		HttpSource httpSource = newHttpSource();


		String streamName = generateStreamName();
		stream().create(streamName, "%s | %s", httpSource, jdbcSink);
		httpSource.ensureReady().postData("Hi there!");

		String query = String.format("SELECT payload FROM %s", streamName);
		assertEquals(
				"Hi there!",
				jdbcSink.getJdbcTemplate().queryForObject(query, String.class));
	}

	// tests cases
	// 2 insertions with default config
	// insertion with custom table name
	// insertion with custom column name
	// insertion into 2 JDBC sinks

}
