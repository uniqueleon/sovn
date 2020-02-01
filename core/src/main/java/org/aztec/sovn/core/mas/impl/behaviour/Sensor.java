package org.aztec.sovn.core.mas.impl.behaviour;

import org.apache.commons.collections.CollectionUtils;
import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Belief;
import org.aztec.sovn.core.mas.Desire;
import org.aztec.sovn.core.mas.DesireGenerator;
import org.aztec.sovn.core.mas.Intention;
import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.impl.AgentHelper;
import org.aztec.sovn.core.mas.utils.ExecutorServices;
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
	
	private long sleepTimeOut = 1000l;
	private long sleepTime = System.currentTimeMillis();

	public Sensor() {
		super(null, DEFAULT_AGENT_PERIOD);
	}

	boolean isRunnable = false;
	
	@Autowired
	@Qualifier("prologGen")
	private DesireGenerator generator;

	@Override
	protected void onTick() {
		if(isRunnable || isSleepTimeout()) {
			BDIAgent self = AgentHelper.cast2BDIAgent(getAgent());
			if (self != null) {
				ExecutorServices.execute(new StatusConsumer(self));
			}
		}
	}
	
	private boolean isSleepTimeout() {
		long curTime = System.currentTimeMillis();
		if((curTime - sleepTime) > sleepTimeOut) {
			isRunnable = true;
		}
		return isRunnable;
	}
	
	public void stop(long sleepTimeout) {
		isRunnable = false;
		this.sleepTime = System.currentTimeMillis();
		this.sleepTimeOut = sleepTimeout;
	}
	
	public class StatusConsumer implements Runnable{
		
		private BDIAgent self;
		
	    public StatusConsumer(BDIAgent self) {
	    	this.self = self;
		}

		@Override
		public void run() {
			Belief belief = self.getBeliefs();
			Flux.fromStream(belief.getInterpreters().stream())
			.subscribe(interprector -> {
				Flux<Flux<Desire>> desires = Flux.from(ss -> {
					if(interprector.accept(self.getStatus())) {
						Kownledge kownledge = interprector.introspect(self.getStatus());
						if(kownledge != null) {
							belief.setKownledge(kownledge.name(), kownledge);
							ss.onNext(generator.generate(self));
						}
					}
				});
				desires.subscribe(flux -> {
					flux.subscribe(desire -> {
						if(desire.isReasonable()) {
							Intention intention = desire.getRationalIntension();
							if(intention.isReady() && !intention.isFinished()
									&& !intention.isRunning() && !intention.isStoped()
									&& CollectionUtils.isNotEmpty(intention.getPlans())) {
								intention.execute();
							}
						}
					});
				});
				//return konwledges;
				
			});
		}
		
	}

}
