package org.aztec.sovn.core.mas.impl;

import java.util.List;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Belief;
import org.aztec.sovn.core.mas.ComputionalTerm;
import org.aztec.sovn.core.mas.Desire;
import org.aztec.sovn.core.mas.Intention;
import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.MasBeanFactory;
import org.aztec.sovn.core.mas.Ontology;
import org.aztec.sovn.core.mas.Term;
import org.aztec.sovn.core.mas.impl.kownledge.StringifyKonwledge;
import org.aztec.sovn.core.mas.ml.prolog.PrologEngine;
import org.aztec.sovn.core.mas.utils.AgentLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alice.tuprolog.SolveInfo;
import reactor.core.publisher.Flux;

@Component("prologGen")
public class PrologDesireGenerator implements  org.aztec.sovn.core.mas.DesireGenerator{

	@Autowired
	Ontology ontology;
	
	@Autowired
	MasBeanFactory beanFactory;

	@Override
	public Flux<Desire> generate(BDIAgent agent) {
		
		return Flux.from(ss -> {
			try {
				Belief belief = agent.getBeliefs();
				if(belief != null ) {
					List<Kownledge> kownledges = agent.getBeliefs().getKownledges();
					PrologEngine prolog = belief.getProlog();
					Desire desire = beanFactory.createDesire(agent);
					Intention intention = beanFactory.createIntention(agent);
					kownledges.stream().forEach(kownledge -> {
						try {
							SolveInfo si = prolog.solve(kownledge.name() + "(" + agent.getName() + ").");
							if(si.isSuccess()) {
								// To execute internal action.
								Term term = ontology.translate(kownledge);
								if(term != null) {
									if(term.isComputional()) {
										ComputionalTerm cTerm = term.cast();
										intention.getPlans().addAll(cTerm.toPlans());
									}
									else {
										belief.setKownledge(term.name(), new StringifyKonwledge(term.name()));
									}
								}
							}
							else {
								si = prolog.solve(kownledge.name() + "(X).");
								if(si.isSuccess()) {
									// To get service from other agent;
									String agentName = si.getBindingVars().get(0).getName();
									Term term = ontology.translate(kownledge);
									if(term != null && term.isComputional()) {
										ComputionalTerm cTerm = term.cast();
										intention.getPlans().addAll(cTerm.toPlans(agentName));
									}
								}
							}
						} catch (Exception e) {
							AgentLogger.error(e);
						}
					});
					ss.onNext(desire);
				}
			} catch (Exception e) {
				AgentLogger.error(e);
			}
			
			//ss.onNext(agent);
		});
	}

}
