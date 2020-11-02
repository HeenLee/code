package com.li.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Demo6_Map {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("name", "jack");
		map.put("age", "18");
		map.put("score", "98");
		map.put("school", "beida");
		System.out.println(map);
		System.out.println(map.get("age"));
		
		//通过keySet集合、iterator()进行遍历
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key + "=" + map.get(key));
		}
		System.out.println("--------------");
		for (String key : map.keySet()) {
			System.out.println(key + "=" + map.get(key));
		}
		
		System.out.println("****************************");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry);
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		Set<Map.Entry<String, String>> entry = map.entrySet();
		Iterator<Map.Entry<String, String>> it2 = entry.iterator();
		while(it2.hasNext()){
			Entry<String,String> entrys = it2.next();
			System.out.println("&&&&&&&&&&&");
			System.out.println(entrys);
			System.out.println(entrys.getKey());
			System.out.println(entrys.getValue());
		}
		
		
		
	}

}
