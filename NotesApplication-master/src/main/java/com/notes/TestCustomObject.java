package com.notes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCustomObject {

	public static void main(String[] args) {

		// create a list of Student objects
		List<Student> studentList = new ArrayList<>();

		// add student object to List
		studentList.add(new Student(1, "Arun", 67.36, 2));
		studentList.add(new Student(2, "Sethu", 88.58, 1));
		studentList.add(new Student(3, "Ajith", 55.74, 4));
		studentList.add(new Student(4, "Vikcy", 61.32, 3));
		studentList.add(new Student(1, "Arun", 67.36, 2)); // duplicate Arun

		// pretty print
		System.out.println("1. Original Student list with duplicates :\n");
		studentList.forEach(student -> System.out.println(student));

		// Java 8 - Collector.toCollection()
		Set<Student> uniqueStudentSet = studentList.stream() // get stream for original list
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getId)))// Id comparison
				);

		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("Awakens", 8.3, 2015));
		list.add(new Movie("Wars", 8.7, 2014));
		list.add(new Movie("Back", 8.8, 2012));
		list.add(new Movie("Return", 8.4, 1983));
		list.add(new Movie("Return", 8.4, 1983));
		System.out.println("TestCustomObject.main(------------------------------------)"+list.size());
		
		Set<Movie> movieSet= list.stream().collect(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(Movie::getName))));
		System.out.println("TestCustomObject.main(------------------------------------)"+movieSet.size());
		
		movieSet.forEach(item -> System.out.println(movieSet));
		 
		System.out.println("TestCustomObject.main(------------------------------------)");
		
		Stream<Movie> list1 =	list.stream()
                .sorted(Comparator.comparing(Movie::getName)
               // .thenComparing(Movie::getRating)
                .thenComparing(Movie::getYear));
		list1.forEach(System.out::println);
		
		
		Set<Student> uniqueStudentSet11 = studentList.stream() // get stream for original list
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getId).thenComparing(Student::getName)))// Id comparison
				);
		
		System.out.println("TestCustomObject.main(----uniqueStudentSet11uniqueStudentSet11----------)"+uniqueStudentSet11.toString());
		
		// pretty print
		System.out.println("\n2. New SET with unique Student objects" + " in natural order of Id :\n");
		uniqueStudentSet.forEach(uniqueStudent -> System.out.println(uniqueStudent));

		// Java 8 - sorting in ascending order of Student's Rank
		List<Student> sortedList = uniqueStudentSet.stream() // get stream for unique SET
				.sorted(Comparator.comparing(Student::getRank)) // rank comparing
				.collect(Collectors.toList()); // elements are stored to new list

		// pretty print
		System.out.println("\n3. Sorted according to ascending order" + " of Student's Rank :\n");
		sortedList.forEach(sortedStudent -> System.out.println(sortedStudent));
	}
}