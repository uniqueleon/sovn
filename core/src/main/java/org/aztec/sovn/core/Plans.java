package org.aztec.sovn.core;

public interface Plans extends Runnable{

	public Plan getCurrentPlan();
	public void next();
	public void cancel();
	public void stop();
	public void resume();
}
