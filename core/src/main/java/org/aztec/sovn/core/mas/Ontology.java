package org.aztec.sovn.core.mas;

/**
 * Ontology used to represent the meaning of the konwledge,more specified, to translate the kownledge
 * @author uniqueleon
 *
 */
public interface Ontology {

	public <T> T translate(Kownledge kownledge);
	public void mapping(Kownledge kownledge,Object object);
}
