package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;

public class PartListBean {

	private ArrayList<PartBean> list = new ArrayList<PartBean>();

	public void setChild(PartBean object) {
		list.add(object);
	}

	public PartBean getChild(int i) {
		return list.get(i);
	}

	public void setList(ArrayList<PartBean> list) {
		this.list = list;
	}

	public ArrayList<PartBean> getList() {
		return list;
	}
}
