package pers.johngao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pers.johngao.pojo.Base;
import pers.johngao.service.BaseManager;


@RestController
@RequestMapping(value="/base")
public class BaseController {
	@Autowired
	private BaseManager manager;
	
	@RequestMapping(method=RequestMethod.POST)
	public Base addBase(@RequestBody Base b) {
		return manager.registBase(b);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Base updateBase(@RequestBody Base b) {
		
		return manager.updateBase(b);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public String deleteBase(@PathVariable String id) {
		manager.deleteBase(id);
		return "{}";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Base> addBase() {
		return manager.findAllBases();
	}
}
