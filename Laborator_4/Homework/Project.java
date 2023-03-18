package laborator_4.homework;


import java.util.Objects;

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
        return this.name.compareTo(proj.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Project)) {
            return false;
        }
        Project other = (Project) obj;
        return Objects.equals(this.name, other.name);
    }
}