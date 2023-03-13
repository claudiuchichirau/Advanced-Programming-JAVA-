package org.example;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Create a list of students with projects
        List<Student> students = Stream.of(
                new Student("S0", Arrays.asList(new Project("P0"), new Project("P1"), new Project("P2"))),
                new Student("S1", Arrays.asList(new Project("P0"), new Project("P1"))),
                new Student("S2", Arrays.asList(new Project("P0")))
        ).sorted().collect(Collectors.toList());

        // Create a set of projects
        Set<Project> projects = Stream.of(
                new Project("P0"),
                new Project("P1"),
                new Project("P2")
        ).sorted().collect(Collectors.toCollection(LinkedHashSet::new));

        // Print the names of all students sorted by their names.
        students.stream().map(Student::getName).forEach(System.out::println);

        // Print the names of all projects sorted by their names.
        projects.stream().map(Project::getName).forEach(System.out::println);
    }
}