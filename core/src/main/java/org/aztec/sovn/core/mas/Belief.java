package org.aztec.sovn.core.mas;

import java.util.List;
import java.util.Map;

/**
 * Beliefs represent knowledge of the world. However, in computational terms, Beliefs are just some way of representing
the state of the world, be it as the value of a variable, a relational database, or symbolic
expressions in predicate calculus. Beliefs are essential because the world is dynamic
(past events need therefore to be remembered), and the system only has a local view of
the world (events outside its sphere of perception need to be remembered). Moreover,
as the system is resource bounded, it is desirable to cache important information rather
than recompute it from base perceptual data. As Beliefs represent (possibly) imperfect
information about the world, the underlying semantics of the Belief component should
conform to belief logics, even though the computational representation need not be
symbolic or logical at all<br>
信念代表的是智能体(Agent)对世界的认识.尽管如此,从计算机术语来说,信念仅是世界的一些状态集合,一个变量的值,一个关系型数据库,又或者只是一个前置表达式中的一个逻辑符号。
因为世界是动态的,所以信息是必要(所有超出感知范围的需要被记录的过去事件),系统(译者注:这里指的是Agent)只需要有一个关于世界的 局部视角(所有超出感知范围的需要被记录的当前事件，).
然而，由于系统的资源是有限的,这是非常需要缓存重要信息,而不是从基本的感知数据中重新计算.
由于信念(可能)代表的是对于世界的不完全的信息. 信念的隐含语义应遵从信念逻辑，尽管从计算机表述的角度来说，根本不需要是符号或逻辑的形式。(译者注:这句有点费解，大概意思是，尽管信念在计算机中
可能只是一个变量或逻辑表达式，但信念在计算机中的表现形式应当更丰富，不应局限于变量和逻辑表达式)

 * @author liming
 *
 */
public interface Belief extends SelfAware,KownledgeContainer{

	public Environment getEnvironment();
	public void setEnvironment(Environment env);
}
