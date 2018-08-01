package pers.johngao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;import oracle.net.aso.i;
import pers.johngao.dao.ItemDao;
import pers.johngao.pojo.Base;
import pers.johngao.pojo.Item;
@Repository
public class ItemDaoImpl implements ItemDao{
	@PersistenceContext(name="em")
	private EntityManager manager;
	@Override
	public Item addItem(Item item,String baseId) {
		Base base = manager.getReference(Base.class, baseId);
		item.setBase(base);
		manager.persist(item);
		return item;
	}

	@Override
	public void delete(String id) {
		Item item = manager.getReference(Item.class, id);
		manager.remove(item);
	}

	@Override
	public Item update(Item item) {
		Item item2 = manager.merge(item);
		return item2;
	}

	@Override
	public List<Item> findAllItem(String id) {
		Base base = manager.getReference(Base.class, id);
		String jpql = "Select i from pers.johngao.pojo.Item i WHERE i.base = :base";
		
		return manager.createQuery(jpql)
				.setParameter("base", base)
				.getResultList();
	}

}
