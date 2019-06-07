package com.ghost.basics.mapAndCollect;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FlatMapExample {

	public static void main(String[] args) {

		List<Employee> empList = Arrays.asList(new Employee("sham"), new Employee("Kshitij"), new Employee("pooja"),
				new Employee("karan"), new Employee("hitler"));

		// print the luckyNos
		empList.stream().map(emp -> emp.getLuckyNos()).forEach(System.out::println);

		// get a specific LUcky no Form the list
		// flatMap takes strem add return a stream
		Optional<String> findAny = empList.stream()
							.map(emp -> emp.getLuckyNos().stream()  )
							.flatMap(strStream -> strStream.filter(luckyNo -> luckyNo.equals("105"))    )
							.findAny();
		System.out.println(findAny);
		
		
		// test form my side 
		// not working 
		/* Optional<Stream<String>> findAny = empList.stream()
				 .map(emp -> emp.getLuckyNos().stream()).
				 map(strStream ->  strStream .filter(no -> no.equals("105")))
				 .findAny();
		 
		 System.out.println(findAny.get());
*/	}

}

class Employee {

	private String name;
	private Set<String> luckyNos;

	public Set<String> convertNameToLuckyNo(String name) {
		Set<String> luckyNos = new HashSet<String>();

		for (int i = 0; i < name.length(); i++) {
			luckyNos.add((int) name.charAt(i) + "");
		}
		// System.out.println(luckyNos);
		return luckyNos;
	}

	public Employee(String name) {
		this.name = name;
		this.luckyNos = convertNameToLuckyNo(name);
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", luckyNos=" + luckyNos + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getLuckyNos() {
		return luckyNos;
	}

	public void setLuckyNos(Set<String> luckyNos) {
		this.luckyNos = luckyNos;
	}

}
