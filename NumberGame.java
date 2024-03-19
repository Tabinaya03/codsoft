import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    private int targetNumber;
    private int minRange;
    private int maxRange;
    private int attemptsLeft;
    private Scanner scanner;

    public NumberGame(int minRange, int maxRange, int attempts) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.attemptsLeft = attempts;
        this.scanner = new Scanner(System.in);
        generateTargetNumber();
    }

    private void generateTargetNumber() {
        Random random = new Random();
        this.targetNumber = random.nextInt((maxRange - minRange) + 1) + minRange;
    }

    public void play() {
        System.out.println("Welcome to the Number Game!");
        System.out.println("Try to guess the number between " + minRange + " and " + maxRange + ".");
        System.out.println("You have " + attemptsLeft + " attempts.");
        
        while (attemptsLeft > 0) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attemptsLeft--;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You've guessed the correct number: " + targetNumber);
                return;
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
            
            System.out.println("Attempts left: " + attemptsLeft);
        }

        System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
    }

    public static void main(String[] args) {
        NumberGame game = new NumberGame(1, 100, 10);
        game.play();
    }
}
