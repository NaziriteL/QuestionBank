package com.javaweb.vo;

import java.util.List;

public class ObjectListTemplate<K>{
	private List<K> index;
	public List<K> getIndex() {
		return index;
	}
	public void setIndex(List<K> index) {
		this.index = index;
	}	
}
