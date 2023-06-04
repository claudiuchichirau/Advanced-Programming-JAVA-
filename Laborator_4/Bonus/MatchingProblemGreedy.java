package org.example;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Comparator;
import java.util.AbstractMap;
import java.util.HashSet;

class MatchingProblemGreedy
{
    private final List<Student> students;
    private final Set<Project> projects;

    public MatchingProblemGreedy(List<Student> students, Set<Project> projects)
    {
        this.students = students;
        this.projects = projects;
    }

    // Returneaza studentii care au numarul de preferinte mai mic decat valoarea primita prin parametrul numberOfPreferences
    public List<Student> studentsNumberOfPreferencesLower(double numberOfPreferences)
    {
        return students.stream().filter(s -> s.getProjects().size() < numberOfPreferences).collect(Collectors.toList());
    }

    // Algoritmul Greedy prin care atribui fiecarui student cate un singur proiect

    public Set<Map.Entry<Student, Project>> generateMatching()
    {
        Set<Map.Entry<Student, Project>> matchingStudentProiect = new HashSet<>(); //setul de perechi student-proiect
        Set<Project> projects2 = new HashSet<>(projects); //copie a proiectelor
        //initiem un flux de studenti, pe care ii sortam crescator dupa cate proiecte sunt atribuite fiecaruia
        //parcurgem studentii obtinuti anterior cu forEach
        students.stream().sorted(Comparator.comparingInt(s -> s.getProjects().size())).forEach(student ->
        {
            //pentru fiecare student
            Set<Project> hasThisProjects = student.getProjects(); //proiectele studentului
            Project projectForStudent = null;
            for (Project project : hasThisProjects) //parcurgem proiectele studentului
            {
                if (projects2.contains(project)) //daca a ramas unul din ele disponibil, i-l atribuim
                {
                    projectForStudent = project;
                    break;
                }
            }
            if (projectForStudent != null) //daca am reusit sa ii atribuim un proiect
            {
                matchingStudentProiect.add(new AbstractMap.SimpleEntry<>(student, projectForStudent)); //creez o pereche student - proiect, pe care o adaug in lista
                projects2.remove(projectForStudent); //elimin proiectul atribuit, pentru a nu mai putea fi atribuit si altei persoane
            }
        });
        return matchingStudentProiect; //returnez perechile student-proiect obtinute
    }
}
