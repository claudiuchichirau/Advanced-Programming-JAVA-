The project consists of a Java application that implements a simple social network, where people and companies are modeled as objects and can be interconnected through a set of predefined relationships.

The project contains two main classes: the "Person" class and the "Company" class. Both classes implement the "Node" interface that specifies the general behavior of the objects that can be inserted into the social network. Also, both classes implement the "Comparable" interface to allow objects to be sorted according to a given criterion.

The "Person" class represents a person and has a name and date of birth as attributes. People can be interconnected through predefined relationships that can be family, friendship or collegiality between two people. Also, a person can be employed by a company in a position such as manager, IT, HR, marketing, sales or finance.

The "Company" class represents a company and has a name as an attribute. Companies can be connected to people through types of relationships similar to those defined in the "Person" class. A company can be connected to several people through multiple relationships.

In both classes, the relationship between objects is stored in a Map where the key represents the object with which it is connected, and the value represents the type of relationship.
