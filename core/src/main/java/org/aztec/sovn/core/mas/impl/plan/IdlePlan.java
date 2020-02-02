package org.aztec.sovn.core.mas.impl.plan;

import org.aztec.sovn.core.mas.BDIAgent;
import org.springframework.stereotype.Component;

@Component
public class IdlePlan extends BasicPlan {

	public IdlePlan() {
	}

	@Override
	protected void doRun(BDIAgent agent) {
	}

	@Override
	protected boolean shouldBeContinue() {
		return false;
	}

}
