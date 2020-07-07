# NumberGuessGame

This is a fully functional console-based guessing game written in Java. The game tries to guess what number you are thinking of. It follows a binary search algorithm implemented recursively and uses user input that specifies whether the assumption was less than or greater than the number the user wanted. 

### Materials Needed:
- JDK (Java Development Kit)
- IDE (Integreted Development Environment)
   - Preferably IntelliJ IDEA Community Edition
   
### Complete Project Structure
<br><img src="/images/create-new-project.png" alt="create-new-project-image" height= 200 width = 200> <br>

### Steps for creating a new Project:
1. Make sure you have install the materials needed
   - [JDK](https://www.java.com/en/download/)
   - [IDE](https://www.jetbrains.com/idea/download/#section=windows)
2. Creating a new java project
   - Open IntelliJ IDEA to begin creating a new project
   - Click on **Create New Project**
   <br><img src="/images/create-new-project.png" alt="create-new-project-image" height= 200 width = 200> <br>
   - Click **Next**. Make sure you have selected the project SDK
   <br><img src="/images/next-image.png" alt="next-image" height= 200 width = 200><br>
   - CLick **Next** again
   - Type the name of the project and select its location
   <br><img src="/images/name-location-image.png" alt="name-location-image" height= 200 width = 200><br>
   - Click **Finish**
   
### Create the Controller Class
1. Create the app package
   - On your the left side of the window right click the **scr** file
   <br><img src="/images/src-image.png" alt="src-image" height= 100 width = 200><br>
   - Click **New**
   - Click **Package**
   - Enter the name of the package, which is **app**
2. Create a java class inside the **app** package
   - On your the left side of the window right click the **app** package
   <br><img src="/images/app-image.png" alt="app-image" height= 100 width = 200><br>
   - Click **New**
   - Click **Java Class**
   - Enter the name of the package, which is **Controller**
   <br><img src="/images/controller-java-class-name.png" alt="controller-java-class-name-image" height= 100 width = 200><br> 
 3. Make the class **Controller** the main driver by adding the following line inside its curly brackets
```java
package app;
public class Controller{
   //new line
   public static void main(String[] args) {
   }
}

```
4. Import the Game class (We will create this class later)
```java
package app;

//new line
import game.Game; 

public static void main(String[] args) {
}

5. Create an instance of the **Game class** inside of **main** 
```java
package app;
import game.Game;
public static void main(String[] args) {
   //new line added
   Game guessingGame = new Game();
}
```
6. The Game class will have a method call **startGuessing** which we will call now
```java
public static void main(String[] args) {
   Game guessingGame = new Game();
   //new line added
   guessingGame.startGuessing();
}
```


