package com.ghost.basics.filters;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("ram","sham", "dhram" ,"veer");
/*
	filter will take predicate which will return boolean result
	
	foreach will take consunter  which will return void
		
*/		
		list.stream().filter(name -> name.length() > 3 ).forEach((name)->System.out.println(name));
			
	}

}
