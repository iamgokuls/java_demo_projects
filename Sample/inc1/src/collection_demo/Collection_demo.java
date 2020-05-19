package collection_demo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Collection_demo {

	public static void main(String[] args) {
		
		// list
		
		List<Integer> numbers=new ArrayList<>();
		
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(9);
		numbers.add(4);
		numbers.add(8);
		
		System.out.println(numbers);
		
		Collections.sort(numbers,Collections.reverseOrder());
		
		System.out.println(numbers);
		
		/*
		 * Iterator<Integer> it= numbers.iterator();
		 * 
		 * while(it.hasNext()) { System.out.print(it.next()); }
		 */
		
		// Set
		
		Set<Integer> num=new HashSet<>();
		num.add(4);
		num.add(6);
		num.add(1);
		num.add(3);
		num.add(8);
		System.out.println(num);

		//map
		Map<String,Integer> nos=new TreeMap<>();
		nos.put("one",1);
		nos.put("two",2);
		nos.put("four",4);
		
		System.out.println(nos);
		
		for(String name:nos.keySet()) {
			System.out.println(nos.get(name));
		}
	}

}
