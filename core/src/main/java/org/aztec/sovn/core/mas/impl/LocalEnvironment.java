package org.aztec.sovn.core.mas.impl;

import java.util.List;

import org.aztec.sovn.core.mas.Environment;
import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.KownledgeContainer;
import org.aztec.sovn.core.mas.KownledgeInterpreter;
import org.aztec.sovn.core.mas.Status;

import com.google.common.collect.Lists;

public class LocalEnvironment implements Environment {

	private KownledgeContainer container = new BasicKownledgeContainer();
	private List<Status> status = Lists.newArrayList();
	private static final LocalEnvironment instance = new LocalEnvironment();

	private LocalEnvironment() {
		// TODO Auto-generated constructor stub
	}
	
	public static Environment getInstance() {
		return instance;
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
	public List<Status> getStatus() {
		return status;
	}

}
