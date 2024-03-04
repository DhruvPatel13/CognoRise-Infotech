import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class hangman {
//    TASK 4: HANGMAN GAME
    public static void main(String[] args) {
        hangmanGame hg = new hangmanGame();
        System.out.println(">>>>>>>>>> Welcome To The Hangman Game <<<<<<<<<<");
        System.out.println("Rules: You have 7 chances, if wrong guess chances will be deducted.");
        hg.startGame();
    }
}

class hangmanGame {
    Scanner sc = new Scanner(System.in);
    String[] words = {"lion", "fox", "deer", "mouse", "mango", "camel", "horse", "cow", "rabbit", "peacock", "zebra", "tiger",
            "key", "elephant", "snake", "lizard", "wolf", "rock", "sheep", "cheetah", "frog", "goat", "panda", "ball", "books",
            "kangaroo", "bat", "computer", "octopus", "duck", "door", "remote", "rice", "table", "pen", "paper",
            "bottle", "hawk", "apple", "eagle", "banana", "dolphin", "game", "ant", "spider"};

    char[] charArray;
    private int incorectGuess = 7;
    private int indexForWord;

//    Constructor to generate random index for String[] words.
    hangmanGame() {
        Random random = new Random();
        this.indexForWord = random.nextInt(0, words.length);
    }

//    Main game.
    public void startGame() {

        String wordFromArray = words[this.indexForWord];
        charArray = new char[wordFromArray.length()];
        Arrays.fill(charArray, '_');
        System.out.println("\nGuess the word:- " + Arrays.toString(charArray));

        do {
            System.out.print("\nEnter your guess: ");
            char letterIp = sc.next().charAt(0);
            boolean printFigure = true;

            // to check if enter guess is correct or not.
            for (int i = 0; i < charArray.length; i++) {
                if (letterIp == wordFromArray.charAt(i)) {
                    charArray[i] = letterIp;
                    printFigure = false;
                }

            }
            System.out.println("Current word: " + Arrays.toString(charArray));

            // To print figure
            if (printFigure) {
                System.out.println("Incorrect guess!  Chances left:" + (this.incorectGuess - 1));
                displayFigure(this.incorectGuess);
                this.incorectGuess--;
            }

            // To print final result
            if (String.valueOf(charArray).equals(wordFromArray)) {
                System.out.println("Congratulations You Win :) /The word was: " + wordFromArray);
                break;
            } else if (incorectGuess == 0){
                System.out.println("You Loose :( /The word was: " + wordFromArray);
            }

        } while (incorectGuess > 0 );

    }

    //  method to create hangman figure.
    public void displayFigure(int count) {
        System.out.println("Hangman Figure:");
        switch (count) {
            case 7 -> {
                System.out.println("  ______________");
                System.out.println("  |            |");
                System.out.println("  |            O");
                System.out.println("  |            ");
                System.out.println("  |            ");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("-----");
            }
            case 6 -> {
                System.out.println("  ______________");
                System.out.println("  |            |");
                System.out.println("  |            O");
                System.out.println("  |            |");
                System.out.println("  |            ");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("-----");
            }
            case 5 -> {
                System.out.println("  ______________");
                System.out.println("  |            |");
                System.out.println("  |            O");
                System.out.println("  |            |");
                System.out.println("  |            |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("-----");
            }
            case 4 -> {
                System.out.println("  ______________");
                System.out.println("  |            |");
                System.out.println("  |            O");
                System.out.println("  |            |\\");
                System.out.println("  |            |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("-----");
            }
            case 3 -> {
                System.out.println("  ______________");
                System.out.println("  |            |");
                System.out.println("  |            O");
                System.out.println("  |           /|\\");
                System.out.println("  |            |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("-----");
            }
            case 2 -> {
                System.out.println("  ______________");
                System.out.println("  |            |");
                System.out.println("  |            O");
                System.out.println("  |           /|\\");
                System.out.println("  |            |");
                System.out.println("  |             \\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("-----");
            }
            default -> {
                System.out.println("  ______________");
                System.out.println("  |            |");
                System.out.println("  |            O");
                System.out.println("  |           /|\\");
                System.out.println("  |            |");
                System.out.println("  |           / \\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("-----");

            }
        }

    }
}