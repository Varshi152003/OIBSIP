import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int maxAttempts = 7;
        int attempts = 0;
        int userGuess;

        System.out.println("==================================== - NumberGuessingGame.java:16");
        System.out.println("NUMBER GUESSING GAME - NumberGuessingGame.java:17");
        System.out.println("==================================== - NumberGuessingGame.java:18");
        System.out.println("I have selected a number between 1 and 100. - NumberGuessingGame.java:19");
        System.out.println("You have only 7 attempts. - NumberGuessingGame.java:20");

        while (attempts < maxAttempts) {

            System.out.print("\nEnter your guess: - NumberGuessingGame.java:24");
            userGuess = scanner.nextInt();

            attempts++;

            if (userGuess < secretNumber) {
                System.out.println("Too low! Try again. - NumberGuessingGame.java:30");
            } 
            else if (userGuess > secretNumber) {
                System.out.println("Too high! Try again. - NumberGuessingGame.java:33");
            } 
            else {
                System.out.println("\nCongratulations! - NumberGuessingGame.java:36");
                System.out.println("You guessed the correct number in - NumberGuessingGame.java:37"
                        + attempts + " attempts.");
                scanner.close();
                return;
            }

            System.out.println("Remaining attempts: - NumberGuessingGame.java:43"
                    + (maxAttempts - attempts));
        }

        System.out.println("\nGame Over! - NumberGuessingGame.java:47");
        System.out.println("The correct number was: - NumberGuessingGame.java:48" + secretNumber);

        scanner.close();
    }
}