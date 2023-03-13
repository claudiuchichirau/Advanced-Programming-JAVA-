package laborator_3.homework;

import java.util.*;

public class Network<T extends Node> {
    private List<T> nodes;

    public Network() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(T node) {
        this.nodes.add(node);
    }

    public void removeNode(T node) {
        this.nodes.remove(node);
    }

    public List<Node> getNodes() {
        List<Node> nodesList = new ArrayList<>();
        nodesList.addAll(nodes);
        return nodesList;
    }

    public Map<Object, Integer> countRelationships() {
        // Create a new HashMap to store the relationship counts for each node
        Map<Object, Integer> relationshipCount = new HashMap<>();

        for (Node node : nodes) {
            // If the node is a Person, count their relationships
            if (node instanceof Person) {
                Person person = (Person) node;
                Map<Object, Person.RelationshipType> relationships = person.getRelationships();
                relationshipCount.put(person, relationships.size());
            } // If the node is a Company, count their relationships
            else if (node instanceof Company) {
                Company company = (Company) node;
                Map<Object, Company.RelationshipType> relationships = company.getRelationships();
                relationshipCount.put(company, relationships.size());
            }
        }
        return relationshipCount;
    }

    @Override
    public String toString() {
        // Get the relationship counts for all nodes in the graph
        Map<Object, Integer> relationshipCount = countRelationships();

        // Sort the map entries in descending order by value
        List<Map.Entry<Object, Integer>> sortedEntries = new ArrayList<>(relationshipCount.entrySet());
        sortedEntries.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        // Build a sorted string representation of the graph
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Object, Integer> entry : sortedEntries) {
            // If the node is a Person, add their name and birthdate
            if (entry.getKey() instanceof Person) {
                Person person = (Person) entry.getKey();

                sb.append("[People]: " + person.getName() + ", born on " + person.getDateOfBirth() + "\n");
                // Append relationships for this person
                sb.append("      Relationships: " + person.getRelationships() + "\n\n");
            } // If the node is a Company, add their name
            else if (entry.getKey() instanceof Company) {
                Company company = (Company) entry.getKey();
                // Append relationships for this company
                sb.append("[Company]: " + company.getName() + "\n" + "      Relationships: " + company.getRelationships()).append("\n\n");
            }
        }
        return sb.toString();
    }
}
