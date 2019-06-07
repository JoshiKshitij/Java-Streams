package com.ghost.basics.gropByAndPartionBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.ghost.basics.Person;

public class GroupByExample {
	public static void main(String[] args) {
		List<Person> listOfPeople = Arrays.asList(new Person(32, "Kartik", "0"), new Person(26, "Kshitij", "1"),
				new Person(26, "Pooja", "1"), new Person(32, "Hina", "0"), new Person(100, "yumraaj", "0"),
				new Person(72, "gandhi", "1"), new Person(18, "kiran", "0"));

		// partitionBY methos is from Collectors Class NOT the Interface
		// System.out.println(listOfPeople.stream().collect(Collectors.partitioningBy(person->
		// person.getStatus().equals("1"))));

		Map<Boolean, List<Person>> collect = listOfPeople.stream()
				.collect(Collectors.groupingBy(person -> person.getStatus().equals("1")));

		collect.entrySet().stream().forEach((Entry<Boolean, List<Person>> t) -> System.out
				.println("Key is " + t.getKey() + " and value is " + t.getValue()));

		// if i have to grou p by age then i can go for
		System.out.println("-------------------------------------------------------");
		// for counting Collcetors has a method count
		System.out.println(
				listOfPeople.stream().collect(Collectors.groupingBy(person -> person.getAge(), Collectors.counting())));

		// if i have to grou p by age then i can go for
		System.out.println("-------------------------------------------------------");
		// for counting Collcetors has a method count
		listOfPeople.stream().collect(Collectors.groupingBy(person -> person.getAge())).entrySet().stream()
				.forEach( en -> System.out.println(en));
	}

}
