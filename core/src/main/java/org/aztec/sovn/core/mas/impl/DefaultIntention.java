package org.aztec.sovn.core.mas.impl;

import java.util.List;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Intention;
import org.aztec.sovn.core.mas.Plan;
import org.aztec.sovn.core.mas.utils.ExecutorServices;

import com.google.common.collect.Lists;

public class DefaultIntention implements Intention {
	
	protected List<Plan> plans;
	protected boolean ready = true;
	protected boolean stoped = false;
	protected boolean running = false;
	protected boolean finished = true;
	protected BDIAgent self;
	

	public DefaultIntention(BDIAgent self) {
		this.self = self;
		plans = Lists.newArrayList();
	}


	@Override
	public boolean isReady() {
		return ready;
	}

	@Override
	public boolean isStoped() {
		return stoped;
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public boolean isFinished() {
		if(finished)
			return finished;
		else {
			for(Plan plan : plans) {
				finished = plan.isFinished();
				if(!finished) {
					break;
				}
			}
		}
		return finished;
	}

	@Override
	public void cancel() {
		stoped = true;
		finished = false;
		running = false;
		for(Plan plan : plans) {
			plan.stop();
		}
	}

	@Override
	public void interrupt() {
		stoped = true;
		finished = false;
		for(Plan plan : plans) {
			plan.interrupt();
		}
	}


	@Override
	public List<Plan> getPlans() {
		return plans;
	}


	@Override
	public void resume() {
		for(Plan plan : plans) {
			plan.resume();
		}
	}


	@Override
	public void execute() {

		ExecutorServices.execute(new IntensionExecutor());
	}
	public class IntensionExecutor implements Runnable {

		public IntensionExecutor() {
			super();
		}

		@Override
		public void run() {
			getPlans().stream().forEach(plan -> {
				plan.execute(self);
			});
		}
		
	}
	@Override
	public BDIAgent getSelf() {
		return self;
	}
}
