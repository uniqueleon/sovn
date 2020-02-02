package org.aztec.sovn.core.mas.impl.term;

import org.aztec.sovn.core.mas.impl.plan.Die;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SleepTerm extends InternalTerm {

	public SleepTerm() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initPlans() {
		plans.add(beanFactory.getBean(Die.class));

	}

}
