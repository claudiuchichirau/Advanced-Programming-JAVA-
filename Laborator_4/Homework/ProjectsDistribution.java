package laborator_4.homework;

import java.util.*;
import java.util.stream.Collectors;

public class ProjectsDistribution {
    private List<Student> students;
    private Set<Project> projects;

    public ProjectsDistribution(List<Student> students, Set<Project> projects){
        this.students = students;
        this.projects = projects;
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }

    public List<Student> getStudents(){
        return students;
    }

    public void setProjects(Set<Project> projects){
        this.projects = projects;
    }

    public Set<Project> getProjects(){
        return projects;
    }

    public static Map<Student, Project> distributionProject (List<Student> students, Set<Project> projects){
        Map<Student, Project> projectOccupancy = new HashMap<>(); // studentul si proiectul asignat

        // Sort the list of students in ascending order of the number of accepted projects
        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparingInt(s -> s.getAcceptedProjects().size()))
                .collect(Collectors.toList());

        // Initialize a list of available projects
        List<Project> availableProjects = new ArrayList<>(projects);

        // Assign projects to students using a greedy algorithm
        for (Student student : sortedStudents) {
            for (Project project : student.getAcceptedProjects()) {
                if (availableProjects.contains(project) == true) {
                    projectOccupancy.put(student, project);
                    availableProjects.remove(project);
                    System.out.println("\t - " + student.getName() + " has been assigned to " + project.getName());
                    break;
                }
            }
        }
        return projectOccupancy;
    }
}
