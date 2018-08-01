package pers.johngao.dao;

import java.util.List;

import pers.johngao.pojo.Base;


public interface BaseDao {
	public Base addBase(Base b);
	public void delete(String id);
	public Base update(Base b);
	public List<Base> findAllBase();
}
