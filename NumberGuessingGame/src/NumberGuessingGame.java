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

            int secretNumber =
                    random.nextInt(MAX_NUMBER - MIN_NUMBER + 1)
                            + MIN_NUMBER;

            int attemptsUsed =
                    playSingleRound(scanner, secretNumber);

            if (attemptsUsed > 0) {

                roundsWon++;

                int roundScore =
                        calculateScore(attemptsUsed);

                totalScore += roundScore;

                System.out.println("\nRound Result: WON");
                System.out.println(
                        "Attempts Used: " + attemptsUsed);

                System.out.println(
                        "Score Earned: " + roundScore);

            } else {

                System.out.println(
                        "\nRound Result: LOST");

                System.out.println(
                        "The correct number was: "
                                + secretNumber);
            }

            System.out.print(
                    "\nDo you want to play another round? (yes/no): ");

            playAgain =
                    scanner.next().trim().toLowerCase();

        } while (
                playAgain.equals("yes")
                        || playAgain.equals("y"));

        printFinalSummary(
                totalRounds,
                roundsWon,
                totalScore);

        scanner.close();
    }

    private static void printWelcomeMessage() {

        System.out.println(
                "====================================");

        System.out.println(
                "        NUMBER GUESSING GAME");

        System.out.println(
                "====================================");

        System.out.println("Rules:");

        System.out.println(
                "1. Guess a number between 1 and 100.");

        System.out.println(
                "2. You get 7 attempts per round.");

        System.out.println(
                "3. Faster guessing gives a higher score.");
    }

    private static int playSingleRound(
            Scanner scanner,
            int secretNumber) {

        int attempts = 0;

        System.out.println(
                "\n------------------------------------");

        System.out.println("New Round Started");

        System.out.println(
                "------------------------------------");

        while (attempts < MAX_ATTEMPTS) {

            int userGuess =
                    readValidGuess(scanner);

            attempts++;

            if (userGuess < secretNumber) {

                System.out.println(
                        "Too low! Try a bigger number.");

            } else if (userGuess > secretNumber) {

                System.out.println(
                        "Too high! Try a smaller number.");

            } else {

                System.out.println(
                        "Correct! You guessed the number.");

                return attempts;
            }

            System.out.println(
                    "Attempts left: "
                            + (MAX_ATTEMPTS - attempts));
        }

        return -1;
    }

    private static int readValidGuess(
            Scanner scanner) {

        int guess;

        while (true) {

            System.out.print(
                    "\nEnter your guess: ");

            if (scanner.hasNextInt()) {

                guess = scanner.nextInt();

                if (guess >= MIN_NUMBER
                        && guess <= MAX_NUMBER) {

                    return guess;

                } else {

                    System.out.println(
                            "Please enter a number between 1 and 100.");
                }

            } else {

                System.out.println(
                        "Invalid input. Please enter numbers only.");

                scanner.next();
            }
        }
    }

    private static int calculateScore(
            int attemptsUsed) {

        return
                (MAX_ATTEMPTS - attemptsUsed + 1)
                        * 10;
    }

    private static void printFinalSummary(
            int totalRounds,
            int roundsWon,
            int totalScore) {

        System.out.println(
                "\n====================================");

        System.out.println(
                "            GAME SUMMARY");

        System.out.println(
                "====================================");

        System.out.println(
                "Total Rounds Played: "
                        + totalRounds);

        System.out.println(
                "Rounds Won: "
                        + roundsWon);

        System.out.println(
                "Rounds Lost: "
                        + (totalRounds - roundsWon));

        System.out.println(
                "Final Score: "
                        + totalScore);

        System.out.println(
                "Thank you for playing!");
    }
}