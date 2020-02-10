package org.aztec.sovn.core.mas.impl.term;

import org.aztec.sovn.core.mas.impl.plan.NumericUpdater;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class NumericOptTerm extends InternalTerm {

	public NumericOptTerm() {
		super("NUMERIC_OPT");
	}

	@Override
	protected void initPlans(Object... args) {
		plans.add(beanFactory.getBean(NumericUpdater.class,args));
	}

}
