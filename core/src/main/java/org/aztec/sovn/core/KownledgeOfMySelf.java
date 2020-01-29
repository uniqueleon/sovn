package org.aztec.sovn.core;

/**
 * The kownledge of agent's self.</br>
 * 
 * 智能体对自己的认知.
 * 
 * @author liming
 *
 */
public interface KownledgeOfMySelf extends Kownledge {

	public AgentStatus getStatus();
	public Meaning getMeaning(AgentStatus status);
}
