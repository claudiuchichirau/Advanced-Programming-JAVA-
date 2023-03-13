package laborator_3.homework;


public class Main {
    public static void main(String[] args) {
        // Create an object of the "Network" class
        Network network = new Network();

        // Create three objects of the "Person" class
        Designer claudiuChichirau = new Designer("Claudiu Chichirau", 30, 05, 2002, 34);
        Programmer mateiPeltea = new Programmer("Matei Peltea", 04, 12, 1990, 7);
        Programmer mihaiChichirau = new Programmer("Mihai Chichirau", 30, 10, 1995, 4);

        // Create two objects of the "Company" class
        Company apple = new Company("Apple");
        Company amazon = new Company("Amazon");

        // add three objects of type "Person" and two objects of type "Company" to the object "network"
        network.addNode(claudiuChichirau);
        network.addNode(mateiPeltea);
        network.addNode(mihaiChichirau);
        network.addNode(apple);
        network.addNode(amazon);

        apple.addRelationship(claudiuChichirau, Company.RelationshipType.MANAGER); // claudiuChichirau is employed as a MANAGER at the apple company
        apple.addRelationship(mateiPeltea, Company.RelationshipType.FINANCE); // mateiPeltea is employed in the FINANCE department at the apple company
        amazon.addRelationship(mihaiChichirau, Company.RelationshipType.HR); // mihaiChichirau is employed in the HR department at the amazon companyany

        // System.out.println(apple);  // toString -> apple
        // System.out.println(amazon);  // toString -> amazon

        claudiuChichirau.addRelationship(mateiPeltea, Person.RelationshipType.COLLEAGUE); // claudiuChichirau is a COLLEAGUE with mateiPeltea
        claudiuChichirau.addRelationship(mihaiChichirau, Person.RelationshipType.FAMILY);
        claudiuChichirau.addRelationship(apple, Person.RelationshipType.MANAGER);
        mateiPeltea.addRelationship(apple, Person.RelationshipType.FINANCE);

        System.out.println(network);
    }

}