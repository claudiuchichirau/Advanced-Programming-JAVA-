package laborator_3.compulsory;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Person> persons;
    private List<Company> companies;

    public SocialNetwork(){
        persons = new ArrayList<>();
        companies = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public List<Node> getNodes() {
        List<Node> nodes = new ArrayList<>();
        nodes.addAll(persons);
        nodes.addAll(companies);
        return nodes;
    }
}
