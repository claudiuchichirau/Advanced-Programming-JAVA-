package laborator_4.homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the Faker class to generate fake names
        Faker faker = new Faker();

        // Create a list of students with projects
        List<Student> students = Stream.of(
                new Student(faker.name().fullName(), Arrays.asList(new Project("P0"), new Project("P1"), new Project("P2"))),
                new Student(faker.name().fullName(), Arrays.asList(new Project("P0"), new Project("P1"),  new Project("P3"),  new Project("P4"))),
                new Student(faker.name().fullName(), Arrays.asList(new Project("P0"),  new Project("P3"))),
                new Student(faker.name().fullName(), Arrays.asList(new Project("P2")))
        ).sorted().collect(Collectors.toList());

        // Create a set of projects
        Set<Project> projects = Stream.of(
                new Project("P0"), new Project("P1"), new Project("P2"),
                new Project("P3"), new Project("P4")
        ).sorted().collect(Collectors.toCollection(LinkedHashSet::new));

        // Create an instance of the ProjectDistribution class to manage the distribution of projects
        ProjectsDistribution distribution = new ProjectsDistribution(students, projects);

        System.out.println("Students: ");
        // Print the names of all students sorted by their names.
        students.stream().forEach(s -> System.out.println(s));

        System.out.println("\nProjects: ");
        // Print the names of all projects sorted by their names.
        projects.stream().forEach(s -> System.out.println(s.getName()));

        // Print the names of students that have a number of preferences lower than the average number of preferences
        System.out.println("\nStudents that have a number of preferences lower than the average number of preferences: ");
        double averageNumberPreference = distribution.getStudents().stream()
                .mapToInt(s -> s.getAcceptedProjects().size())
                .average().orElse(0.0);

        List<Student> studentsWithFewerPreferences = distribution.getStudents().stream()
                .filter(s -> s.getAcceptedProjects().size() < averageNumberPreference)
                .collect(Collectors.toList());

        studentsWithFewerPreferences.forEach(s -> System.out.println(s.getName()));

        // Distribute the projects among the students
        System.out.println("\nProjects Distribution:");
        Map<Student, Project> projectOccupancy = distribution.distributionProject(students, projects);
    }
}