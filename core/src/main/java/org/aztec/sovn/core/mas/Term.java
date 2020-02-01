package org.aztec.sovn.core.mas;

/**
 * 术语，用于将知识进行转译.
 * @author uniqueleon
 *
 */
public interface Term {

	public String name();
	public boolean isComputional();
	public <T extends Term> T cast();
}
