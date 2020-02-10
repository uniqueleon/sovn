package org.aztec.sovn.core.mas;

import org.aztec.framework.core.SpringApplicationContext;
import org.aztec.sovn.core.mas.utils.AgentLogger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;

import jade.Boot;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.AMSService;

/**
 * To integrate with spring framework.
 * @author uniqueleon
 *
 */
public class SpringFrameworkAgent extends Agent {

	public SpringFrameworkAgent() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -192478521548463068L;


	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkAgent.class, args);
		Boot.main(new String[] {"-agents", "game1w:" + SpringFrameworkAgent.class.getName()});
		Boot.main(new String[] {"-agents", "game2w:" + SpringFrameworkAgent.class.getName()});
		
	}
	
	BDIAgent innerAgent;

	@Override
	protected void setup() {
		
		addBehaviour(new OneShotBehaviour() {
			
			@Override
			public void action() {
				System.out.println("regist agent !behavior!");
				try {
					innerAgent = SpringApplicationContext.getBean(BDIAgent.class);
					innerAgent.setName(getName());
					for(Behaviour behaviour : innerAgent.getBahaviors()) {
						addBehaviour(behaviour);
					}
					System.out.println(innerAgent);
				} catch (Exception e) {
					AgentLogger.error(e.getMessage());
				}
			}
		});
		addBehaviour(new TickerBehaviour(this,1l) {
			
			@Override
			protected void onTick() {
				if(!innerAgent.isAlive()) {
					doDelete();
				}
			}
		});
		
		super.setup();
	}
	

	@Override
	protected void takeDown() {
		for(Behaviour behaviour : innerAgent.getBahaviors()){
			super.removeBehaviour(behaviour);
		}
		super.takeDown();
	}

}
