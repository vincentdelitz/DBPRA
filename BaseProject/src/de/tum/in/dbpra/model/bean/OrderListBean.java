package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;

public class OrderListBean {

	private ArrayList<OrderBean> list = new ArrayList<OrderBean>();

	public void setChild(OrderBean object) {
		list.add(object);
	}

	public OrderBean getChild(int i) {
		return list.get(i);
	}

	public void setList(ArrayList<OrderBean> list) {
		this.list = list;
	}

	public ArrayList<OrderBean> getList() {
		return list;
	}
}
