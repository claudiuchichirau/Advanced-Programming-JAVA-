Document Management System
This project is an application that manages a catalog of documents. An entry in this catalog can be an article or a book. A document can be located using an external URL address. Each document has a unique ID, a name, an external URL by which it can be located and can have additional tags, which are key-value pairs. Examples of tags can be title, author, year, publishing date, etc.

Implementation
The application consists of two main classes: Catalog and Document. The Document class implements the DocumentInterface, which provides the necessary methods for managing a document. The Catalog class is responsible for managing a collection of documents and provides methods for adding, removing, and searching documents in the collection. The catalog is implemented as a list of Document objects.

The Document class has the following attributes:

id: an integer representing the unique identifier of the document;
name: a string representing the name of the document;
url: a string representing the external url of the document;
tags: a map representing the additional tags of the document.
The tags map contains key-value pairs representing the additional information about the document. The keys are strings representing the names of the tags, and the values are objects representing the values of the tags. The tags map can contain any number of key-value pairs, depending on the additional information required for the document.

The Document class provides methods for setting and getting the id, name, and tags attributes of the document. The setName method checks if the provided name is valid, and the setTags method checks if the provided tags are valid. If the provided name or tags are invalid, an exception is thrown.

The Catalog class has the following attributes:

documents: a list representing the collection of documents.
The Catalog class provides methods for managing the collection of documents, such as addDocument, removeDocument, saveDocument or loadDocument
