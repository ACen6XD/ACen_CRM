package com.crm.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crm.basedict.domain.BaseDict;
import com.crm.basedict.service.BaseDictService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BaseDictTest {
	@Resource(name="baseDictService")
	BaseDictService baseDictService;
	
	@Test
	public void demo1(){
		BaseDict baseDict = baseDictService.findById("1");
		System.out.println(baseDict.getDict_item_name());
	}
	
	@Test
	public void demo2(){
		List<BaseDict> list = baseDictService.findByTypeCode("4");
		for (BaseDict baseDict : list) {
			System.out.println(baseDict.getDict_item_name());
		}
	}
	
	@Test
	public void demo3(){
		List<String> b = baseDictService.findAllTypeName();
		for (String baseDict : b) {
			System.out.println(baseDict);
		}
	}
}
