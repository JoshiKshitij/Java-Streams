package com.ghost.basics.mapAndCollect;

import java.util.Arrays;
import java.util.List;

import com.ghost.basics.Person;

public class PersonExample {

	public static void main(String[] args) {
		List<Person> listOfPeople = Arrays.asList(new Person(32, "Kartik", "0"), new Person(26, "Kshitij", "1"),
				new Person(26, "Pooja", "1"), new Person(32, "Hina", "0"));

		// this will print person object who is married
		listOfPeople.stream().filter(p -> p.getStatus().equals("1")).forEach(p -> System.out.println(p));

		System.out.println("------------------------------------------");
		// map will used to convert the person object into String from stream
		listOfPeople.stream().filter(p -> p.getStatus().equals("1"))
				.map(person -> "id " + person.getAge() + " name " + person.getName())
				.forEach(p -> System.out.println(p));

		System.out.println("------------------------------------------");
		
		
	}

}
