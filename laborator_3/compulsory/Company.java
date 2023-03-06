package laborator_3.compulsory;

import java.util.ArrayList;

public class Company implements Node, Comparable<Company>{
    private String name;
    private ArrayList<Person> employees;

    public Company(String name){
        this.name = name;
        employees = new ArrayList<Person>();
    }

    public void hire(Person p) {
        employees.add(p);
    }

    public ArrayList<Person> getEmployees() {
        return employees;
    }

    @Override
    public int compareTo(Company company) {
        return name.compareTo((company.getName()));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company: name='").append(name).append("', employees={");
        for (int i = 0; i < employees.size(); i++) {
            sb.append(employees.get(i).getName());
            if (i != employees.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }


}
