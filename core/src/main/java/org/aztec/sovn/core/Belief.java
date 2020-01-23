package org.aztec.sovn.core;

import java.util.Map;

/**
 * Beliefs represent knowledge of the world. However, in computational terms, Beliefs are just some way of representing
the state of the world, be it as the value of a variable, a relational database, or symbolic
expressions in predicate calculus. Beliefs are essential because the world is dynamic
(past events need therefore to be remembered), and the system only has a local view of
the world (events outside its sphere of perception need to be remembered). Moreover,
as the system is resource bounded, it is desirable to cache important information rather
than recompute it from base perceptual data. As Beliefs represent (possibly) imperfect
The Belief-Desire-Intention Model of Agency 3
information about the world, the underlying semantics of the Belief component should
conform to belief logics, even though the computational representation need not be
symbolic or logical at all

 * @author liming
 *
 */
public interface Belief {

	public Map<String,Object> getProperties();
	public Object getProperty(String name);
	public void setProperty(String name,Object value);
}
