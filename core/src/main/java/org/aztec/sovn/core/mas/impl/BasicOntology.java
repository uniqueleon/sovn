package org.aztec.sovn.core.mas.impl;

import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.Ontology;
import org.aztec.sovn.core.mas.Term;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("baseOntology")
@Scope("prototype")
public class BasicOntology implements Ontology {

	public BasicOntology() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Term translate(Kownledge kownledge) {
		// TODO Auto-generated method stub
		return null;
	}

}
