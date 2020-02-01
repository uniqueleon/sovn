package org.aztec.sovn.core.mas;

public interface MasBeanFactory {

	public Environment getEnvironment() throws Exception;
	public BDIAgent createAgent(BDIAgentMetaData metaData) throws Exception;
	public Belief createBelief(BDIAgent agent) throws Exception;
	public Desire createDesire(BDIAgent agent) throws Exception;
	public Intention createIntention(BDIAgent agent) throws Exception;
}
