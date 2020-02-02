package org.aztec.sovn.core.mas.impl.kownledge;

import org.aztec.sovn.core.mas.Kownledge;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Sleep extends BasicKownledge {

	public Sleep() {
		super(Kownledge.BaseKownledge.SLEEP.getName());
	}

}
