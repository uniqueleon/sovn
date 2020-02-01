package org.aztec.sovn.core.mas;

/**
 * Desires (or, more commonly though somewhat loosely, Goals) form another essential
component of system state. Again, in computational terms, a Goal may simply be
the value of a variable, a record structure, or a symbolic expression in some logic. The
important point is that a Goal represents some desired end state. Conventional computer
software is ”task oriented” rather than ”goal oriented”; that is, each task (or subroutine)
is executed without any memory of why it is being executed. This means that the system
cannot automatically recover from failures (unless this is explicitly coded by the
programmer) and cannot discover and make use of opportunities as they unexpectedly
present themselves.<br>

追求(或者,更通俗地说，目标)封装了另外(译者注:对于Belief来说)一些必要的系统状态.重申,从计算机术语来说，一个目标可能仅仅只是一个变量的值,一个
结构化的记录,或者一个逻辑中的逻辑表达式.重点是目标代表的一些所追求的最终状态.常规的计算机软件都是"面向任务的"而不是"面向目标的".也就是说,每个任务
(或者，子程序)都是在不知道为什么要执行它的情况下被执行的.这意味着系统不能自动从失败中恢复过来(除非程序员显式编码重试机制)和当出现异常时
不能发现和及时利用所遇到的机会(译者注:这里可理解为因为异常而错过了最好的执行时机,但由于belief记录了系统事件后,Agent可以通过disire触发重现执行
环境执行任务).

 * @author liming
 *
 */
public interface Desire extends SelfAware{

	/**
	 * If the desire is reasonable, the desire should be change to intension.
	 * 
	 * 
	 * @return
	 */
	public Intention getRationalIntension();
	
	/**
	 * Test a desire wether reasonable or not . The so-called "reasonable" means the desire can be achieved according to the current environment.  
	 * 
	 * 判断当前的渴望是否是理知的.如果是理智的,证明在当前的环境下,渴望是可以得到满足的.
	 * 
	 * @return
	 */
	public boolean isReasonable();
	
	/**
	 * 判断需求是否已经得到满足
	 * @return
	 */
	public boolean isSatified();
	
	/**
	 * 增加意图
	 * @param intention
	 */
	public void push(Intention intention);
	
}
