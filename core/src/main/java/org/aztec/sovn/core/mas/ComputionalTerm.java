package org.aztec.sovn.core.mas;

import java.lang.reflect.Method;

/**
 * 计算机术语
 * @author uniqueleon
 *
 */
public interface ComputionalTerm {

	public boolean isAction();
	public boolean isOuterService();
	public boolean isInnerService();
	public Plan toPlan(Object... args);
}
