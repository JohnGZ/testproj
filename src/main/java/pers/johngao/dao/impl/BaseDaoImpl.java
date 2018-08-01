package pers.johngao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pers.johngao.dao.BaseDao;
import pers.johngao.pojo.Base;

@Repository
public class BaseDaoImpl implements BaseDao{
	@PersistenceContext(name="em")
	private EntityManager manager;
	@Override
	public Base addBase(Base b) {
		manager.persist(b);
		return b;
	}

	@Override
	public void delete(String id) {
		Base base = manager.getReference(Base.class, id);
		manager.remove(base);
	}

	@Override
	public Base update(Base b) {
		Base base = manager.merge(b);
		return base;
	}

	@Override
	public List<Base> findAllBase() {
		String jpql = "from pers.johngao.pojo.Base";
		List<Base> bases=manager
				.createQuery(jpql)
				.getResultList();
		return bases;
	}

}
