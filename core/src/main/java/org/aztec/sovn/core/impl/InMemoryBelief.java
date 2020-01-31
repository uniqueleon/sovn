package org.aztec.sovn.core.impl;

import java.util.List;
import java.util.Map;

import org.aztec.sovn.core.Belief;
import org.aztec.sovn.core.Kownledge;
import org.aztec.sovn.core.Status;
import org.aztec.sovn.core.KonwledgeInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.api.client.util.Maps;
import com.google.common.collect.Lists;

@Component("InMemoryBelief")
public class InMemoryBelief implements Belief {
	
	protected Map<String,Kownledge> kownledges = Maps.newHashMap();
	@Autowired
	protected List<KonwledgeInterpreter> interpreters;
	@Autowired
	protected List<Status> status;
	
	

	public InMemoryBelief() {
		super();
	}

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
	public List<KonwledgeInterpreter> getInterpreters() {
		return interpreters;
	}

	@Override
	public List<Kownledge> getKownledges() {
		return Lists.newArrayList(kownledges.values());
	}

	@Override
	public List<Status> getStatus() {
		return status;
	}


}
