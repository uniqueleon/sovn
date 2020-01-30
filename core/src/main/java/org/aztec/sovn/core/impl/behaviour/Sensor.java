package org.aztec.sovn.core.impl.behaviour;

import java.util.List;
import java.util.function.Consumer;

import org.aztec.sovn.core.BDIAgent;
import org.aztec.sovn.core.Belief;
import org.aztec.sovn.core.KonwledgeInterpreter;
import org.aztec.sovn.core.Kownledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import jade.core.behaviours.TickerBehaviour;
import reactor.core.publisher.Flux;

public class Sensor extends TickerBehaviour {
	
	private static long DEFAULT_AGENT_PERIOD = 10l;

	public Sensor() {
		super(null, DEFAULT_AGENT_PERIOD);
	}

	boolean isRunnable = false;
	
	@Autowired
	@Qualifier("desireConsumer")
	private Consumer<Kownledge> consumer;

	@Override
	protected void onTick() {
		BDIAgent self = AgentHelper.cast2BDIAgent(getAgent());
		if (self != null) {
			Belief beliefs = self.getBeliefs();
			List<KonwledgeInterpreter> interpreters = beliefs.getInterpreters();
			List<Kownledge> kownledges  = beliefs.getKownledges();	
			beliefs.getStatus().stream().forEach(status -> {
				interpreters.stream().forEach(interpreter -> {
					if(interpreter.accept(status)) {
						kownledges.addAll(interpreter.interpret(status));
						
					}
				});
			});
			Flux.just(kownledges.toArray(new Kownledge[kownledges.size()])).subscribe(consumer);
		}
		
	}


}
