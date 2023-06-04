package org.example;

import org.jgrapht.Graph;
import org.jgrapht.alg.vertexcover.GreedyVCImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import java.util.*;
import java.util.HashSet;
import java.util.Set;
import org.jgrapht.alg.matching.DenseEdmondsMaximumCardinalityMatching;


 // Clasa in care folosesc cei 3 algoritmi (MaximumCardinalityMatching,
 // MaximumCardinalitySet, MinimumCardinalitySet), folosindu-ma de biblioteca JGraphT
public class JGraphTAlgorithms
{
    private Graph g;
    private int numberStudents;
    private int numberProjects;
    private List<Student> students;
    private List<Project> projects;

    public JGraphTAlgorithms(List<Student> students, Set<Project> projectsSet)
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
        g = new SimpleGraph<>(DefaultEdge.class);
        for(int i=0; i<numberStudents+numberProjects; i++)
        {
            g.addVertex(i);
        }
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

    // Gasesc MaximumCardinalityMatching, folosindu-ma de DenseEdmondsMaximumCardinalityMatching
    public void findMaximumCardinalityMatching ()
    {
        DenseEdmondsMaximumCardinalityMatching<Integer, DefaultEdge> matching = new DenseEdmondsMaximumCardinalityMatching<>(g);
        Set<DefaultEdge> edges = matching.getMatching().getEdges();
        for (DefaultEdge edge : edges)
        {
            System.out.print(students.get(Integer.valueOf(g.getEdgeSource(edge).toString())).getName() + " - <" + projects.get(Integer.valueOf(g.getEdgeTarget(edge).toString())-numberStudents).getName() + ">; ");
        }
        System.out.println("");
    }

    // Gasesc MaximumCardinalitySet, folosindu-ma de GreedyVCImpl din biblioteca JGraphT
    public void findMaximumCardinalitySet()
    {
        //gasesc minimul vertex cover
        GreedyVCImpl<Integer, DefaultEdge> algorithm = new GreedyVCImpl<>(g);
        Set<Integer> vertexCover = algorithm.getVertexCover();
        //maxim cardinality set
        Set<Integer> maxCardinalitySet = new HashSet<>(g.vertexSet()); //creez un nou set
        maxCardinalitySet.removeAll(vertexCover); //sterg elementele din noul set
        for (int vertex : maxCardinalitySet)
        {
            if(vertex<numberStudents)
            {
                System.out.print(students.get(vertex).getName() + "; ");
            }
            else
            {
                System.out.print(projects.get(vertex-numberStudents).getName() + "; ");
            }
        }
        System.out.println("");
    }

    //  Gasesc MinimumCardinalitySet, folosindu-ma de GreedyVCImpl din biblioteca JGraphT
    public void findMinimumCardinalitySet()
    {
        //minimum vertex cover
        GreedyVCImpl<Integer, DefaultEdge> vc = new GreedyVCImpl<>(g);
        Set<Integer> vertexCover = vc.getVertexCover();
        for (int vertex : vertexCover)
        {
            if(vertex<numberStudents)
            {
                System.out.print(students.get(vertex).getName() + "; ");
            }
            else
            {
                System.out.print(projects.get(vertex-numberStudents).getName() + "; ");
            }
        }
        System.out.println("");
    }
}
