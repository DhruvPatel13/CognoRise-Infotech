
import java.util.Random;
import java.util.Scanner;

public class Guessing_Game {
//    TASK 1 : NUMBER GUESSING GAME. (without loops)
    public static void main(String[] args) {

    Game guessingGame = new Game();
        System.out.println("Welcome to the Guessing Game");
        System.out.println("Rules:- Maximum attempts Allowed: 10");
        guessingGame.checkNum();

    }
}

class Game {
    private int comp, count = 1;

// created constructor to generate random number
    Game() {
        Random genrateRandom = new Random();
        this.comp = genrateRandom.nextInt(1, 100);
    }

//method to take User Input
    public int userIp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your guess between 1 to 100 ");
        return sc.nextInt();
    }

// Method to check,compare User Input and Comp generated number.
//   No loops have been used, instead I have use recursion to allow multiple attempt's.
    public void checkNum() {

        if (this.count <= 10) {
            int ip = userIp();
            if (ip > comp) {
                System.out.println("The enter number is greater than comp guess  Try Again.");
                setCount(this.count);
                checkNum();
            } else if (ip < comp) {
                System.out.println("The enter number is smaller than comp guess  Try Again.");
                setCount(this.count);
                checkNum();
            } else {
                System.out.println(" Well done you guess it right.");
                System.out.println(" Your number of guesses is: " + getCount());
            }
        }else {
            System.out.println("\n You reached maximum number of attempt's please restart the Game");
            System.out.println("Number of attempts: "+ (getCount()-1) );
        }
    }
//   getters and setters to track the number of attempts.
    public void setCount(int count) {
        this.count = ++count;
    }

    public int getCount(){
        return this.count;
    }

}
