package org.aztec.sovn.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgentLogger {
	
	private static Logger LOG = LoggerFactory.getLogger(AgentLogger.class);

	public AgentLogger() {
		// TODO Auto-generated constructor stub
	}

	public static void info(String msg) {
		LOG.info(msg);
	}
	
	public static void warn(String msg) {
		LOG.warn(msg);
	}
	
	public static void error(String msg) {
		LOG.error(msg);
	}
	
	public static void error(Throwable t) {
		LOG.error(t.getMessage(),t);
	}
}
