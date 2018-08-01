package pers.johngao.service;

import java.util.List;

import pers.johngao.pojo.Item;


public interface ItemManager {
	public Item registItem(Item i,String baseId);
	public Item updateItem(Item i);
	public void deleteItem(String id);
	public List<Item> findAllItems(String id);
}
