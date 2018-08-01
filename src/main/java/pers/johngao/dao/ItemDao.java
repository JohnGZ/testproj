package pers.johngao.dao;

import java.util.List;

import pers.johngao.pojo.Item;


public interface ItemDao {
	public Item addItem(Item i);
	public void delete(String id);
	public Item update(Item i);
	public List<Item> findAllItem(String id);
}
