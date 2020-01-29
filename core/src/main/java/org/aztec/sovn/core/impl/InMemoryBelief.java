package org.aztec.sovn.core.impl;

import java.util.List;
import java.util.Map;

import org.aztec.sovn.core.Belief;
import org.aztec.sovn.core.Kownledge;
import org.aztec.sovn.core.KownledgeOfMySelf;
import org.springframework.stereotype.Component;

@Component("InMemoryBelief")
public class InMemoryBelief implements Belief {

	@Override
	public Map<String, Kownledge> getKownledge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kownledge getKownledgeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setKownledge(String name, Kownledge konwledge) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<KownledgeOfMySelf> getKonwledgeOfMySelf() {
		// TODO Auto-generated method stub
		return null;
	}

}
