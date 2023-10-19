import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 5;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println(
                "You have " + attempts + " attempts to guess the number between " + minRange + " and " + maxRange);

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int currentAttempt = 0;

            while (currentAttempt < attempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                currentAttempt++;

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a number within the valid range.");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in "
                            + currentAttempt + " attempts.");
                    score += (attempts - currentAttempt + 1);
                    break;
                }
            }

            if (currentAttempt == attempts) {
                System.out.println("Out of attempts. The correct number was " + targetNumber);
            }

            rounds++;
            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.equals("yes");
        }

        System.out.println("Thanks for playing! You won " + rounds + " round(s) and your final score is: " + score);
        scanner.close();
    }
}4