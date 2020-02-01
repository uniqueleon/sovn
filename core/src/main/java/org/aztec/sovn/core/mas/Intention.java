package org.aztec.sovn.core.mas;

import java.util.List;

/**
 * Computationally, Intentions may simply be a set of executing threads in a process that
can be appropriately interrupted upon receiving feedback from the possibly changing
world.</br>
从计算机的角度, 简单地来说,意图可能就是能被可能持续变化的世界所产生的回馈合理打断的一组线程的集合。
 * @author liming
 *
 */
public interface Intention extends SelfAware{

	public List<Plan> getPlans();
	public boolean isReady();
	public boolean isStoped();
	public boolean isRunning();
	public boolean isFinished();
	public void cancel();
	public void interrupt();
	public void resume();
	public BDIAgent getSelf();
	public void execute();
}
