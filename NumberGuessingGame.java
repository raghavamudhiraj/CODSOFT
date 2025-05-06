import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 7;
        int score = 0;
        int round = 1;
        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + round + " ---");
            System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess;

                // Input validation
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid integer.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attemptsLeft--;

                if (guess == secretNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + (maxAttempts - attemptsLeft) + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("😢 Out of attempts! The number was " + secretNumber + ".");
            }

            System.out.println("Score: " + score + " win(s) out of " + round + " round(s).");

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume newline
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing! Final score: " + score);
            } else {
                round++;
            }
        }

        scanner.close();
    }
}
