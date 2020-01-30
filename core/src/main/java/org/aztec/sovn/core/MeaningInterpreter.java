package org.aztec.sovn.core;

/**
 * The meaning interpreter can interpret the kownledge, desire ,intension to a more specified meaning.
 * 
 * 含义解释器可以转译知识,渴望,意图成更具体的意义.
 * 
 * @author uniqueleon
 *
 */
public interface MeaningInterpreter {

	public boolean accept(Kownledge kownledge);
	public Meaning interpret(Kownledge kownledge);
	public Meaning interpret(Desire kownledge);
	public Meaning interpret(Intension kownledge);
}
