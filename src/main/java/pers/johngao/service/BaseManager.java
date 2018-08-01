package pers.johngao.service;

import java.util.List;

import pers.johngao.pojo.Base;


public interface BaseManager {
	public Base registBase(Base b);
	public Base updateBase(Base b);
	public void deleteBase(String id);
	public List<Base> findAllBases();
}
