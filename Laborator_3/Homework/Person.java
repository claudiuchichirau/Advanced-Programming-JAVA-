package laborator_3.homework;


import java.util.HashMap;
import java.util.Map;

public class Person implements Node, Comparable{
    private String name;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    Map<Object, RelationshipType> relationships;

    public enum RelationshipType {
        FAMILY, COLLEAGUE, FRIEND, // relationships between two persons
        MANAGER, IT, HR, MARKETING, SALES, FINANCE // relationships between a person and a company
    }

    public Person(String name, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.relationships = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDateOfBirth() {
        return dayOfBirth + "/" + monthOfBirth + "/" + yearOfBirth;
    }

    public void SetDateOfBirth(int dayOfBirth, int monthOfBirth, int yearOfBirth){
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public void addRelationship(Object obj, RelationshipType type) {
        if (obj instanceof Person){

            // Check if the type of relationship is valid between two people
            if(type == RelationshipType.FAMILY || type == RelationshipType.FRIEND || type == RelationshipType.COLLEAGUE) {
                this.relationships.put(obj, type);      // add the relationship from person x to person y
                ((Person) obj).relationships.put(this, type); // add the relationship from person y to person x
            }
            else
                System.out.println("The type of relationship introduced is not possible between two people!");
        }  // Check if the type of relationship is valid between a person and a company
        else if (obj instanceof Company) {
            if(type == RelationshipType.MANAGER || type == RelationshipType.IT ||type == RelationshipType.HR || type == RelationshipType.MARKETING || type == RelationshipType.SALES || type == RelationshipType.FINANCE)
                this.relationships.put(obj, type);         // add the relationship from person x to company y
            else
                System.out.println("The type of relationship entered is not possible between a person and a company!");
        }
        else
            System.out.println("Invalid relationship object type.");
    }

    public Map<Object, RelationshipType> getRelationships() {
        Map<Object, RelationshipType> relationshipsMap = new HashMap<>();

        // Loop through each relationship in the 'relationships' map and add it to a new map
        for (Map.Entry<Object, RelationshipType> entry : relationships.entrySet()) {
            Object obj = entry.getKey();
            RelationshipType type = entry.getValue();

            // Check if the relationship is between a Person or a Company and add it to the new map
            if (obj instanceof Person || obj instanceof Company) {
                relationshipsMap.put(((Node) obj).getName(), type);
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
        Person pers = (Person) o;
        return this.name.compareTo(pers.name);
    }

    @Override
    public String toString(){
        int first = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(":{");
        for (Map.Entry<Object, RelationshipType> entry : relationships.entrySet()) {
            Object obj = entry.getKey();
            RelationshipType type = entry.getValue();
            if (obj instanceof Person) {
                Person person = (Person) obj;
                if (person != this) { // exclude self-relationship
                    if(first == 0)
                    {
                        sb.append(type.toString() + " relationship with " + person.getName());
                        first = 1;
                    }
                    else
                        sb.append(", " + type.toString() + " relationship with " + person.getName());
                }
            } else if (obj instanceof Company) {
                Company company = (Company) obj;
                if(first == 0)
                {
                    sb.append(type.toString() + " relationship with " + company.getName());
                    first = 1;
                }
                else
                    sb.append(", " + type.toString() + " relationship with " + company.getName());
            }
        }
        sb.append("}");
        return (this.name + " was born on " + this.dayOfBirth + "." + this.monthOfBirth + "." + this.yearOfBirth + ". He/She has the following relationships " + sb);
    }

}