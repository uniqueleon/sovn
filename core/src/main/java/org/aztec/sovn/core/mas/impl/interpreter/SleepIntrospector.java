package org.aztec.sovn.core.mas.impl.interpreter;

import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.KownledgeIntrospector;
import org.aztec.sovn.core.mas.Status;
import org.aztec.sovn.core.mas.impl.kownledge.Sleep;
import org.aztec.sovn.core.mas.impl.status.HealthStatus;
import org.springframework.stereotype.Component;

@Component("sleepIntrospector")
public class SleepIntrospector implements KownledgeIntrospector{

	public SleepIntrospector() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean accept(Status status) {
		return true;
	}

	@Override
	public Kownledge introspect(Status status) {
		status.assertNotNull(HealthStatus.HealthKeys.busyPoint,
				HealthStatus.HealthKeys.errorCount,HealthStatus.HealthKeys.successCount,
				HealthStatus.HealthKeys.basicSuccessRate);
		Long busyPoint = status.getAttribute(HealthStatus.HealthKeys.busyPoint);
		if(busyPoint > 90){
			return new Sleep();
		}
		Long actionCount = status.getAttribute(HealthStatus.HealthKeys.actionCount);
		Long successCount = status.getAttribute(HealthStatus.HealthKeys.successCount);
		Double standardRate = status.getAttribute(HealthStatus.HealthKeys.basicSuccessRate);
		Double currentRate = successCount.doubleValue() / actionCount.doubleValue();
		if(currentRate < standardRate) {
			return new Sleep();
		}
		return null;
	}

}
