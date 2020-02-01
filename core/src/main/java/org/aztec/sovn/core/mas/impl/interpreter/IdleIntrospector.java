package org.aztec.sovn.core.mas.impl.interpreter;

import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.KownledgeIntrospector;
import org.aztec.sovn.core.mas.Status;
import org.aztec.sovn.core.mas.impl.kownledge.Idle;
import org.aztec.sovn.core.mas.impl.status.HealthStatus;
import org.springframework.stereotype.Component;

@Component("idleIntrospector")
public class IdleIntrospector implements KownledgeIntrospector {

	public IdleIntrospector() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean accept(Status status) {
		return true;
	}

	@Override
	public Kownledge introspect(Status status) {
		status.assertNotNull(HealthStatus.HealthKeys.busyPoint);
		Integer busyPoint = status.getAttribute(HealthStatus.HealthKeys.busyPoint);
		if(busyPoint == 0){
			return new Idle();
		}
		return null;
	}

}
