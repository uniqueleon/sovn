package org.aztec.sovn.core.mas.impl.behaviour;

import org.apache.commons.collections.CollectionUtils;
import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Intention;
import org.aztec.sovn.core.mas.utils.AgentLogger;
import org.aztec.sovn.core.mas.utils.ExecutorServices;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import jade.core.behaviours.CyclicBehaviour;

public class ActionExecutor extends CyclicBehaviour implements BeanFactoryAware{
	
	BeanFactory beanFactory;

	public ActionExecutor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		BDIAgent self = AgentHelper.cast2BDIAgent(getAgent());
		if(self != null) {
			self.getCurrentDesire().subscribe(desire -> {
				if(desire.isReasonable()) {
					Intention intention = desire.getRationalIntension();
					if(intention.isReady() && !intention.isFinished()
							&& !intention.isRunning() && !intention.isStoped()
							&& CollectionUtils.isNotEmpty(intention.getPlans())) {
						intention.execute();
					}
				}
			});
		}
		try {
			Thread.currentThread().sleep(1);
		} catch (InterruptedException e) {
			AgentLogger.error(e);
		}
	}
	
	

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
