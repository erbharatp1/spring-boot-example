package com.notes;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;

public class JavaBuiltInComparatorEx2 {

    public static void main(String[] args) {

        var p1 = new Person("Robert", LocalDate.of(2008, 8, 21));
        var p2 = new Person("Monika", LocalDate.of(2008, 10, 5));
        var p3 = new Person("Tom", LocalDate.of(1977, 11, 30));
        var p4 = new Person("Elisabeth", LocalDate.of(2004, 8, 30));

        var persons = List.of(p1, p2, p3, p4 );

        var sorted = persons.stream()
                .sorted(Comparator.comparingInt(Person::age));
        sorted.forEach(System.out::println);
    }

    record Person(String name, LocalDate dateOfBirth) {

        public int age() {

            return Period.between(dateOfBirth(), LocalDate.now()).getYears();
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("name='").append(name()).append('\'');
            sb.append(", age=").append(age());
            sb.append('}');
            return sb.toString();
        }
    }
}