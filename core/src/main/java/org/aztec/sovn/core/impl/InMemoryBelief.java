package org.aztec.sovn.core.impl;

import java.util.List;
import java.util.Map;

import org.aztec.sovn.core.Belief;
import org.aztec.sovn.core.Kownledge;
import org.aztec.sovn.core.MeaningInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.api.client.util.Maps;
import com.google.common.collect.Lists;

@Component("InMemoryBelief")
public class InMemoryBelief implements Belief {
	
	private Map<String,Kownledge> kownledges = Maps.newHashMap();
	@Autowired
	private List<MeaningInterpreter> interpreters;

	@Override
	public Map<String, Kownledge> getKownledge() {
		// TODO Auto-generated method stub
		return kownledges;
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
	public List<MeaningInterpreter> getInterpreters() {
		return interpreters;
	}

	@Override
	public List<Kownledge> getKownledges() {
		return Lists.newArrayList(kownledges.values());
	}


}
