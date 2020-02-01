package org.aztec.sovn.core.mas.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.aztec.sovn.core.mas.AgentType;
import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.BDIAgentMetaData;
import org.aztec.sovn.core.mas.Belief;
import org.aztec.sovn.core.mas.Desire;
import org.aztec.sovn.core.mas.Environment;
import org.aztec.sovn.core.mas.Intention;
import org.aztec.sovn.core.mas.MasBeanFactory;
import org.springframework.stereotype.Component;

import alice.tuprolog.InvalidLibraryException;

@Component("defaultBeanFactory")
public class DefaultBeanFactory implements MasBeanFactory {
	
	private Environment environment;

	public DefaultBeanFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Desire createDesire(BDIAgent agent) {
		return new StackDesire(agent);
	}

	@Override
	public Intention createIntention(BDIAgent agent) {
		return new DefaultIntention(agent);
	}

	@Override
	public BDIAgent createAgent(BDIAgentMetaData metaData) throws InvalidLibraryException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if(metaData != null && metaData.getType() != null) {
			AgentType agentType = metaData.getType();
			if(agentType.getTypeName().contentEquals(BasicAgentType.BASE_AGENT_TYPE_NAME)) {
				BaseBDIAgent agent = new BaseBDIAgent(metaData);
				agent.setBelief(createBelief(agent));
			}
			else if(agentType.getAgentCls() != null) {
				Class<? extends BDIAgent> targetCls = agentType.getAgentCls();
				Constructor<? extends BDIAgent> constructor = targetCls.getConstructor(BDIAgentMetaData.class);
				constructor.setAccessible(true);
				BDIAgent agent = constructor.newInstance(metaData);
				agent.setBelief(createBelief(agent));
			}
		}
		return null;
	}

	@Override
	public Belief createBelief(BDIAgent agent) throws InvalidLibraryException {
		return new PrologBelief(agent,getEnvironment());
	}

	@Override
	public Environment getEnvironment() {
		return LocalEnvironment.getInstance();
	}

}
