package org.aztec.sovn.core.mas;

/**
 * The plan for executing to acceive goals.</br>
 * Agent实现意图的执行计划.
 * @author liming
 *
 */
public interface Plan {

	public void execute(BDIAgent agent);
	public void stop();
	public void resume();
	public void interrupt();
	public boolean isFinished();
}
