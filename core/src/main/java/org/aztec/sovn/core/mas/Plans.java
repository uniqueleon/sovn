package org.aztec.sovn.core.mas;

public interface Plans extends Runnable{

	
	public void cancel();
	public void stop();
	public void resume();
}
