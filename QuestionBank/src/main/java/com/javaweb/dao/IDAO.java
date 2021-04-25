package com.javaweb.dao;

public interface IDAO<K,V> {
	public boolean doCreate(K vo) throws Exception;
	public boolean doRemove(V vo) throws Exception;
	public boolean doUpdate(K vo) throws Exception;
}
