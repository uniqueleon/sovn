package org.aztec.sovn.core.impl;

import java.util.List;

import org.aztec.sovn.core.BDIAgent;
import org.aztec.sovn.core.Belief;
import org.aztec.sovn.core.Desire;
import org.aztec.sovn.core.Intension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;


@Component("baseAgent")
public class BaseBDIAgent extends Agent implements BDIAgent {

	@Autowired
	private Belief belief;
	@Autowired
	private Desire desire;
	@Autowired
	private Intension intension;
	
	@Autowired
	private List<Behaviour> behaviours;

	@Override
	public Belief getBeliefs() {
		// TODO Auto-generated method stub
		return belief;
	}

	@Override
	public Desire getDesire() {
		// TODO Auto-generated method stub
		return desire;
	}

	@Override
	public Intension getIntension() {
		return intension;
	}

	@Override
	protected void setup() {
		for(Behaviour behaviour : behaviours){
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

	
}
