package io;

import java.util.Scanner;

public class UserInput {
    private final Scanner sc = new Scanner(System.in);

    public char getAnswer(String str){
        System.out.print(str);
        return sc.next().toLowerCase().charAt(0);
    }

    public boolean getBinaryAnswer(String str){
        char command = getAnswer(str);

        if(command == 'y'){
            return true;
        }else if(command == 'n'){
            return false;
        }else{
            System.out.println("I am sorry :(");
            System.out.println("You need to enter either y or n");
            getBinaryAnswer(str);
        }
        return false;
    }
}
