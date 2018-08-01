package pers.johngao.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.johngao.pojo.Base;
import pers.johngao.service.BaseManager;

public class TestBaseManager {
	private static ApplicationContext context;
	@BeforeClass
	public static void init() {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testRegistBase() {
		BaseManager manager = context.getBean(BaseManagerImpl.class);
		Base base = new Base();
		base.setBaseName("book");
		Base base2 = manager.registBase(base);
		Assert.assertTrue(base2.getId()!=null);
	}
	
	@Test
	public void testUpdateBase() {
		BaseManager manager = context.getBean(BaseManagerImpl.class);
		Base base = new Base();
		base.setId("8a5e9d4064ef02b70164ef02b9b90000");
		base.setBaseName("computer");
		Base base2 = manager.updateBase(base);
		Assert.assertTrue(base2.getBaseName().equals("computer"));
	}
	
	@Test
	public void testFindAllBases() {
		BaseManager manager = context.getBean(BaseManagerImpl.class);
		List<Base> list = manager.findAllBases();
		Assert.assertTrue(list.size()==2);
	}
	
	@Test
	public void testDeleteBase() {
		BaseManager manager = context.getBean(BaseManagerImpl.class);
		String id = "8a5e9d4064ef25260164ef2528b50000";
		manager.deleteBase(id);
		Assert.assertTrue(manager.findAllBases().size()==1);
	}
	
	
}
