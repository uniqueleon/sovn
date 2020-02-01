package org.aztec.sovn.core.mas;

public interface Term {

	public String name();
	public boolean isComputional();
	public <T extends Term> T cast();
}
