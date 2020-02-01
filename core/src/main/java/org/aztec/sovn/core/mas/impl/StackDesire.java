package org.aztec.sovn.core.mas.impl;

import java.util.Stack;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Desire;
import org.aztec.sovn.core.mas.Intention;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("stackDesire")
@Scope("prototype")
public class StackDesire implements Desire {
	
	protected Stack<Intention> intentions = new Stack<>();
	protected BDIAgent self;

	public StackDesire(BDIAgent self) {
		this.self = self;
	}

	@Override
	public Intention getRationalIntension() {
		return intentions.pop();
	}
	
	public void push(Intention intention) {
		this.intentions.push(intention);
	}

	@Override
	public boolean isReasonable() {
		return true;
	}

	@Override
	public boolean isSatified() {
		return intentions.isEmpty();
	}

	public BDIAgent getSelf() {
		return self;
	}

	public void setSelf(BDIAgent self) {
		this.self = self;
	}

}
