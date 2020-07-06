package game;

import io.UserInput;

public class Game {
    private final int limit = 100;
    private int guessCount;
    private UserInput userInput;

    public void startGuessing(){
        guessCount = 0;
        userInput = new UserInput();

        getInstructions();
        guessUsingBinarySearch(0, limit+1);
    }

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
        }
    }

    private void playAgain(){
        userInput.setQuestion("\nDo you want to play again?\nType (y/n)\n");
        userInput.scanConsole(new char[]{'y', 'n'});

        switch (userInput.getInput()){
            case 'y':
                startGuessing();
                break;
            case 'n':
                System.out.println("Bye! Thanks for playing");
                break;
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
        guessCount++;
        return String.format("[%d] Is it %d? (l, h, y): \n", guessCount, guess);
    }
}
