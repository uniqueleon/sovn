package org.aztec.sovn.core.mas.impl.term;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.aztec.sovn.core.mas.ComputionalTerm;
import org.aztec.sovn.core.mas.Plan;
import org.aztec.sovn.core.mas.Term;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import com.google.common.collect.Lists;

public abstract class BasicTerm implements ComputionalTerm,BeanFactoryAware{
	
	List<Plan> plans = Lists.newArrayList();
	
	BeanFactory beanFactory;
	
	private AtomicBoolean hasInited = new AtomicBoolean(false);
	
	private String name;

	public BasicTerm(String name) {
		super();
		this.name = "TERM_" + name;
	}
	
	

	@Override
	public String name() {
		return name;
	}



	@SuppressWarnings("unchecked")
	@Override
	public <T extends Term> T cast() {
		return (T) this;
	}



	protected abstract void initPlans(Object... args);

	@Override
	public List<Plan> toPlans(Object... args) {
		if(!hasInited.get()
				&& hasInited.compareAndSet(false, true)) {
			initPlans(args);
		}
		return plans;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
