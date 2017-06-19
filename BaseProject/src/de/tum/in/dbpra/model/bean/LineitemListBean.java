package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;

public class LineitemListBean {

	private ArrayList<LineitemBean> list = new ArrayList<LineitemBean>();

	public void setChild(LineitemBean object) {
		list.add(object);
	}

	public LineitemBean getChild(int i) {
		return list.get(i);
	}

	public void setList(ArrayList<LineitemBean> list) {
		this.list = list;
	}

	public ArrayList<LineitemBean> getList() {
		return list;
	}
}
