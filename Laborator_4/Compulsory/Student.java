package org.example;

import java.util.List;

public class Student implements Comparable<Student>{
    private String name;
    private List<Project> acceptedProjects;

    public Student(String name, List<Project> acceptedProjects){
        this.name = name;
        this.acceptedProjects = acceptedProjects;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAcceptedProjects(List<Project> acceptedProjects){
        this.acceptedProjects = acceptedProjects;
    }

    public List<Project> getAcceptedProjects(){
        return this.acceptedProjects;
    }

    @Override
    public int compareTo(Student stud) {
        return this.name.compareTo(stud.name);
    }
}
