package org.aztec.sovn.core.mas.impl.term;

import org.aztec.sovn.core.mas.impl.plan.NumericUpdater;

public class NumericOptTerm extends InternalTerm {

	public NumericOptTerm() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initPlans() {
		plans.add(beanFactory.getBean(NumericUpdater.class));
	}

}
