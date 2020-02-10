package org.aztec.sovn.core.mas.impl;

import java.util.List;
import java.util.Map;

import org.aztec.sovn.core.mas.Kownledge;
import org.aztec.sovn.core.mas.Ontology;
import org.aztec.sovn.core.mas.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.api.client.util.Maps;

@Component("baseOntology")
@Scope("singleton")
public class BasicOntology implements Ontology{
	
	protected Map<Kownledge,Object> mapping = Maps.newHashMap();
	
	
	
	public BasicOntology(@Autowired List<Kownledge> kownledges,@Autowired List<Term> terms) {
		for(int i = 0;i < kownledges.size();i++) {
			mapping.put(kownledges.get(i), terms.get(i));
		}
	}
	
	@Override
	public Term translate(Kownledge kownledge) {
		if(mapping.containsKey(kownledge)) {
			return (Term) mapping.get(kownledge);
		}
		return null;
	}

	@Override
	public void mapping(Kownledge kownledge, Object object) {
		mapping.put(kownledge, object);
	}

}
