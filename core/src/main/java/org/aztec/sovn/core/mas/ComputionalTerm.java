package org.aztec.sovn.core.mas;

import java.util.List;

/**
 * 计算机术语
 * @author uniqueleon
 *
 */
public interface ComputionalTerm {

	public boolean isOuterService();
	public boolean isInnerService();
	public List<Plan> toPlans(Object... args);
}
