The program is a desktop application that allows users to draw and save images.

The graphic interface is composed of two main components: a control panel and a drawing panel. The control panel contains a button to save the image, as well as a button to delete the contents of the drawing panel. The drawing panel is the area where users can draw using the mouse or graphic tablet.

The application allows users to save images in PNG format. When the user clicks the "Save" button, the image is saved in the directory specified by the user in a save dialog.

The program uses the JavaFX library to create and manage the graphic interface and to manipulate the image files.

Functionality of the classes:

1. ControlPanel: This class represents the control panel of the application and is responsible for displaying the buttons ("Load", "Save", "Export" and "Exit").

2. DrawingCanvas: This class represents the application's drawing surface and is responsible for displaying and managing the user's drawings. Contains a list of DrawnObject objects that represent the objects drawn on the canvas.

3. ConfigPanel: This class represents the configuration panel of the application where the user sets the number of nodes of the graph and chooses the probability of the lines from the dropdown menu.

4. Player: This class contains the details of each player (the color he will represent in the game), the order number of the player and the list with the edges colored by him.

5. Node: This class represents the X and Y coordinates of a point on the graph.

6. Edge: This class represents the coordinates of the two nodes incident to the respective edge.

7. Game: The Game class contains a public constructor that receives a DrawingPanel object and initializes the canvas, edges, and uncoloredEdges instance variables with the corresponding values from the DrawingPanel object received as a parameter. This constructor also sets up a click event on the canvas so that when the user clicks on a line, its color is changed to the color of the current player and it checks to see if the player has formed a triangle. If all edges have been colored and no player has won, an information message is displayed.

The Game class also contains two other methods:

- method isOnLine, which receives two coordinates (mouseX and mouseY) and checks if the mouse is on an uncolored line in uncoloredEdges. If so, the line's color is changed to the current player's color, and the line is removed from uncoloredEdges and added to the current player's edge list.

- the hasTriangle method, which receives a Player object and checks whether that player has formed a triangle with the edges in its edge list. This method checks all possible combinations of 3 edges in the player's edge list and checks if the edges are incident.
