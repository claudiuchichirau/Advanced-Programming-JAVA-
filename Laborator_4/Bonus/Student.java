package org.example;

import java.util.Set;

// Reprezinta un student, care poate fi comparat cu alt student

class Student implements Comparable<Student>
{
    private final String name;
    private final Set<Project> hasThisProjects;

    public Student(String name, Set<Project> hasThisProjects)
    {
        this.name = name;
        this.hasThisProjects = hasThisProjects;
    }

    public String getName()
    {
        return name;
    }

    public Set<Project> getProjects()
    {
        return hasThisProjects;
    }

    // Verifica daca studentul curent are acelasi nume cu alt student, transmis ca parametru prin s2
    @Override
    public int compareTo(Student s2)
    {
        return this.name.compareTo(s2.name);
    }

    @Override
    public String toString()
    {
        return "Student: " + "name='" + name + '\'' + ", hasThisProjects=" + hasThisProjects;
    }
}