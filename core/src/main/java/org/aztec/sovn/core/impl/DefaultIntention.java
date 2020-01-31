package org.aztec.sovn.core.impl;

import org.aztec.sovn.core.Intention;
import org.aztec.sovn.core.Plans;

public class DefaultIntention implements Intention {
	
	protected Plans plans;
	protected boolean ready;
	protected boolean stoped;
	protected boolean running;
	protected boolean finished;
	

	public DefaultIntention() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Plans getPlans() {
		// TODO Auto-generated method stub
		return plans;
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
		return finished;
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		plans.cancel();
	}

	@Override
	public void interrupt() {
		// TODO Auto-generated method stub
		plans.stop();
	}

}
