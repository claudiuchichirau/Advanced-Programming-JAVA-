
The project consists of implementing a solution for distributing projects to a group of students. The solution is implemented in Java and consists of four classes: Main, Student, Project and ProjectsDistribution.

Class "Main.java"
The Main class is the main method that has the entry point of the application. Here an instance of the Faker class is created to generate dummy numbers, a list of students with projects, and a set of projects. It shows the list of students, the list of projects and the students who have fewer preferences than the average.

Class "Student.java"
The Student class a student and contains their name and a list of projects they have accepted. This class implements the Comparable interface to be able to sort a list of students alphabetically by name.

Class "Project.java"
The Project class a project and contains its name. This class implements the Comparable interface to be able to sort a list of projects alphabetically by name.

Class "ProjectsDistribution.java"
The ProjectsDistribution class distributes projects to students. This contains a list of studies and a set of projects. The distributeProject method distributes projects randomly to students and returns a map containing the student-project pairs.
