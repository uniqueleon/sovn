package org.aztec.sovn.core.mas.impl;

import java.lang.reflect.InvocationTargetException;

import org.aztec.sovn.core.mas.AgentType;
import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.BDIAgentMetaData;
import org.aztec.sovn.core.mas.Belief;
import org.aztec.sovn.core.mas.Desire;
import org.aztec.sovn.core.mas.Environment;
import org.aztec.sovn.core.mas.Intention;
import org.aztec.sovn.core.mas.MasBeanFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import alice.tuprolog.InvalidLibraryException;

@Component("defaultBeanFactory")
public class DefaultBeanFactory implements MasBeanFactory,BeanFactoryAware {
	
	private BeanFactory beanFactory;

	public DefaultBeanFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Desire createDesire(BDIAgent agent) {
		return (Desire)beanFactory.getBean(Desire.class,agent);
	}

	@Override
	public Intention createIntention(BDIAgent agent) {
		return (Intention)beanFactory.getBean(Intention.class,agent);
	}

	@Override
	public BDIAgent createAgent(BDIAgentMetaData metaData) throws InvalidLibraryException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if(metaData != null && metaData.getType() != null) {
			AgentType agentType = metaData.getType();
			BDIAgent agent = (BDIAgent) beanFactory.getBean(agentType.getTypeName(),metaData);
			agent.setBelief(createBelief(agent));
		}
		return null;
	}

	@Override
	public Belief createBelief(BDIAgent agent) throws InvalidLibraryException {
		return (Belief)beanFactory.getBean(Belief.class,agent);
	}

	@Override
	public Environment getEnvironment() {
		return LocalEnvironment.getInstance();
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
