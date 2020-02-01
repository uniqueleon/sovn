package org.aztec.sovn.core.mas.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.KownledgeContainer;
import org.aztec.sovn.core.mas.KownledgeIntrospector;
import org.aztec.sovn.core.mas.ml.prolog.PrologEngine;
import org.aztec.sovn.core.mas.utils.AgentLogger;

import com.google.api.client.util.Maps;
import com.google.common.collect.Lists;

import alice.tuprolog.InvalidLibraryException;

public class PrologKownledgeContainer implements KownledgeContainer {
	
	protected Map<String,Kownledge> kownledges = Maps.newHashMap();
	protected List<KownledgeIntrospector> interpreters = Lists.newArrayList();
	File localKownledgeFile;
	PrologEngine prolog;

	public PrologKownledgeContainer() throws InvalidLibraryException {
		prolog = new PrologEngine();
	}

	@Override
	public Kownledge getKownledgeByName(String name) {
		return kownledges.get(name);
	}

	@Override
	public void setKownledge(String name, Kownledge kownledge) {
		try {
			prolog.addTheory(kownledge.name() + ".");
		} catch (Exception e) {
			AgentLogger.error(e);
		}
		kownledges.put(name, kownledge);
	}

	@Override
	public List<KownledgeIntrospector> getInterpreters() {
		return interpreters;
	}

	@Override
	public List<Kownledge> getKownledges() {
		return Lists.newArrayList(kownledges.values());
	}

	@Override
	public PrologEngine getProlog() {
		return prolog;
	}

}
