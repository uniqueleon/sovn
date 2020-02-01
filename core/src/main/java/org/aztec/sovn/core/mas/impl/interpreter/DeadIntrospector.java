package org.aztec.sovn.core.mas.impl.interpreter;

import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.KownledgeIntrospector;
import org.aztec.sovn.core.mas.Status;
import org.aztec.sovn.core.mas.impl.kownledge.Dead;
import org.aztec.sovn.core.mas.impl.status.HealthStatus;

public class DeadIntrospector  implements KownledgeIntrospector{

	public DeadIntrospector() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean accept(Status status) {
		return true;
	}

	@Override
	public Kownledge introspect(Status status) {
		status.assertNotNull(
				HealthStatus.HealthKeys.errorCount,HealthStatus.HealthKeys.successCount,
				HealthStatus.HealthKeys.leastSuccessRate);
		Long actionCount = status.getAttribute(HealthStatus.HealthKeys.actionCount);
		Long successCount = status.getAttribute(HealthStatus.HealthKeys.successCount);
		Double leastRate = status.getAttribute(HealthStatus.HealthKeys.leastSuccessRate);
		Double currentRate = successCount.doubleValue() / actionCount.doubleValue();
		if(currentRate < leastRate) {
			return new Dead();
		}
		return null;
	}

}
