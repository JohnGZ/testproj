package pers.johngao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pers.johngao.dao.ItemDao;
import pers.johngao.pojo.Item;
import pers.johngao.service.ItemManager;
@Service
public class ItemManagerImpl implements ItemManager{

	@Autowired
	private ItemDao itemDao;
	
	@Transactional
	@Override
	public Item registItem(Item item) {
		return itemDao.addItem(item);
	}

	@Transactional
	@Override
	public Item updateItem(Item item) {
		
		return itemDao.update(item);
	}

	@Transactional
	@Override
	public void deleteItem(String id) {
		itemDao.delete(id);
	}

	@Override
	public List<Item> findAllItems(String id) {
		return itemDao.findAllItem(id);
	}

}
