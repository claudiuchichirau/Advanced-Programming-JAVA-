package org.example;

import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.alg.matching.HopcroftKarpMaximumMatching;
import org.graph4j.util.Matching;
import org.graph4j.util.VertexSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

 // Clasa in care folosesc cei 3 algoritmi (MaximumCardinalityMatching,
 // MaximumCardinalitySet, MinimumCardinalitySet), folosindu-ma de biblioteca Graph4J
public class Graph4JAlgorithms
{
    private Graph g;
    private int numberStudents;
    private int numberProjects;
    private List<Student> students;
    private List<Project> projects;

    // Constructorul clasei Graph4JAlgorithms
    // Pentru un set de studenti si proiecte, creez un graf
    public Graph4JAlgorithms(List<Student> students, Set<Project> projectsSet)
    {
        this.students=students;
        List<Project> projects = new ArrayList<>();
        for (Project project : projectsSet)
        {
            if (!projects.contains(project))
            {
                projects.add(project);
            }
        }
        this.projects=projects;
        numberStudents=students.size();
        numberProjects=projects.size();
        g = GraphBuilder.numVertices(numberProjects+numberStudents).named("Graf").buildGraph();
        for(int i=0; i<numberStudents; i++)
        {
            Set<Project> projectsStudent = students.get(i).getProjects();
            for(Project p : projectsStudent)
            {
                int j = projects.indexOf(p);
                g.addEdge(i, j+numberStudents);
            }
        }
    }

    // Gasesc MaximumCardinalityMatching, folosindu-ma de HopcroftKarpMaximumMatching, metoda
    // getMatching(), din biblioteca Graph4J
    public void findMaximumCardinalityMatching ()
    {
        HopcroftKarpMaximumMatching h = new HopcroftKarpMaximumMatching(g);
        Matching m= h.getMatching();
        int matrix[][] = m.edges();
        for (int i=0; i<matrix.length; i++)
        {
            System.out.print(students.get(matrix[i][0]).getName() + " - <" + projects.get(matrix[i][1]-numberStudents).getName() + ">; ");
        }
        System.out.println("");
    }

    // Gasesc MaximumCardinalitySet, folosindu-ma de HopcroftKarpMaximumMatching, metoda
    // getMaximumStableSet(), din biblioteca Graph4J
    public void findMaximumCardinalitySet()
    {
        HopcroftKarpMaximumMatching h = new HopcroftKarpMaximumMatching(g);
        VertexSet m = h.getMaximumStableSet();
        int vertex[] = m.vertices();
        int numberVertices = m.numVertices();
        for (int i=0; i<numberVertices; i++)
        {
            if(vertex[i]<numberStudents)
            {
                System.out.print(students.get(vertex[i]).getName() + "; ");
            }
            else
            {
                System.out.print(projects.get(vertex[i]-numberStudents).getName() + "; ");
            }
        }
        System.out.println("");
    }

    // Gasesc MinimumCardinalitySet, folosindu-ma de HopcroftKarpMaximumMatching, metoda
    // getMinimumStableSet(), din biblioteca Graph4J

    public void findMinimumCardinalitySet()
    {
        HopcroftKarpMaximumMatching h = new HopcroftKarpMaximumMatching(g);
        VertexSet m = h.getMinimumVertexCover();
        int vertex[] = m.vertices();
        int numberVertices = m.numVertices();
        for (int i=0; i<numberVertices; i++)
        {
            if(vertex[i]<numberStudents)
            {
                System.out.print(students.get(vertex[i]).getName() + "; ");
            }
            else
            {
                System.out.print(projects.get(vertex[i]-numberStudents).getName() + "; ");
            }
        }
        System.out.println("");
    }
}
