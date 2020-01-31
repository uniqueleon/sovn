package org.aztec.sovn.core.impl;

import org.aztec.sovn.core.Kownledge;
import org.aztec.sovn.core.ml.prolog.PrologEngine;
import org.aztec.sovn.core.utils.AgentLogger;

import alice.tuprolog.InvalidLibraryException;
import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;

public class PrologBelief extends InMemoryBelief {
	
	PrologEngine prolog;

	public PrologBelief() throws InvalidLibraryException {
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
