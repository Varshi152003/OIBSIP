import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;
        int totalScore = 0;
        String playAgain;

        printWelcomeMessage();

        do {
            totalRounds++;

            int secretNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attemptsUsed = playSingleRound(scanner, secretNumber);

            if (attemptsUsed > 0) {
                roundsWon++;
                int roundScore = calculateScore(attemptsUsed);
                totalScore += roundScore;

                System.out.println("\nRound Result: WON - NumberGuessingGame.java:33");
                System.out.println("Attempts Used: - NumberGuessingGame.java:34" + attemptsUsed);
                System.out.println("Score Earned: - NumberGuessingGame.java:35" + roundScore);
            } else {
                System.out.println("\nRound Result: LOST - NumberGuessingGame.java:37");
                System.out.println("The correct number was: - NumberGuessingGame.java:38" + secretNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): - NumberGuessingGame.java:41");
            playAgain = scanner.next().trim().toLowerCase();

        } while (playAgain.equals("yes") || playAgain.equals("y"));

        printFinalSummary(totalRounds, roundsWon, totalScore);

        scanner.close();
    }

    private static void printWelcomeMessage() {
        System.out.println("==================================== - NumberGuessingGame.java:52");
        System.out.println("NUMBER GUESSING GAME - NumberGuessingGame.java:53");
        System.out.println("==================================== - NumberGuessingGame.java:54");
        System.out.println("Rules: - NumberGuessingGame.java:55");
        System.out.println("1. Guess a number between 1 and 100. - NumberGuessingGame.java:56");
        System.out.println("2. You get 7 attempts per round. - NumberGuessingGame.java:57");
        System.out.println("3. Faster guessing gives a higher score. - NumberGuessingGame.java:58");
    }

    private static int playSingleRound(Scanner scanner, int secretNumber) {

        int attempts = 0;

        System.out.println("\n - NumberGuessingGame.java:65");
        System.out.println("New Round Started - NumberGuessingGame.java:66");
        System.out.println("");

        while (attempts < MAX_ATTEMPTS) {

            int userGuess = readValidGuess(scanner);
            attempts++;

            if (userGuess < secretNumber) {
                System.out.println("Too low! Try a bigger number. - NumberGuessingGame.java:75");
            } else if (userGuess > secretNumber) {
                System.out.println("Too high! Try a smaller number. - NumberGuessingGame.java:77");
            } else {
                System.out.println("Correct! You guessed the number. - NumberGuessingGame.java:79");
                return attempts;
            }

            System.out.println("Attempts left: - NumberGuessingGame.java:83" + (MAX_ATTEMPTS - attempts));
        }

        return -1;
    }

    private static int readValidGuess(Scanner scanner) {

        int guess;

        while (true) {
            System.out.print("\nEnter your guess: - NumberGuessingGame.java:94");

            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();

                if (guess >= MIN_NUMBER && guess <= MAX_NUMBER) {
                    return guess;
                } else {
                    System.out.println("Please enter a number between 1 and 100. - NumberGuessingGame.java:102");
                }
            } else {
                System.out.println("Invalid input. Please enter numbers only. - NumberGuessingGame.java:105");
                scanner.next();
            }
        }
    }

    private static int calculateScore(int attemptsUsed) {
        return (MAX_ATTEMPTS - attemptsUsed + 1) * 10;
    }

    private static void printFinalSummary(int totalRounds, int roundsWon, int totalScore) {

        System.out.println("\n==================================== - NumberGuessingGame.java:117");
        System.out.println("GAME SUMMARY - NumberGuessingGame.java:118");
        System.out.println("==================================== - NumberGuessingGame.java:119");
        System.out.println("Total Rounds Played: - NumberGuessingGame.java:120" + totalRounds);
        System.out.println("Rounds Won: - NumberGuessingGame.java:121" + roundsWon);
        System.out.println("Rounds Lost: - NumberGuessingGame.java:122" + (totalRounds - roundsWon));
        System.out.println("Final Score: - NumberGuessingGame.java:123" + totalScore);
        System.out.println("Thank you for playing! - NumberGuessingGame.java:124");
    }
}