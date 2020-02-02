package org.aztec.sovn.core.mas.impl.plan;

import java.util.Map;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.Status;
import org.aztec.sovn.core.mas.utils.Eval;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.google.api.client.util.Maps;

@Component
public class NumericUpdater extends BasicPlan {
	
	public String expression;
	public String targetStatus;

	public NumericUpdater(String targetStatus,String expression) {
		// TODO Auto-generated constructor stub
		this.targetStatus = targetStatus;
		this.expression = expression;
	}

	@Override
	public void doRun(BDIAgent agent) {
		Status selfStatus = agent.getStatus();
		Map<String,Object> statusMap = selfStatus.getAttributes();
		Double result = Eval.eval(expression, toParamsMap(statusMap));
		statusMap.put(targetStatus, result);
	}
	
	private Map<String,Double> toParamsMap(Map<String,Object> statusMap){
		Map<String,Double> retMap = Maps.newHashMap();
		statusMap.forEach((key,value) -> {
			if(value instanceof Number) {
				retMap.put(key, new Double(value.toString()));
			}
		});
		return retMap;
	}

	@Override
	protected boolean shouldBeContinue() {
		return false;
	}

}
