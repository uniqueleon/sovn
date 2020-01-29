package org.aztec.sovn.core;

import java.util.Map;
/**
 * The status of a Agent.</br>
 * Agent 的状态.
 * 
 * @author liming
 *
 */
public interface AgentStatus extends KownledgeOfMySelf {


	public Map<String,Object> getAsMap();
}
