package com.longsheng.xueqiao.admin.bean;

import java.util.List;

public class LocalOrderDetail {

	private LocalOrder order;
	private List<LocalOrderFlow> orderFlowList;

	public LocalOrder getOrder() {
		return order;
	}

	public void setOrder(LocalOrder order) {
		this.order = order;
	}

	public List<LocalOrderFlow> getOrderFlowList() {
		return orderFlowList;
	}

	public void setOrderFlowList(List<LocalOrderFlow> orderFlowList) {
		this.orderFlowList = orderFlowList;
	}
}
