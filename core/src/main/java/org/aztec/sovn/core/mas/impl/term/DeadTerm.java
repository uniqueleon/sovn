package org.aztec.sovn.core.mas.impl.term;

import org.aztec.sovn.core.mas.impl.plan.Die;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class DeadTerm extends InternalTerm {

	public DeadTerm() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initPlans() {
		plans.add(beanFactory.getBean(Die.class));
	}

}
