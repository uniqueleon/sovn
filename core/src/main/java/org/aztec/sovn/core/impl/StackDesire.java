package org.aztec.sovn.core.impl;

import java.util.Stack;

import org.aztec.sovn.core.Desire;
import org.aztec.sovn.core.Intention;

public class StackDesire implements Desire {
	
	protected Stack<Intention> intentions = new Stack<>();

	public StackDesire() {
		// TODO Auto-generated constructor stub
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

}
