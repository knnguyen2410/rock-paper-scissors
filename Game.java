import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        mainMenu();
        instructions();
        getUserInput();
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
}
