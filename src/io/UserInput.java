package io;

import java.util.Scanner;

public class UserInput {
    private final Scanner sc = new Scanner(System.in);
    private char input;
    private String question;

    public void scanConsole(char[] array){
        System.out.print(question);
        input =  sc.next().toLowerCase().charAt(0);
        validateInput(array);
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public char getInput(){
        return input;
    }


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
}
