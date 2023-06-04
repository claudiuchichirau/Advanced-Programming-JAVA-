package org.example;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        // generez studenti si proiecte fake
        Faker faker = new Faker();
        //generez 1500 studenti (pentru fiecare numele si o lista de proiecte)
        //dupa care colectez studentii generati intr-o lista
        List<Student> fakeStudents = Stream.generate(() -> new Student(faker.name().fullName(), generateProjects(faker))).limit(1500).collect(Collectors.toList());
        Set<Project> fakeProjects = fakeStudents.stream().flatMap(student -> student.getProjects().stream()).collect(Collectors.toSet());

        // creez o instanta a problemei cu datele generate aleator
        JGraphTAlgorithms m1 = new JGraphTAlgorithms(fakeStudents, fakeProjects);
        Graph4JAlgorithms m2 = new Graph4JAlgorithms(fakeStudents, fakeProjects);

        System.out.println("Result MaximumCardinalityMatching - JGraphT:");
        long startTime1 = System.currentTimeMillis();
        m1.findMaximumCardinalityMatching();
        long endTime1 = System.currentTimeMillis();
        long startTime2 = System.currentTimeMillis();
        System.out.println("\nResult MaximumCardinalityMatching - Graph4J:");
        m2.findMaximumCardinalityMatching();
        long endTime2 = System.currentTimeMillis();

        long startTime3 = System.currentTimeMillis();
        MatchingProblemGreedy fakeProblem = new MatchingProblemGreedy(fakeStudents, fakeProjects);
        // creez perechi student-profesor, folosind greedy
        Set<Map.Entry<Student, Project>> fakeMatching = fakeProblem.generateMatching();
        System.out.println("\nResult MaximumCardinalityMatching - Greedy:");
        fakeMatching.forEach(entry -> System.out.print(entry.getKey().getName() + "-" + entry.getValue().getName() + "; "));
        long endTime3 = System.currentTimeMillis();
        System.out.println("");

        long totalTime1 = endTime1 - startTime1;
        long totalTime2 = endTime2 - startTime2;
        long totalTime3 = endTime3 - startTime3;
        System.out.println("\nRunning time MaximumCardinalityMatching - JGraphT: " + totalTime1 + " milliseconds");
        System.out.println("\nRunning time MaximumCardinalityMatching - Graph4J: " + totalTime2 + " milliseconds");
        System.out.println("\nRunning time MaximumCardinalityMatching - Greedy: " + totalTime3 + " milliseconds");

        System.out.println("\nResult MaximumCardinalitySet - JGraphT:");
        startTime1 = System.currentTimeMillis();
        m1.findMaximumCardinalitySet();
        endTime1 = System.currentTimeMillis();
        System.out.println("\nResult MaximumCardinalitySet - Graph4J:");
        startTime2 = System.currentTimeMillis();
        m2.findMaximumCardinalitySet();
        endTime2 = System.currentTimeMillis();

        totalTime1 = endTime1 - startTime1;
        totalTime2 = endTime2 - startTime2;
        System.out.println("\nRunning time MaximumCardinalitySet - JGraphT: " + totalTime1 + " milliseconds");
        System.out.println("\nRunning time MaximumCardinalitySet - Graph4J: " + totalTime2 + " milliseconds");

        System.out.println("\nResult MinimumCardinalitySet - JGraphT:");
        startTime1 = System.currentTimeMillis();
        m1.findMinimumCardinalitySet();
        endTime1 = System.currentTimeMillis();
        System.out.println("\nResult MinimumCardinalitySet - Graph4J:");
        startTime2 = System.currentTimeMillis();
        m2.findMinimumCardinalitySet();
        endTime2 = System.currentTimeMillis();

        totalTime1 = endTime1 - startTime1;
        totalTime2 = endTime2 - startTime2;
        System.out.println("\nRunning time MinimumCardinalitySet - JGraphT: " + totalTime1 + " milliseconds");
        System.out.println("\nRunning time MinimumCardinalitySet - Graph4J: " + totalTime2 + " milliseconds");
    }

     // Genereaza proiecte fake pentru un student, un proiect nu poate aparea de doua ori la acelasi student.
    private static Set<Project> generateProjects(Faker faker)
    {
        Set<Project> generatedProjects = new HashSet<>();
        while (generatedProjects.size() < 1000)
        {
            String projectName = faker.name().firstName();
            Project newProject = new Project(projectName);
            if (!generatedProjects.contains(newProject))
            {
                generatedProjects.add(newProject);
            }
        }
        return generatedProjects;
    }
}