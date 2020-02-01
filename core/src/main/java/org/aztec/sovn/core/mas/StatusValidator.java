package org.aztec.sovn.core.mas;

/**
 * 状态校验器
 * @author uniqueleon
 *
 */
public interface StatusValidator {

	public void validate(Status status) throws AgentException;
}
