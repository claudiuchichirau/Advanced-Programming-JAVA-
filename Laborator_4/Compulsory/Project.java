package org.example;

public class Project implements Comparable<Project>{
    private String name;

    public Project(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Project proj) {
        return this.name.compareTo(proj.name);
    }
}
