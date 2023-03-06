package laborator_3.compulsory;

public class Person implements Node, Comparable<Person>{
    private String name;
    private SpecializationType type;

    enum SpecializationType{
        Programmer, Designer
    }

    public Person(String name, SpecializationType type){
        this.name = name;
        this.type = type;
    }

    public SpecializationType getSpecializationType(){
        return type;
    }

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.getName());
    }

    @Override
    public String getName() {
        return name;
    }
}
