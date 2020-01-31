package org.aztec.sovn.core.impl.behaviour;

import java.util.List;

import org.aztec.sovn.core.BDIAgent;
import org.aztec.sovn.core.Belief;
import org.aztec.sovn.core.ComputionalTerm;
import org.aztec.sovn.core.Desire;
import org.aztec.sovn.core.Kownledge;
import org.aztec.sovn.core.Ontology;
import org.aztec.sovn.core.Term;
import org.aztec.sovn.core.impl.PrologBelief;
import org.aztec.sovn.core.utils.AgentLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alice.tuprolog.SolveInfo;
import reactor.core.publisher.Flux;

@Component("prologGen")
public class PrologGenerator implements  org.aztec.sovn.core.DesireGenerator{

	@Autowired
	Ontology ontology;

	@Override
	public Flux<Desire> generate(BDIAgent agent) {
		
		return Flux.from(ss -> {
			Belief belief = agent.getBeliefs();
			if(belief != null && belief instanceof PrologBelief) {
				PrologBelief pBelief = (PrologBelief) belief;
				List<Kownledge> kownledges = agent.getBeliefs().getKownledges();
				
				kownledges.stream().forEach(kownledge -> {

					try {
						SolveInfo si = pBelief.getProlog().solve(kownledge.name() + "(" + agent.getName() + ").");
						if(si.isSuccess()) {
							// To execute internal action.
						}
						else {
							si = pBelief.getProlog().solve(kownledge.name() + "(X).");
							if(si.isSuccess()) {
								// To get service from other agent;
								String agentName = si.getBindingVars().get(0).getName();
								Term term = ontology.translate(kownledge);
								if(term != null && term.isComputional()) {
									ComputionalTerm cTerm = term.cast();
									
								}
							}
						}
					} catch (Exception e) {
						AgentLogger.error(e);
					}
				});
			}
			
			//ss.onNext(agent);
		});
	}

}
