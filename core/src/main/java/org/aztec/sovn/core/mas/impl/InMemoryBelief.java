package org.aztec.sovn.core.mas.impl;

import java.util.List;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Belief;
import org.aztec.sovn.core.mas.Environment;
import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.KownledgeContainer;
import org.aztec.sovn.core.mas.KownledgeIntrospector;
import org.aztec.sovn.core.mas.ml.prolog.PrologEngine;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import alice.tuprolog.InvalidLibraryException;

@Component("inMemoryBelief")
@Scope("prototype")
public class InMemoryBelief extends SelfAwareObject implements Belief {
	
	private KownledgeContainer container;
	private Environment env;
	
	public InMemoryBelief(BDIAgent self,Environment evn) throws InvalidLibraryException {
		super(self);
		this.env = env;
		container = new PrologKownledgeContainer();
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
	public List<KownledgeIntrospector> getInterpreters() {
		return container.getInterpreters();
	}

	@Override
	public void setEnvironment(Environment env) {
		this.env = env;
	}

	@Override
	public PrologEngine getProlog() {
		return container.getProlog();
	}

	@Override
	public KownledgeContainer getKownledgeContainer() {
		return container;
	}



}
