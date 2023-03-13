package laborator_3.homework;

import java.util.HashMap;
import java.util.Map;

public class Company implements Node, Comparable{
    private String name;

    Map<Object, Company.RelationshipType> relationships;

    public enum RelationshipType {
        MANAGER, IT, HR, MARKETING, SALES, FINANCE // relationships between a person and a company
        ;
    }

    public Company(String name){
        this.name = name;
        this.relationships = new HashMap<>();
    }

    public void addRelationship(Object obj, RelationshipType type) {
        if (obj instanceof Person) {
            if(type == Company.RelationshipType.MANAGER || type == Company.RelationshipType.IT ||type == Company.RelationshipType.HR || type == Company.RelationshipType.MARKETING || type == Company.RelationshipType.SALES || type == Company.RelationshipType.FINANCE)
                this.relationships.put(obj, type);         // add the relationship from person x to company y            }
            else
                System.out.println("The type of relationship entered is not possible between a person and a company!");
        }
        else
            System.out.println("Invalid relationship object type.");
    }

    public Map<Object, RelationshipType> getRelationships() {
        Map<Object, RelationshipType> relationshipsMap = new HashMap<>();

        // Loop through the entries in the relationships map
        for (Map.Entry<Object, RelationshipType> entry : relationships.entrySet()) {
            Object obj = entry.getKey();
            RelationshipType type = entry.getValue();

            // If the key is an instance of Person
            if (obj instanceof Person) {

                // Cast the key to Person and add the name and relationship type to the relationships map
                relationshipsMap.put(((Person) obj).getName(), type);
            }
        }
        return relationshipsMap;
    }


    @Override
    public int compareTo(Object o) {
        if(o == null)
            throw new NullPointerException();
        if(!(o instanceof Person))
            throw new ClassCastException("Uncomparable objects!");
        Company comp = (Company) o;
        return this.name.compareTo(comp.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        int first = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("Company: name='").append(name).append("', Relationships:{");

        // Loop through each entry in the map of relationships
        for (Map.Entry<Object, Company.RelationshipType> entry : relationships.entrySet()) {
            Object obj = entry.getKey();
            Company.RelationshipType type = entry.getValue();
            Person pers = (Person) obj;

            // Check if this is the first entry being added to the StringBuilder
            if(first == 0)
            {
                sb.append(type.toString() + " relationship with " + pers.getName());
                first = 1;
            }
            else
                sb.append(", " + type.toString() + " relationship with " + pers.getName());
        }
        sb.append("}\n");
        return sb.toString();
    }

}
