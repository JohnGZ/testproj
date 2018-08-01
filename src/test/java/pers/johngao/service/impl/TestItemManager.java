package pers.johngao.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.johngao.pojo.Base;
import pers.johngao.pojo.Item;
import pers.johngao.service.ItemManager;

public class TestItemManager {
	private static ApplicationContext context;
	@BeforeClass
	public static void init() {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testRegistItem() {
		ItemManager manager = context.getBean(ItemManagerImpl.class);
		Item item = new Item();
		item.setItemName("water");
		item.setItemNum(20);
		Base base = new Base();
		base.setId("8a5e9d4064efe35b0164efe35dc20000");
		item.setBase(base);
		Item item2 = manager.registItem(item);
		Assert.assertTrue(item2.getId()!=null);
	}
	
	@Test
	public void testUpdateItem() {
		ItemManager manager = context.getBean(ItemManagerImpl.class);
		Item item = new Item();
		item.setId("8a5e9d4064ef21950164ef21978f0000");
		item.setItemNum(20);
		item.setItemName("table");
		Base base = new Base();
		base.setId("8a5e9d4064ef25260164ef2528b50000");
		item.setBase(base);
		Item item2 = manager.updateItem(item);
		Assert.assertTrue(item2.getItemNum() == 20);
	}
	
	@Test
	public void testFindAllItems() {
		ItemManager manager = context.getBean(ItemManagerImpl.class);
		List<Item> list = manager.findAllItems("8a5e9d4064ef212b0164ef212df50000");
		Assert.assertTrue(list.size()==1);
	}
	
	@Test
	public void testDeleteItem() {
		ItemManager manager = context.getBean(ItemManagerImpl.class);
		String id = "8a5e9d4064ef24ba0164ef24bc3f0000";
		manager.deleteItem(id);
		Assert.assertTrue(manager.findAllItems("8a5e9d4064ef212b0164ef212df50000").size()==1);
	}
}
