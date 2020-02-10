package org.aztec.sovn.core.mas.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomUtils;
import org.aztec.framework.core.SpringApplicationContext;
import org.aztec.sovn.core.mas.AgentConstant;
import org.aztec.sovn.core.mas.AgentType;
import org.aztec.sovn.core.mas.BDIAgentMetaData;
import org.aztec.sovn.core.mas.Status;
import org.aztec.sovn.core.mas.impl.status.HealthStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileBaseConfiguration {

	File baseDir = new File("mas/agent");
	

	public FileBaseConfiguration() {
		// TODO Auto-generated constructor stub
		if (!baseDir.exists()) {
			baseDir.mkdirs();
		}
	}

	@Bean
	public BDIAgentMetaData metaData() throws FileNotFoundException, IOException {
		if (baseDir.isDirectory()) {
			File initDir = new File(baseDir.getPath() + "/init");
			if (initDir.exists() && initDir.list() != null && initDir.list().length > 0) {

				String[] subFiles = initDir.list();
				int rand = RandomUtils.nextInt(0, subFiles.length);
				return readMetaDataFromProperties(new File(rand + ".ini"));
			}
		}
		return new BasicAgentMetaData(AgentConstant.DEFAULT_RATE_OF_REACTION, new HealthStatus(),
				new BasicAgentType(), AgentConstant.DEFAULT_SLEEP_INTERVAL);
	}
	
	public BDIAgentMetaData readMetaDataFromProperties(File targetFile) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(targetFile));
		long rateOfReaction = AgentConstant.DEFAULT_RATE_OF_REACTION;
		if(prop.containsKey("rateOfReaction")) {
			rateOfReaction = Long.parseLong(prop.getProperty("rateOfReaction"));
		}
		long sleepInterval = AgentConstant.DEFAULT_SLEEP_INTERVAL;
		if(prop.containsKey("sleepInterval")) {
			rateOfReaction = Long.parseLong(prop.getProperty("sleepInterval"));
		}
		Status status = new HealthStatus();
		if(prop.containsKey("statusClass") && !prop.getProperty("status").isEmpty()) {
			status = SpringApplicationContext.getBean(prop.getProperty("status"));
		}
		AgentType type = new BasicAgentType();
		if(prop.containsKey("agentType") && !prop.getProperty("agentType").isEmpty()) {
			status = SpringApplicationContext.getBean(prop.getProperty("agentType"));
		}
		return new BasicAgentMetaData(rateOfReaction, status, type, sleepInterval);
	}

}
