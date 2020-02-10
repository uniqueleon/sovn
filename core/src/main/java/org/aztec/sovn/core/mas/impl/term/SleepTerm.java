package org.aztec.sovn.core.mas.impl.term;

import org.aztec.sovn.core.mas.impl.plan.Die;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SleepTerm extends InternalTerm {

	public SleepTerm() {
		super("SLEEP");
	}

	@Override
	protected void initPlans(Object... args) {
		plans.add(beanFactory.getBean(Die.class));

	}

}
