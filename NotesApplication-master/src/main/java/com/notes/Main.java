package com.notes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) {
		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("Awakens", 8.3, 2015));
		list.add(new Movie("Wars", 8.7, 2014));
		list.add(new Movie("Back", 8.8, 2012));
		list.add(new Movie("Return", 8.4, 1983));
		list.add(new Movie("Return", 8.4, 1983));

//		Collections.sort(list);
//
//		// System.out.println("Movies after sorting : ");
//		for (Movie movie : list) {
//			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
//		}

		list.stream().distinct().collect(Collectors.toList());
		Set<Movie> sortedList = list.stream().distinct()
				.sorted(Comparator.comparingInt(Movie::getYear).reversed())
				.collect(Collectors.toSet());

//		List<Movie> unique = list.stream()
//                .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingInt(Employee::getId))),
//                                           ArrayList::new));
//		
		Set<Movie> uniqueSet = list
                .stream() // get stream for original list
                .collect(Collectors.toSet());
		uniqueSet.forEach(System.out::println);
		System.out.println("Main.main()-------------------------");
		sortedList.forEach(System.out::println);
	}
}
