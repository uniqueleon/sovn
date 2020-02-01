package org.aztec.sovn.core.mas.impl.plan;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Plan;
import org.aztec.sovn.core.mas.impl.status.HealthStatus;
import org.aztec.sovn.core.mas.utils.AgentLogger;

public abstract class BasicPlan implements Plan {

	private boolean runnable = false;
	private boolean finished = false;

	protected abstract void doRun(BDIAgent agent) throws Exception;

	protected abstract boolean shouldBeContinue();

	public BasicPlan() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(BDIAgent agent) {
		increase(agent, HealthStatus.HealthKeys.busyPoint);
		while (runnable) {
			try {
				doRun(agent);
				increase(agent, HealthStatus.HealthKeys.successCount);
			} catch (Exception e) {
				AgentLogger.error(e);
				increase(agent, HealthStatus.HealthKeys.errorCount);
			}
			if (!shouldBeContinue()) {
				finished = true;
				break;
			}
		}
		increase(agent, HealthStatus.HealthKeys.actionCount);
	}
	
	private void increase(BDIAgent agent,String key) {
		Long value = agent.getStatus().getAttribute(key);
		if (value == null) {
			value = 0l;
		}
		value ++;
		agent.getStatus().setAttribute(key, value);
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
