package org.aztec.sovn.core.mas;

import java.util.List;

/**
 * The meaning interpreter can interpret the status to a more specified knowledges.
 * 
 * 认知解释器可以将具体的状态值转译为某些特定的认知.
 * 
 * @author uniqueleon
 *
 */
public interface KonwledgeInterpreter {

	public boolean accept(Status status);
	public List<Kownledge> interpret(Status status);
}
