package org.aztec.sovn.core.mas;

import java.util.List;
import java.util.Map;

public interface KownledgeContainer {

	public Kownledge getKownledgeByName(String name);
	public void setKownledge(String name,Kownledge konwledge);
	public List<Kownledge> getKownledges();
	public List<KownledgeInterpreter> getInterpreters();
}
