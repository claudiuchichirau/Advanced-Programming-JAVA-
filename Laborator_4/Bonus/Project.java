package org.example;

import java.util.Objects;

// Reprezinta un proiect, care poate fi comparat cu alt proiect

public class Project implements Comparable<Project>
{
    private final String name;

    public Project(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    // Verifica daca proiectul curent are acelasi nume cu alt proiect, transmis ca parametru prin p2
    @Override
    public int compareTo(Project p2)
    {
        return name.compareTo(p2.getName());
    }

    // Verifica daca doua proiecte sunt egale.
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Project project = (Project) obj;
        return Objects.equals(name, project.name);
    }

    // Returneaza detaliile despre un proiect (numele sau).
    @Override
    public String toString()
    {
        return ("Proiectul: " +name);
    }
}
