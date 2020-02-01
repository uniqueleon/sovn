package org.aztec.sovn.core.mas.impl;

import java.util.List;

import org.aztec.sovn.core.mas.Environment;
import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.KownledgeContainer;
import org.aztec.sovn.core.mas.KownledgeInterpreter;
import org.aztec.sovn.core.mas.Status;
import org.aztec.sovn.core.mas.ml.prolog.PrologEngine;
import org.aztec.sovn.core.mas.utils.AgentLogger;

import com.google.common.collect.Lists;

import alice.tuprolog.InvalidLibraryException;

public class LocalEnvironment implements Environment {

	private KownledgeContainer container ;
	private Status status ;
	private static LocalEnvironment instance = null;
	
	static {
		try {
			instance = new LocalEnvironment();
		} catch (Exception e) {
			AgentLogger.error(e);
		}
	}

	private LocalEnvironment() throws InvalidLibraryException {
		container = new PrologKownledgeContainer();
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
	public Status getStatus() {
		return status;
	}

	@Override
	public PrologEngine getProlog() {
		return container.getProlog();
	}

}
