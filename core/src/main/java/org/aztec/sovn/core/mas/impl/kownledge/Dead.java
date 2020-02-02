package org.aztec.sovn.core.mas.impl.kownledge;

import org.aztec.sovn.core.mas.Kownledge;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class Dead extends BasicKownledge {

	public Dead() {
		super(Kownledge.BaseKownledge.DEAD.getName());
	}

}
