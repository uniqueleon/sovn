package org.aztec.sovn.core.mas.impl.interpreter;

import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.KownledgeInterpreter;
import org.aztec.sovn.core.mas.Status;
import org.aztec.sovn.core.mas.impl.kownledge.Sleep;
import org.aztec.sovn.core.mas.impl.status.HealthStatus;

public class BusiInterpreter implements KownledgeInterpreter{

	public BusiInterpreter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean accept(Status status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Kownledge interpret(Status status) {
		Integer busyPoint = status.getAttribute(HealthStatus.HealthKeys.busyPoint);
		if(busyPoint > 100){
			return new Sleep();
		}
		return null;
	}

}
