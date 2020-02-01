package org.aztec.sovn.core.mas;

import java.util.List;

import org.aztec.sovn.core.mas.ml.prolog.PrologEngine;

public interface KownledgeContainer {

	public Kownledge getKownledgeByName(String name);
	public void setKownledge(String name,Kownledge konwledge);
	public List<Kownledge> getKownledges();
	public List<KownledgeInterpreter> getInterpreters();
	public PrologEngine getProlog();
}
