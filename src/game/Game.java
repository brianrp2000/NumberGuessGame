package game;

import io.UserInput;

public class Game {
    private final int limit = 100;
    private int guessCount;
    private UserInput userInput;

    public void startGuessing(){
        guessCount = 1;
        userInput = new UserInput();

        getInstructions();
        guessing(0, limit+1);
    }

    private void guessing(int left, int right){
        int middle = (left + right) / 2;
        String question = printGuess(middle);
        char command = userInput.getAnswer(question);

        if(command == 'l'){
            guessing(left, middle);
        }else if(command == 'h'){
            guessing(middle, right);
        }else{
            System.out.printf("Ok! Your number is %d\n", middle);
            String str = guessCount-1 == 1? "guess": "guesses";
            System.out.printf("Your number was found in %d %s\n", guessCount-1, str);
            playAgain();
        }
    }

    private void playAgain(){
        String question = "\nDo you want to play again\nType (y/n)\n";
        boolean answer = userInput.getBinaryAnswer(question);

        if(answer){
            startGuessing();
        }else{
            System.out.println("Bye! Thanks for playing");
        }
    }

    private void getInstructions(){
        System.out.println();
        System.out.printf("Think of a number between 0-%d\n", limit);
        System.out.println("Answer with: ");
        System.out.println("\tl (your num is lower)");
        System.out.println ("\th (your num is higher)");
        System.out.println ("\tany other key (guess is right).");
    }

    private String printGuess(int guess){
        String str = String.format("[%d] Is it %d? (l, h, y): \n", guessCount, guess);
        guessCount++;
        return str;
    }
}
