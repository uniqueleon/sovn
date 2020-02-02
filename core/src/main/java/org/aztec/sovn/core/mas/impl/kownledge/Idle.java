package org.aztec.sovn.core.mas.impl.kownledge;

import org.aztec.sovn.core.mas.Kownledge;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Idle extends BasicKownledge {

	public Idle() {
		super(Kownledge.BaseKownledge.IDLE.getName());
	}

}
