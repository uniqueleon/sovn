package org.aztec.sovn.core;

/**
 * The meaning of a status,or a kownledge, or a desire.</br>
 * 
 * 一个状态,知识,或者一个期望所代表的含义.
 * 
 * @author liming
 *
 */
public interface Meaning {

	/**
	 * Change to a agent's desire. e.g. if a meaning means hungry, the meaning shoud change to a desire of "get food".
	 * </br>
	 * 
	 * 
	 * @return
	 */
	public Desire toDesire();
}
