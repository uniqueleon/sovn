package org.aztec.sovn.core.mas.impl;

import java.util.List;
import java.util.Map;

import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.KownledgeContainer;
import org.aztec.sovn.core.mas.KownledgeInterpreter;

import com.google.api.client.util.Maps;
import com.google.common.collect.Lists;

public class BasicKownledgeContainer implements KownledgeContainer {
	
	protected Map<String,Kownledge> kownledges = Maps.newHashMap();
	protected List<KownledgeInterpreter> interpreters = Lists.newArrayList();

	public BasicKownledgeContainer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Kownledge getKownledgeByName(String name) {
		return kownledges.get(name);
	}

	@Override
	public void setKownledge(String name, Kownledge kownledge) {
		kownledges.put(name, kownledge);
	}

	@Override
	public List<KownledgeInterpreter> getInterpreters() {
		return interpreters;
	}

	@Override
	public List<Kownledge> getKownledges() {
		return Lists.newArrayList(kownledges.values());
	}

}
