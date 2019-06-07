package com.ghost.basics.mapAndCollect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapExample {

	class Student {

		int age;
		String name;

		public Student(String name) {
			super();
			this.age = name.length() + 20;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Student [age=" + age + ", name=" + name + "]";
		}

	}

	public static void main(String[] args) {

		List<String> list = Arrays.asList("ram", "sham", "dhram", "veer");
		System.out.println("list is --- > " + list);
		System.out.println("-----------------------");

		System.out.println("maping is performedon the list");
		// the list is not changed in this case we only changed the list temporaly in
		// stream
		list.stream().map(name -> new StreamMapExample().new Student(name))
				.forEach(Student -> System.out.println(Student));
		/*
		 * maps are used to tranforn one object to anthor ....
		 */
		System.out.println("list is --- > " + list);

		/*
		 * if you wna to chnage the list u have to store the list in to varriavle ans
		 * use it
		 */

		// collect is used to create a new collection
		List<Student> list2 = list.stream().map(name -> new StreamMapExample().new Student(name))
				.collect(Collectors.toList());
		System.out.println(list2);

		// exaxple for few mwhtods of stream
		
		int sumAllAgesInLIst = list2.stream().mapToInt(student -> student.age ).sum();
		System.out.println(sumAllAgesInLIst);

	}

}
