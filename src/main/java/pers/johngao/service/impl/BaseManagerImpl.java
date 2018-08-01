package pers.johngao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pers.johngao.dao.BaseDao;
import pers.johngao.pojo.Base;
import pers.johngao.service.BaseManager;
@Service
public class BaseManagerImpl implements BaseManager{
	@Autowired
	private BaseDao baseDao;
	
	@Transactional
	@Override
	public Base registBase(Base b) {
		return baseDao.addBase(b);
	}
	@Transactional
	@Override
	public Base updateBase(Base b) {
		return baseDao.update(b);
	}
	@Transactional
	@Override
	public void deleteBase(String id) {
		baseDao.delete(id);
	}

	@Override
	public List<Base> findAllBases() {
		return baseDao.findAllBase();
	}

}
