package org.aztec.sovn.core.mas.impl.term;

import org.aztec.sovn.core.mas.impl.plan.IdlePlan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class IdleTerm extends InternalTerm {

	public IdleTerm() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initPlans() {
		plans.add(beanFactory.getBean(IdlePlan.class));
	}

}
