package org.aztec.sovn.core.impl.behaviour;

import org.apache.commons.collections.CollectionUtils;
import org.aztec.sovn.core.BDIAgent;
import org.aztec.sovn.core.Intention;
import org.aztec.sovn.core.utils.ExecutorServices;
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
					if(CollectionUtils.isNotEmpty(intention.getPlans())) {
						ExecutorServices.execute(new IntensionExecutor(intention, self));
					}
				}
			});
		}
	}
	
	public class IntensionExecutor implements Runnable {

		private Intention intention;
		private BDIAgent self;
		
		public IntensionExecutor(Intention intention, BDIAgent self) {
			super();
			this.intention = intention;
			this.self = self;
		}

		@Override
		public void run() {
			intention.getPlans().stream().forEach(plan -> {
				plan.execute();
			});
		}
		
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		this.beanFactory = beanFactory;
	}

}
