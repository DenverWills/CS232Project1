/* Name: Denver Wills
 * 
 * Date: 8/23/2024
 * 
 * Problem Statement: 
 * Write a program that plays the Hi-Lo guessing game with numbers. The program should pick a
 * random number between 1 and 100 (inclusive), then repeatedly prompt the use to guess the number.
 * On each guess, report to the user that he or she is correct or that the guess is high or low. Continue
 * accepting guesses until the user guesses correctly or chooses to quit. Use a sentinel value to determine
 * whether the user wants to quit. Count the number of guesses and report that value when the user
 * guesses correctly. At the end of each game ( by quitting or a correct guess), prompt to determine
 * whether the user wants to play again. Continue playing games until the user chooses to stop.
 */
import java.util.Random;
import java.util.Scanner;



public class count {
    public static void main(String[] args) {
        // create instance of Random class
        Random random = new Random();
        // Activate Scanner
        Scanner scanner = new Scanner(System.in);
        // Play Again feature is true, which activates the game unless Y is NOT entered
        boolean playAgain = true;

        // Greet User and prompt to play game        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Would you like to play? Type Y for Yes, or N for No");

        // Check if the player wants to play
        String response = scanner.nextLine().trim().toUpperCase();
        if (!response.equals("Y")) {
            System.out.println("Okay, maybe next time! Goodbye.");
            playAgain = false;
        }

        // Loop that plays the game
        while (playAgain) {

        System.out.println("I've picked a number between 1 and 100. Try to guess it!");

        // Generate a random number between 1 and 100 
        int randomNumber = random.nextInt(100) + 1;

        // Makes both variables start at 0 
        int userGuess = 0;
        int numberCount = 0;
        
        System.out.println("Guess the number between 1 and 100!");
        // Uncomment code below to display the random number for development purposes
        //System.out.println(randomNumber);

        // Loop that plays through until the user guesses the number
        while (userGuess != randomNumber) {
            System.out.print("\nEnter your guess: (Enter 0 to stop the game)");
            userGuess = scanner.nextInt();

            // If the user guess is below the number 
            if (userGuess <  randomNumber && userGuess != 0){
                System.out.println("Your guess was too low! Try again:");
                // Add +1 to number of guesses
                numberCount++;
            } 
            // If the user guess is above the number 
            else if (userGuess > randomNumber){
                System.out.println("Your guess was too high! Try again:");
                // Add +1 to number of guesses
                numberCount++;
            }
            // If the user inputs 0 to exit this round
            else if (userGuess == 0){
                System.out.println("Exiting Round... You guessed the number" + numberCount + " times!");
                break;
            } 
            // If the user is correct display this message alongside number count
            else {
                System.out.println("Congratulations! You guessed the number: " + randomNumber);
                System.out.println("You guessed " + numberCount + " times!");
                break;
            }
        }
        // Ask if the player wants to play again
        if (playAgain) {
            System.out.println("Would you like to play again? Type Y for Yes, or N for No");
            scanner.nextLine();  // Consume the newline left by nextInt()
            response = scanner.nextLine().trim().toUpperCase();
            if (!response.equals("Y")) {
                playAgain = false;
                System.out.println("Thanks for playing! Goodbye.");
            }
        }
    }
    scanner.close();
    }
}