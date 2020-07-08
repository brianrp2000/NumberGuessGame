# NumberGuessGame

This is a fully functional console-based guessing game written in Java. The game tries to guess what number you are thinking of. It follows a binary search algorithm implemented recursively and uses user input that specifies whether the assumption was less than or greater than the number the user wanted. 

So, I think my manual will be explaining how to build a console-based guessing game, written in Java. The game tries to guess what number you are thinking of. It follows a binary search algorithm implemented recursively and uses user input that specifies whether the assumption was less than or greater than the number the user wanted. I think these instructions are geared towards computer science students with a beginner/intermidiate level of proficiency in Java programming who are looking for a tangible implementation of the binary search algorithm with recursion.

### Materials Needed:
- JDK (Java Development Kit)
- IDE (Integreted Development Environment)
   - Preferably IntelliJ IDEA Community Edition
   
### Complete Project Structure
<img src="/images/project-structure.png" alt="project-structure-image" height= 200 width = 200> <br>
>Note: If you know how to get the above structure in IntelliJ IDEA go ahead and skip to [Create the Controller Class](#create-the-controller-class). You can also start the creation of each Class from step 3

### Steps for creating a new Project:
1. Make sure you have installed the materials needed
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
   - Enter the name of the class, which is **Controller**
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
4. Import the Game class
```java
package app;

//new line
import game.Game; 

public class Controller{
   public static void main(String[] args) {
   }
}
```
5. Create an instance of the **Game class** inside of **main** 
```java
package app;
import game.Game;
public class Controller{
   public static void main(String[] args) {
      //new line added
      Game guessingGame = new Game();
   }
}
```
6. The Game class will have a method call **startGuessing** which we will call now
```java
public class Controller{
   public static void main(String[] args) {
      Game guessingGame = new Game();
      //new line added
      guessingGame.startGuessing();
   }
}
```
7. Because we still haven't created the Game Class the IDE will mark the above code as wrong by telling you: Cannot resolve symbol 'Game'.We will create the class in [here](#create-the-game-class)

### Create the UserInput Class
1. Create the io package
   - On your the left side of the window right click the **scr** file
   <br><img src="/images/src-io-image.png" alt="src-io-image" height= 100 width = 200><br>
   - Click **New**
   - Click **Package**
   - Enter the name of the package, which is **io**
2. Create a java class inside the **io** package
   - On your the left side of the window right click the **io** package
   <br><img src="/images/io-image.png" alt="io-image" height= 150 width = 200><br>
   - Click **New**
   - Click **Java Class**
   - Enter the name of the class, which is **UserInput**
   <br><img src="/images/userInput-class-image.png" alt="userInput-class-image" height= 150 width = 200><br> 
3. Import the Scanner class
```java
package io;

//new line
import java.util.Scanner;

public class UserInput{
}
```
4. Inside the **UserInput** class curly brackets we will need to enter its variables
```java
private final Scanner sc = new Scanner(System.in);
private char input;
private String question;
``` 
5. Create a *setter* for the **question** variable 
```java
public void setQuestion(String question){
        this.question = question;
}
``` 
6. Create a *getter* for the **input** variable
```java
public char getInput(){
        return input;
}
``` 
7. Create the public method called **scanConsole** that takes a char array as input, this is the method in charge of scanning user input from the console
```java
public void scanConsole(char[] array){
        System.out.print(question);
        input =  sc.next().toLowerCase().charAt(0);
        validateInput(array);
}
```
8. As we saw in the **scanConsole** method we need to define another method call **validateInput** that takes a char array as input, in here we will make sure that the user enters a command specified in the char array of possible user commands 
```java
private void validateInput(char[] array){
   boolean isValidInput = false;

   for (char aCommand : array) {
      if (input == aCommand){
          isValidInput = true;
          break;
      }
   }

   if (!isValidInput){
      printErrorMsg(array);
      scanConsole(array);
      validateInput(array);
   }
 }
```
   - the first thing the method does is declaring a boolean variable that will track the validity of the user input
   - Then we check if the user input is found in the char array taken as input and if it is the variable will change to true
   - Eventually we check if the variable is still false, if so it means that the user input is invalid
      - We now print the error message
      - Scan the console again for a valid input
      - Call recursively the validateInput method to check again the validity of the input
9. As we saw in the **validateInput** method, we need to create a method called **printErrorMsg** that takes an char array as an input. This method generates the message we print when the user enters a character outside the possible command range.
```java
private void printErrorMsg(char[] array){
        StringBuilder str = new StringBuilder();

        System.out.println("I am sorry :(");

        if(array.length > 2){
            for (char aCommand : array) {
                if(aCommand == array[array.length - 1]){
                    str.append("or ").append(aCommand);
                }else {
                    str.append(aCommand).append(", ");
                }
            }
        }else if(array.length == 2){
            str.append(array[0]).append(" or ").append(array[1]);
        }else{
            str.append(array[0]);
        }

        System.out.printf("You have to enter %s\n", str);
    }
```
   - First create an instance of a StringBuilder
   - Print the I am sorry message
   - Check the length of the array 
      - If the length is greater than 2, we loop the array checking for the last element in the array to append the string literal "or " before the element. If it isn't the last element we just append the element and then the string literal ", "
      - If the array has a length of 2, we just have to append the first element, then the string literal " or " and finally the last element
      - Lastly if neither of the above check run it means the array has only one element, so we just have to append the first element
   - Print a message with the string we have just built
   
### Create the Game Class
1. Create the game package
   - On your the left side of the window right click the **scr** file
   <br><img src="/images/src-game-image.png" alt="src-game-image" height= 150 width = 200><br>
   - Click **New**
   - Click **Package**
   - Enter the name of the package, which is **game**
2. Create a java class inside the **game** package
   - On your the left side of the window right click the **game** package
   <br><img src="/images/game-image.png" alt="game-image" height= 150 width = 200><br>
   - Click **New**
   - Click **Java Class**
   - Enter the name of the class, which is **Game**
   <br><img src="/images/game-class-image.png" alt="game-class-image" height= 150 width = 200><br> 
3. Import the **userInput** class
```java
package game;

//new line 
import io.UserInput;

public class Game{
}
```
4.  Inside the **Game** class curly brackets we will need to enter its variables
```java
private final int limit = 100;
private int guessCount;
private UserInput userInput;
``` 
5. Create the public method called **startGuessing**, this is the method in charge of initializing variables and start the function that allows the computer to make guesses
```java
public void startGuessing(){
        guessCount = 0;
        userInput = new UserInput();

        getInstructions();
        guessUsingBinarySearch(0, limit+1);
}
```
   - Initialize the guessCount variable
   - Create a UserInput object
   - Print the instruction of the game
   - Call the method in charge of guessing with a left input of zero and a right input of limit+1
      >Note: The input is taking limit+1 so that the range of guesses go from 0 to the limit inclusive
6. As we saw in the method called **startGuessing**, we need to create a method call **getInstructions**. This method just prints what the user needs to know before the computer can start guessing.
```java
private void getInstructions(){
   System.out.println();
   System.out.printf("Think of a number between 0-%d\n", limit);
   System.out.println("Answer with: ");
   System.out.println("\tl (your num is lower)");
   System.out.println ("\th (your num is higher)");
   System.out.println ("\ty (guess is right).");
}
```
7. We also saw in the method **startGuessing** that we need to create another method called **guessUsingBinarySearch**. This method has 2 inputs: the left part and the right part of the range where the number the user want can be. This method is a recursive implementation of the Binary Search Algorithm, where we have a middle index and in each implementation the range is halved by moving the left or right marker to the value of that middle index.
```java
private void guessUsingBinarySearch(int left, int right){
   int middle = (left + right) / 2;
   userInput.setQuestion(printGuess(middle));
   userInput.scanConsole(new char[]{'l', 'h', 'y'});

   switch (userInput.getInput()){
      case 'l':
          guessUsingBinarySearch(left, middle);
          break;
      case 'h':
          guessUsingBinarySearch(middle, right);
          break;
      case 'y':
          System.out.printf("Ok! Your number is %d\n", middle);
          String str = guessCount == 1? "guess" : "guesses";
          System.out.printf("Your number was found in %d %s\n", guessCount, str);
          playAgain();
          break;
   }
}
```
- Create a variable representing the middle of the range
- Call the **setQuestion** method from the userInput object
   - Pass as input the **printGuess** method 
   - The **printGuess** method will have the middle variable as its input
- Call the **scanConsole** method from the userInput object with a char array as input representing the possible user inputs 
- Create a switch statement to check the value of the input from the user
   - if the value is 'l' that means the number is lower than the guess, so we have to recursively call the method **guessUsingBinarySearch** making middle the limit of the new range
   - if the value is 'h' that means the number is higher than the guess, so we have to recursively call the method **guessUsingBinarySearch** making middle the beginning of the new range
   - if the value is 'y' that means that we have found the number
      - print middle
      - build a string that check if we found the number in just one guess so that we handle the guessCount message correctly
      - print how many tries took to find the number
      - call the **playAgain** method
    
8. As we saw in the method **guessUsingBinarySearch** we have to create the **printGuess** method which returns a String with the guess given as input and a guess count 
```java
private String printGuess(int guess){
   guessCount++;
   return String.format("[%d] Is it %d? (l, h, y): \n", guessCount, guess);
}
```
