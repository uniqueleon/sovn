package org.aztec.sovn.core.impl;

import java.util.List;

import org.aztec.sovn.core.BDIAgent;
import org.aztec.sovn.core.BDIAgentMetaData;
import org.aztec.sovn.core.Belief;
import org.aztec.sovn.core.Kownledge;
import org.springframework.beans.factory.annotation.Autowired;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import reactor.core.publisher.Flux;


public class BaseBDIAgent extends Agent implements BDIAgent {

	private Belief belief;
	
	@Autowired
	private List<Behaviour> behaviours;
	
	private BDIAgentMetaData metaData;
	

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
		super.setup();
	}

	@Override
	protected void takeDown() {
		for(Behaviour behaviour : behaviours){
			super.removeBehaviour(behaviour);
		}
		super.takeDown();
	}

	public BaseBDIAgent(BDIAgentMetaData metaData,
			Belief belief) {
		super();
		this.metaData = metaData;
		this.belief = belief;
	}

	@Override
	public BDIAgentMetaData getMetaData() {
		return metaData;
	}


	@Override
	public void setBelief(Belief belief) {
		this.belief = belief;
	}


}
