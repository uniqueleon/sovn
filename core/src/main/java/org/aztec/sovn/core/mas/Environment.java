package org.aztec.sovn.core.mas;

import java.util.List;
import java.util.Map;

/**
 * 用于抽象Agent的外部环境.
 * @author liming
 *
 */
public interface Environment extends KownledgeContainer{


	public List<Status> getStatus();

}
