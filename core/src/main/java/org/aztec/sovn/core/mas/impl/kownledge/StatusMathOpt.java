package org.aztec.sovn.core.mas.impl.kownledge;

import org.aztec.sovn.core.mas.Kownledge;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class StatusMathOpt extends BasicKownledge {

	public StatusMathOpt() {
		super(Kownledge.BaseKownledge.STATUS_NUMBER_OPT.getName());
	}

}
