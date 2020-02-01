package org.aztec.sovn.core.mas.impl;

import java.util.List;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Belief;
import org.aztec.sovn.core.mas.Environment;
import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.KownledgeContainer;
import org.aztec.sovn.core.mas.KownledgeInterpreter;

public class InMemoryBelief extends SelfAwareObject implements Belief {
	
	private KownledgeContainer container = new BasicKownledgeContainer();
	private Environment env;
	
	public InMemoryBelief(BDIAgent self,Environment evn) {
		super(self);
		this.env = env;
	}
	
	@Override
	public Environment getEnvironment() {
		return env;
	}

	@Override
	public Kownledge getKownledgeByName(String name) {
		return container.getKownledgeByName(name);
	}

	@Override
	public void setKownledge(String name, Kownledge konwledge) {
		container.setKownledge(name, konwledge);
	}

	@Override
	public List<Kownledge> getKownledges() {
		return container.getKownledges();
	}

	@Override
	public List<KownledgeInterpreter> getInterpreters() {
		return container.getInterpreters();
	}

	@Override
	public void setEnvironment(Environment env) {
		this.env = env;
	}



}
