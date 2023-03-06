package laborator_3.compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an object of the "SocialNetwork" class
        SocialNetwork socialNetwork = new SocialNetwork();

        // Create three objects of the "Person" class
        Person person1 = new Person("Claudiu Chichirau", Person.SpecializationType.Designer);
        Person person2 = new Person("Matei Peltea", Person.SpecializationType.Programmer);
        Person person3 = new Person("Gabriel Ciubotariu", Person.SpecializationType.Programmer);

        // Create two objects of the "Company" class
        Company company1 = new Company("Apple");
        Company company2 = new Company("Amazon");

        // Add the first two people as employed in the company1 and person3 in company2
        company1.hire(person1);
        company1.hire(person2);
        company2.hire(person3);

        System.out.println(company1);
        System.out.println(company2);

        // add three objects of type "Person" and two objects of type "Company" to the object "socialNetwork"
        // of type "SocialNetwork" by means of the "addPerson" and "addCompany" methods.
        socialNetwork.addPerson(person1);
        socialNetwork.addPerson(person2);
        socialNetwork.addPerson(person3);
        socialNetwork.addCompany(company1);
        socialNetwork.addCompany(company2);

        List<Node> nodes = socialNetwork.getNodes();
        // Collections.sort(nodes);

        for (Node node : nodes) {
            System.out.println(node.getName());
        }
    }

}
