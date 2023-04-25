# Project Readme
## Description
This project is a Java implementation of a database manager that connects to an Oracle database and interacts with it. It contains three classes:

1. DBManager: this class creates a connection to the database and provides a method to get the connection object. It is a Singleton, which means that there can be only one instance of it at any given time.
2. ArtistDAO: this class contains methods to select, insert, update, and delete records in the artists table in the database.
3. Artist: this class can be used to create artist objects with their respective ID and name.
4. Main: this is the main class of the project. It creates an instance of DBManager, gets a connection to the database, and uses an instance of ArtistDAO to interact with the artists table.
