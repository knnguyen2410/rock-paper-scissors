import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        mainMenu();
        instructions();
        getUserInput();
        getComputerInput();
    }

    /**
     * The mainMenu method prints out the game's main menu text when the game is first started.
     * The format with line breaks is kept in the method body.
     * This way, we can visualize how it will look to the player.
     */
    public static void mainMenu(){
        System.out.println(
                "Welcome to Rock, Paper, Scissors!" + "\n"
                        + "\n" +
                        "MAIN MENU" + "\n" +
                        "=====" + "\n" +
                        "1. Type 'play' to play." + "\n" +
                        "2. Type 'history' to view your game history." + "\n" +
                        "3. Type 'quit' to stop playing." + "\n"
        );
    }

    /**
     * The instructions method prints out the game's instructions text, which show after the player enters 'play'.
     * The format with line breaks is kept in the method body.
     * This way, we can visualize how it will look to the player.
     */
    public static void instructions(){
        System.out.println(
                "Type 'rock', 'paper', or 'scissors' to play." + "\n" +
                        "Type 'quit' to go back to the main menu." + "\n"
        );
    }

    /**
     * The getUserInput method uses a Scanner object to obtain the user's input and assign it to a String variable.
     */
    public static void getUserInput(){
        Scanner userInput = new Scanner(System.in); // Create Scanner object
        System.out.println("Enter Your Answer: "); // Prompt user for input

        String userAnswer = userInput.nextLine(); // Assigns user's input into a variable which we can manipulate later
        System.out.println("Your Answer Was: " + userAnswer);
    }

    /**
     * The getComputerInput method uses a random number generator which acts as the computer's input.
     * The method generates a number from 0-2,
     * and each number corresponds to a different rock/paper/scissors move for the computer.
     */
    public static void getComputerInput(){
        Random randomInstance = new Random(); // Create a new instance of the random class
        int randomNumber = randomInstance.nextInt(3); // Generates random integer from 0-2
        String computerAnswer = "";
        if (randomNumber == 0){ // Computer answer updates based on random number generated
            computerAnswer = "Rock";
        } else if (randomNumber == 1) {
            computerAnswer = "Paper";
        } else {
            computerAnswer = "Scissors";
        }
        System.out.println(randomNumber);
        System.out.println(computerAnswer);
    }
}
