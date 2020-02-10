package org.aztec.sovn.core.mas.impl;

import java.util.List;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.BDIAgentMetaData;
import org.aztec.sovn.core.mas.Belief;
import org.aztec.sovn.core.mas.Desire;
import org.aztec.sovn.core.mas.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import reactor.core.publisher.Flux;

@Component("baseBDIAgent")
@Scope("prototype")
public class BasicBDIAgent implements BDIAgent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7935698971870336568L;

	private Belief belief;
	
	private String name;
	
	private boolean alive = false;
	
	@Autowired
	private List<Behaviour> behaviours;
	
	private BDIAgentMetaData metaData;
	
	private Flux<Desire> desires;
	
	private Status status;

	@Override
	public Belief getBeliefs() {
		// TODO Auto-generated method stub
		return belief;
	}


	public BasicBDIAgent() {
		super();
	}
	


	public BasicBDIAgent(BDIAgentMetaData metaData) {
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
		this.desires = desire;
	}

	@Override
	public Flux<Desire> getCurrentDesire() {
		return desires;
	}


	@Override
	public Status getStatus() {
		return status;
	}


	@Override
	public List<Behaviour> getBahaviors() {
		return behaviours;
	}


	@Override
	public String getName() {
		return name;
	}


	@Override
	public boolean isAlive() {
		return alive;
	}


	@Override
	public void setAlive(boolean alive) {
		this.alive = alive;
	}


	@Override
	public void setName(String name) {
		this.name = name;
	}
}
