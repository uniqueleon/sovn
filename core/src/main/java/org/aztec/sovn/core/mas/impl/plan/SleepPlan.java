package org.aztec.sovn.core.mas.impl.plan;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Plan;
import org.aztec.sovn.core.mas.impl.behaviour.Sensor;

import jade.core.behaviours.Behaviour;

public class SleepPlan extends BasicPlan implements Plan {


	@Override
	protected void doRun(BDIAgent agent) {
		// TODO Auto-generated method stub
		for(Behaviour behavior : agent.getBahaviors()) {
			if(behavior instanceof Sensor) {
				((Sensor) behavior).stop(agent.getMetaData().getRateOfReaction());
			}
		}
	}

	@Override
	protected boolean shouldBeContinue() {
		return false;
	}

}
