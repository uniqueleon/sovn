package org.aztec.sovn.core.mas.impl;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Environment;
import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.ml.prolog.PrologEngine;
import org.aztec.sovn.core.mas.utils.AgentLogger;

import alice.tuprolog.InvalidLibraryException;

public class PrologBelief extends InMemoryBelief {
	
	PrologEngine prolog;

	public PrologBelief(BDIAgent self,Environment env) throws InvalidLibraryException {
		super(self,env);
		prolog = new PrologEngine();
	}

	@Override
	public void setKownledge(String name, Kownledge kownledge){
		try {
			prolog.addTheory(kownledge.name() + ".");
		} catch (Exception e) {
			AgentLogger.error(e);
		}
		super.setKownledge(name, kownledge);
	}

	public PrologEngine getProlog() {
		return prolog;
	}

	public void setProlog(PrologEngine prolog) {
		this.prolog = prolog;
	}

	
}
