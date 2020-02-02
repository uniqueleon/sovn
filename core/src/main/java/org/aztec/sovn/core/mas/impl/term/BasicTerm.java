package org.aztec.sovn.core.mas.impl.term;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.aztec.sovn.core.mas.ComputionalTerm;
import org.aztec.sovn.core.mas.Plan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import com.google.common.collect.Lists;

public abstract class BasicTerm implements ComputionalTerm,BeanFactoryAware{
	
	List<Plan> plans = Lists.newArrayList();
	
	BeanFactory beanFactory;
	
	private AtomicBoolean hasInited = new AtomicBoolean(false);

	public BasicTerm() {
		super();
	}

	protected abstract void initPlans();

	@Override
	public List<Plan> toPlans(Object... args) {
		if(!hasInited.get()
				&& hasInited.compareAndSet(false, true)) {
			initPlans();
		}
		return plans;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
