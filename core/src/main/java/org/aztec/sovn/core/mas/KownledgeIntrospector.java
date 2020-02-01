package org.aztec.sovn.core.mas;

import java.util.List;

/**
 * The internal introspector can introspect the status to a more specified knowledges.
 * 
 * 内部内省器可以将具体的状态值转译为某些特定的认知.
 * 
 * @author uniqueleon
 *
 */
public interface KownledgeIntrospector {

	public boolean accept(Status status);
	public Kownledge introspect(Status status);
}
