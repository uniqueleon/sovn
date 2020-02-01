package org.aztec.sovn.core.mas.impl;

import java.util.List;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.BDIAgentMetaData;
import org.aztec.sovn.core.mas.Belief;
import org.aztec.sovn.core.mas.Desire;
import org.aztec.sovn.core.mas.DesireGenerator;
import org.aztec.sovn.core.mas.Status;
import org.springframework.beans.factory.annotation.Autowired;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import reactor.core.publisher.Flux;


public class BaseBDIAgent extends Agent implements BDIAgent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7935698971870336568L;

	private Belief belief;
	
	@Autowired
	private List<Behaviour> behaviours;
	
	private BDIAgentMetaData metaData;
	
	private Flux<Desire> desires;
	
	@Autowired
	private DesireGenerator generator;
	
	private List<Status> status;

	@Override
	public Belief getBeliefs() {
		// TODO Auto-generated method stub
		return belief;
	}


	@Override
	protected void setup() {
		for(Behaviour behaviour : behaviours){
			if(behaviour instanceof TickerBehaviour) {
				((TickerBehaviour) behaviour).reset(metaData.getRateOfReaction());
			}
			behaviour.setAgent(this);
			super.addBehaviour(behaviour);
		}
		desires = generator.generate(this);
		super.setup();
	}

	@Override
	protected void takeDown() {
		for(Behaviour behaviour : behaviours){
			super.removeBehaviour(behaviour);
		}
		super.takeDown();
	}

	public BaseBDIAgent(BDIAgentMetaData metaData) {
		super();
		this.metaData = metaData;
	}

	@Override
	public BDIAgentMetaData getMetaData() {
		return metaData;
	}


	@Override
	public void setBelief(Belief belief) {
		this.belief = belief;
	}


	@Override
	public void setDesire(Flux<Desire> desire) {
		// TODO Auto-generated method stub
		this.desires = desire;
	}

	@Override
	public Flux<Desire> getCurrentDesire() {
		return desires;
	}


	@Override
	public List<Status> getStatus() {
		return status;
	}
}
