import java.util.Scanner;

public class Game {
    private int limit = 100;
    private int counter = 1;

    public void setLimit(int limit){
        this.limit = limit;
    }

    public int getLimit(){
        return limit;
    }

    public void startGuessing(){
        getInstructions();
        guessing(0, limit);
    }

    private void guessing(int left, int right){
        int middle = (left + right) / 2;

        printGuess(middle);

        Scanner sc = new Scanner(System.in);
        char command = sc.next().charAt(0);

        if(command == 'l'){
            guessing(left, middle);
        }else if(command == 'h'){
            guessing(middle, right);
        }else{
            System.out.printf("Ok! Your number is %d\n", middle);
            System.out.println("Thank you!");
        }

    }

    private void getInstructions(){
        System.out.println("This is a guessing game, you think of a number and we will guess it");
        System.out.printf("Think of a number between 0-%d\n", limit);
        System.out.println("Answer with: ");
        System.out.println("\tl (your num is lower)");
        System.out.println ("\th (your num is higher)");
        System.out.println ("\tany other key (guess is right).");
    }

    private void printGuess(int guess){
        System.out.printf("[%d] Is it %d? (l, h, y): \n", counter, guess);
        counter++;
    }
}
