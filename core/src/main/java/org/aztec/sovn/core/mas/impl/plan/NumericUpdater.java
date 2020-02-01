package org.aztec.sovn.core.mas.impl.plan;

import java.util.Set;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Plan;

public class NumericUpdater extends BasicPlan {

	public NumericUpdater(Set<String> attributeNames,
			Set<Number> numbers) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doRun(BDIAgent agent) {
		agent.getBeliefs().getStatus();
	}

	@Override
	protected boolean shouldBeContinue() {
		return false;
	}

}
