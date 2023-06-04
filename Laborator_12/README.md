# Java Class Analyzer
## Description
This project consists of implementing a Java class parser that loads a specified class into memory, dynamically identifies its package, and uses reflection to extract information about the class (at least its methods). The project also uses reflection to invoke static, no-argument methods that are marked with the @Test annotation.

## Use
1. Compile the laboratory_12.JavaClassAnalyzer class.
2. Run the program, providing the path to the .class file as a command line argument. For example: java laboratory_12.JavaClassAnalyzer /path/to/file/Class.class.
3. The program will load the specified class into memory and parse the class information, displaying the class name, package, and methods.
4. The program will then invoke the static methods marked with the @Test annotation, with no arguments, and display the results.
