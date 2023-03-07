This project consists in simulating a map with several types of locations (airports, malls, universities, public institutions) and access routes between them (county road, freeway, express road). The BFS algorithm is implemented to find the shortest path between two locations.

Classes:
Location class
The Location class is an abstract class that represents a location on the map. It has the following attributes:

name: location name (String)
latitude: x coordinate of map location (double)
longitude: the y-coordinate of the map location (double)

Airport, Mall, University, Public Institution classes
These are concrete classes that extend the Location class. Each of them has a constructor that initializes the name attribute with the specific name of the location (for example, for the Airport class, name will be initialized with "Airport"). Classes can also have other specific attributes and methods.

Roads class
The Roads class is an abstract class that represents a path between two locations. It has the following attributes:

locationStart: the start location of the road (Location object)
locationEnd: the end location of the road (Location object)
length: road length in kilometers (double)
speedLimit: maximum speed allowed on the respective road segment (int)

CountyRoad, Freeway, ExpressRoad classes
These are concrete classes that extend the Roads class. Each of them has a constructor that initializes the specific attributes of the road and then calls the constructor of the base class. Classes can also have other specific attributes and methods.

ProblemInstance class
The ProblemInstance class is the main class of the program. It has a list of locations and a list of roads between those locations. It implements the BFS algorithm to find the shortest path between two given locations.
