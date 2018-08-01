package pers.johngao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pers.johngao.pojo.Item;
import pers.johngao.service.ItemManager;

@RestController
@RequestMapping(value="/item")
public class ItemController {
	@Autowired
	private ItemManager manager;
	
	@RequestMapping(method=RequestMethod.POST)
	public Item addItem(@RequestBody Item b,String baseId) {
		return manager.registItem(b,baseId);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Item updateItem(@RequestBody Item b) {
		
		return manager.updateItem(b);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public String deleteItem(@PathVariable String id) {
		manager.deleteItem(id);
		return "{}";
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public List<Item> addItem(@PathVariable String id) {
		return manager.findAllItems(id);
	}
}
