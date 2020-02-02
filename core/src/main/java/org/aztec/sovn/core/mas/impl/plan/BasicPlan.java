package org.aztec.sovn.core.mas.impl.plan;

import org.aztec.sovn.core.mas.AgentConstant.MathOperator;
import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Plan;
import org.aztec.sovn.core.mas.Status;
import org.aztec.sovn.core.mas.impl.status.HealthStatus;
import org.aztec.sovn.core.mas.utils.AgentLogger;
import org.springframework.stereotype.Component;

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
		Status status = agent.getStatus();
		status.operateNumber(HealthStatus.HealthKeys.busyPoint, 1d, MathOperator.ADD);
		while (runnable) {
			try {
				doRun(agent);
				status.operateNumber(HealthStatus.HealthKeys.successCount, 1d, MathOperator.ADD);
			} catch (Exception e) {
				AgentLogger.error(e);
				status.operateNumber(HealthStatus.HealthKeys.errorCount, 1d, MathOperator.ADD);
			}
			if (!shouldBeContinue()) {
				finished = true;
				break;
			}
		}
		status.operateNumber(HealthStatus.HealthKeys.actionCount, 1d, MathOperator.ADD);
		status.operateNumber(HealthStatus.HealthKeys.busyPoint, 1d, MathOperator.SUBSTRACT);
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
