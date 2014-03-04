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

package org.springframework.xd.mongodb;

import org.springframework.xd.module.options.spi.ModuleOption;


/**
 * HDFS Mongo DB options
 * 
 * @author Florent Biville
 */
public class HdfsMongoDbJobOptionsMetadata {

	private boolean restartable;

	private String[] resources;

	private String[] names;

	private String collectionName;

	private String databaseName;

	private String host;

	private int port;

	private String idField;


	public boolean isRestartable() {
		return restartable;
	}


	@ModuleOption("whether the job is restartable or not")
	public void setRestartable(boolean restartable) {
		this.restartable = restartable;
	}


	public String[] getResources() {
		return resources;
	}


	@ModuleOption("the set of resources to be read in chunk")
	public void setResources(String[] resources) {
		this.resources = resources;
	}


	public String[] getNames() {
		return names;
	}


	@ModuleOption("the set of delimiters of flat file lines")
	public void setNames(String[] names) {
		this.names = names;
	}


	public String getCollectionName() {
		return collectionName;
	}


	@ModuleOption("the Mongo DB collection name")
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}


	public String getDatabaseName() {
		return databaseName;
	}


	@ModuleOption("the Mongo DB database name")
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}


	public String getHost() {
		return host;
	}


	@ModuleOption("the Mongo DB host")
	public void setHost(String host) {
		this.host = host;
	}


	public int getPort() {
		return port;
	}


	@ModuleOption("the Mongo DB server port")
	public void setPort(int port) {
		this.port = port;
	}


	public String getIdField() {
		return idField;
	}


	@ModuleOption("the tuple field used as an Mongo DB _id")
	public void setIdField(String idField) {
		this.idField = idField;
	}


}
