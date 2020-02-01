package org.aztec.sovn.core.mas;

import reactor.core.publisher.Flux;

public interface DesireGenerator {

	public Flux<Desire> generate(BDIAgent agent);

}
