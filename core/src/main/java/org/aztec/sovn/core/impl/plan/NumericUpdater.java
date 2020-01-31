package org.aztec.sovn.core.impl.plan;

import java.util.Set;

import org.aztec.sovn.core.BDIAgent;
import org.aztec.sovn.core.Plan;

public class NumericUpdater implements Plan {

	public NumericUpdater(Set<String> attributeNames,
			Set<Number> numbers) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(BDIAgent agent) {
		// TODO Auto-generated method stub
		agent.getBeliefs().getStatus();
	}


}
