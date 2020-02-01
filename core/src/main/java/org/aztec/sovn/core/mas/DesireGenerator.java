package org.aztec.sovn.core.mas;

import reactor.core.publisher.Flux;

/**
 * 追求生成器.
 * @author uniqueleon
 *
 */
public interface DesireGenerator {

	public Flux<Desire> generate(BDIAgent agent);

}
