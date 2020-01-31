package org.aztec.sovn.core.impl.behaviour;

import java.util.List;

import org.aztec.sovn.core.BDIAgent;
import org.aztec.sovn.core.Belief;
import org.aztec.sovn.core.DesireGenerator;
import org.aztec.sovn.core.KonwledgeInterpreter;
import org.aztec.sovn.core.Kownledge;
import org.aztec.sovn.core.utils.ExecutorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import jade.core.behaviours.TickerBehaviour;
import reactor.core.publisher.Flux;

public class Sensor extends TickerBehaviour {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7622835821667924806L;

	private static long DEFAULT_AGENT_PERIOD = 10l;

	public Sensor() {
		super(null, DEFAULT_AGENT_PERIOD);
	}

	boolean isRunnable = false;
	
	@Autowired
	@Qualifier("prologGen")
	private DesireGenerator generator;

	@Override
	protected void onTick() {
		BDIAgent self = AgentHelper.cast2BDIAgent(getAgent());
		if (self != null) {
			ExecutorServices.execute(new StatusConsumer(self));
		}
	}
	
	public class StatusConsumer implements Runnable{
		
		private BDIAgent self;
		
	    public StatusConsumer(BDIAgent self) {
	    	this.self = self;
		}

		@Override
		public void run() {
			Belief belief = self.getBeliefs();
			Flux.fromStream(belief.getStatus().stream())
			.subscribe(status -> {
				List<Kownledge> kownledges  = belief.getKownledges();
				List<KonwledgeInterpreter> interpreters = belief.getInterpreters();
				interpreters.stream().forEach(interpreter -> {
					if(interpreter.accept(status)) {
						kownledges.addAll(interpreter.interpret(status));
					}
				});
				self.setDesire(generator.generate(self));
				//return konwledges;
				
			});
		}
		
	}

	public static void main(String[] args) {
		 Flux.from(str -> {
			    for(int i = 0;i < 3;i ++) {

					try {
						Thread.currentThread().sleep(1000);
						str.onNext("suck");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
				
			}).subscribe(str -> {
				System.out.println(str);
			});
		System.out.println("finished");
		try {
			Thread.currentThread().sleep(4000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
