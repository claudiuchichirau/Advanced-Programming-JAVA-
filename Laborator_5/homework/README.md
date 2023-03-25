
This project implements a catalog system for books and articles, with features such as adding, removing, listing, viewing, and saving documents. 

The project is organized into several packages:
- app: contains the Main class, which is the entry point of the program.
- catalog: contains the Catalog class, which represents the catalog of documents.
- commands: contains the Command interface and several implementations, which represent the commands that can be executed on the catalog.
- documents: contains the Document interface and several implementations, which represent the documents in the catalog.

Regarding how to use the application, the user can use the commands from the "commands" package to manage the document catalog. For example, the user can use the "AddCommand" command to add a new document to the catalog or the "ListCommand" command to display all the documents in the catalog. Also, the user can use the "LoadCommand" command to load a JSON file containing a document catalog and the "SaveCommand" command to save the current catalog in a JSON file.

Available commands are:

- add: adds a document to the catalog. The user is prompted for the document type (book or article), and for the document details (title, author, URL, tags, etc.).
- remove: removes a document from the catalog. The user is prompted for the document ID.
- list: lists all the documents in the catalog.
- view: opens a document using the native operating system application.
- save: saves the catalog to a file in JSON format.
- load: loads a catalog from a file in JSON format.
- report: creates an HTML report representing the content of the catalog.

The Command interface represents the commands that can be executed on the catalog. It has a single method, execute(), which takes no arguments and throws an IOException and an InvalidCommandParameterException.

The CatalogCommand class is an abstract class that implements the Command interface. It has a protected field catalog that represents the catalog on which the command will operate.

The AddCommand, RemoveCommand, ListCommand, ViewCommand, SaveCommand, and LoadCommand classes are concrete implementations of the CatalogCommand class, and represent the corresponding commands.

The ReportCommand class is a concrete implementation of the Command interface, and represents the report command.

The Document interface represents the documents in the catalog. It has several methods to get and set the document properties (ID, name, URL, tags, etc.).

The Article and Book classes are concrete implementations of the Document interface, and represent the corresponding types of documents.
