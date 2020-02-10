package org.aztec.sovn.game;

import org.aztec.framework.core.SpringApplicationContext;
import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.SpringFrameworkAgent;
import org.aztec.sovn.core.mas.impl.BasicBDIAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import jade.Boot;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.AMSService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;

@SpringBootApplication
@ComponentScan(basePackages = {"org.aztec.framework.*",
		"org.aztec.sovn.*"})
public class GameStarter implements ApplicationRunner{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -192478521548463068L;
	public static String[] applicationArgs;

	public GameStarter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		applicationArgs = args; 
		
		
		SpringApplication.run(GameStarter.class, args);
		Boot.main(new String[] {"-agents", "game1w:" + SpringFrameworkAgent.class.getName()});
		Boot.main(new String[] {"-agents", "game2w:" + SpringFrameworkAgent.class.getName()});
	}
	
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	}
}
