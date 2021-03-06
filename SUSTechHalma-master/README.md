# Java Course Project Demo

##### SOUTHERN UNIVERSITY OF SCIENCE AND TECHNOLOGY

##### 11712019 YU Tiancheng


### What Are Used in This Project

###### The Java Development Kit (JDK) 8+

###### The Java Swing GUI Library


### Project Structure

###### xyz.chengzi.halma: The parent package of the project

```
controller: Interact between views and models to handle
user input and update data structures
listener: Trigger when event (e.g. player clicks) happens
model: Hold data structures and handle game logics
view: Render the GUI interfaces and display on screen
```
###### Note: Despite of the naming, the project does NOT strictly follow the MVC design pattern for simplicity.


### Intelligent Computer Players

###### Random moves?

```
Randomly choose a piece, and randomly move to one of the available square...
```
###### Alpha-beta search

Reference: https://github.com/aimacode/aima-java

###### Monte-Carlo tree search

```
......
```

### Save / Load Games

###### Simplest Method

```
Implement the java.io.Serializableinterface in the model classes
When saving, dump the object to file using ObjectOutputStream
Upon loading, load the object from file using ObjectInputStream
```
###### More elegant ways

```
Store the data in yamlor json format
Or use databases like SQLite or MySQL
```

#### Online Multi-player

###### WebSocket is an easy way to communicate between client and server

```
It also works in browser!
```
###### Recommended framework:

https://javalin.io

## How The Swing Works?


### Multi-threading in Swing

```
After program started
Main Thread: Generated by JVM executing main() method
AWT-Windows: Listen to UI events from AWT windows
AWT-Shutdown: Handle termination of AWT windows
AWT-EventQueue-0: Event dispatching thread, manage event processing
DestroyJavaVM: Cleanup work for JVM after program exits
```

Why we need multi-threading?
```
Avoid user interface not responding when program is busy
```

Reference:
[Lecture 5 Multi-threaded Swing](https://www.cs.bham.ac.uk/~szh/teaching/ssc/lecturenotes/Concurrency/Lecture5_Multithreaded%20Swing.pdf)


### Why Multi-threading in Swing?

###### Terrible UI programs:
```
No response after clicking buttons
```
###### Good UI programs:
```
User can perform other operations with background tasks running
```

### What???s More? (Multi-threading)

###### When to opt for multi-threading?

```
Processing content which may require long waiting
Loading and decoding the saved game
Waiting for network in client or server
Calculating AI moves
Playing background music or sound effects
```
###### How to use multi-threading?

```
SwingWorker< T, V >
SwingUtilitiesalso provides helper functions
......
```
