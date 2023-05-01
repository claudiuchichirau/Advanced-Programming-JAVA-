# Importer of Albums
This Java project uses an Oracle database to import album data from a CSV file and add it to the database.

## Instructions to run the project
1. Download and install Oracle Database XE and a Java IDE such as IntelliJ IDEA or Eclipse.
2. Create a schema in the database and run the "schema.sql" script to create the necessary tables.
3. Open the project in the IDE and modify the "Main.java" file to use the database connection credentials.
4. Run the "Main.java" class to import the album data from the CSV file and add it to the database.

## Technical specifications
1. The project was created in Java 8 and uses the Oracle database.
2. C3P0 is used to manage the database connection.
3. The BufferedReader class is used to parse the CSV file.
4. The project is organized in 4 packages: "org.example.homework.DAO", "org.example.homework.tables", "org.example.homework" and "org.example.homework.tests".
5. The "Main.java" class contains the code for importing data from the CSV file and adding them to the database.

## Outbuildings
1. C3P0 version 0.9.5.5
2. Oracle JDBC driver version 19.3.0.0.0
These dependencies are included in the JAR files of the project and do not need to be downloaded separately.

## Other information
1. The "Main.java" class also contains the code for testing the insertion and deletion of artist data in the database. This has been commented out to allow album import to run without interfering with other database operations.
2. The "schema.sql" file contains the SQL script needed to create the tables in the database.
