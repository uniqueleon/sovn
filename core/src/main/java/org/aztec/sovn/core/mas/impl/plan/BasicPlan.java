package org.aztec.sovn.core.mas.impl.plan;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Plan;

public abstract class BasicPlan implements Plan {
	
	private boolean runnable = false;
	private boolean finished =false;
	protected abstract void doRun(BDIAgent agent);
	protected abstract boolean shouldBeContinue();

	public BasicPlan() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(BDIAgent agent) {
		// TODO Auto-generated method stub
		while(runnable) {
			doRun(agent);
			if(!shouldBeContinue()) {
				finished = true;
				break;
			}
		}
	}

	@Override
	public void stop() {
		runnable = false;

	}

	@Override
	public void resume() {
		runnable = true;
	}

	@Override
	public void interrupt() {
		runnable = false;
	}

	@Override
	public boolean isFinished() {
		return finished;
	}

}
