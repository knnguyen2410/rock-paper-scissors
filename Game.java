import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        mainMenu();
    }

    /**
     * The mainMenu method prints out the game's main menu text when the game is first started.
     * The format with line breaks is kept in the method body. This way, we can visualize how it will look to the player.
     * A Scanner object is used to obtain the user's input and assign it to a String variable.
     * The user's input is formatted so that all letters are lowercase.
     * If the user's input is not a valid answer from the validAnswer list, the user is prompted to enter a different input.
     * Depending on the user's input, a different method is called.
     */
    public static void mainMenu() {
        System.out.println(
                "Welcome to Rock, Paper, Scissors! \n"
                        + "\n" +
                        "MAIN MENU" + "\n" +
                        "=====" + "\n" +
                        "1. Type 'play' to play." + "\n" +
                        "2. Type 'history' to view your game history." + "\n" +
                        "3. Type 'quit' to stop playing." + "\n"
        );

        Scanner userInput = new Scanner(System.in); // Create Scanner object
        System.out.println("Enter Your Answer: "); // Prompt user for input
        String userAnswer = userInput.nextLine().toLowerCase(); // Formats user's input and assigns it to a variable

        List validAnswers = Arrays.asList("play", "history", "quit");

        while (!validAnswers.contains(userAnswer)) { // Prompt user for different input if it's not a valid answer
            System.out.println("Enter A Different Answer: ");
            userAnswer = userInput.nextLine().toLowerCase();
        }

        // Calls upon different methods depending on user input
        if (userAnswer.equals("play")) {
            System.out.println("You chose play.");
            gameMode();
        } else if (userAnswer.equals("history")) {
            System.out.println("You chose history.");
            gameHistory();
        } else {
            System.out.println("You chose quit. The game will end.");
            gameQuit();
        }
    }

    /**
     * The gameMode method calls upon another method depending on the user's input.
     * The user's input is obtained using a Scanner object.
     * The user's input is formatted so that all letters are lowercase.
     * If the user's input is not a valid answer from the validAnswer list, the user is prompted to enter a different input.
     * Depending on the input, the user can play against another human using the same computer, or play against a computer.
     */
    public static void gameMode() {
        System.out.println("You are Player 1." + "\n" + "Is Player 2 a Human or Computer?");

        Scanner userInput = new Scanner(System.in); // Create Scanner object
        System.out.println("Player 2 is a: "); // Prompt user for input
        String userAnswer = userInput.nextLine().toLowerCase(); // Formats user's input and assigns it to a variable

        List validAnswers = Arrays.asList("human", "computer");

        while (!validAnswers.contains(userAnswer)) { // Prompt user for different input if it's not a valid answer
            System.out.println("Enter A Different Answer: ");
            userAnswer = userInput.nextLine().toLowerCase();
        }

        // Calls upon different methods depending on user input
        if (userAnswer.equals("human")) {
            System.out.println("Player 2 is a human.");
            playHuman();
        } else {
            System.out.println("Player 2 is a computer.");
            playComputer();
        }
    }

    /**
     * The gameInstructions method prints out the game's instructions text.
     */
    public static void gameInstructions(){
        System.out.println(
                "Type 'rock', 'paper', or 'scissors' to play." + "\n" +
                "Type 'quit' to go back to the main menu." + "\n"
        );
    }

    /**
     *     The compareAnswers method uses if-else statements to determine the win condition of each round.
     *     After each round, the player is taken back to the main menu.
     */
    public static void compareAnswers(String answer1, String answer2){
        System.out.println("Player 1 Chose: " + answer1);
        System.out.println("Player 2 Chose: " + answer2);

        if (answer1.equals(answer2)){
            System.out.println("It's a tie!");
        } else if (answer1.equals("rock")){
            if (answer2.equals("paper")){
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("Player 1 wins!");
            }
        } else if (answer1.equals("paper")) {
            if (answer2.equals("scissors")){
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("Player 1 wins!");
            }
        } else if (answer1.equals("scissors")){
            if (answer2.equals("rock")){
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("Player 1 wins!");
            }
        }

        mainMenu(); // Returns to main menu after every round
    }

    /**
     * The playComputer method uses the results of the getPlayerAnswer and getComputerAnswer methods.
     * It takes the two Strings and passes them as arguments for the compareAnswers method.
     */
    public static void playComputer(){
        gameInstructions(); // Shows the player the game instructions first

        String playerAnswer = getPlayerAnswer(); // This is the user's input
        System.out.println(playerAnswer);

        String computerAnswer = getComputerAnswer(); // This is the randomly-generated computer answer
        System.out.println(computerAnswer);

        compareAnswers(playerAnswer, computerAnswer); // Compares user and computer inputs to determine winner
    }

    /**
     * The getComputerAnswer method uses a random number generator which acts as the computer's input.
     * The method generates a number from 0-2, and each number corresponds to a different rock/paper/scissors move for the computer.
     * The resulting string is then returned.
     */
    public static String getComputerAnswer() {
        Random randomInstance = new Random(); // Create a new instance of the random class
        int randomNumber = randomInstance.nextInt(3); // Generates random integer from 0-2
        String computerAnswer = "";
        if (randomNumber == 0) { // Computer answer updates based on random number generated
            computerAnswer = "rock";
        } else if (randomNumber == 1) {
            computerAnswer = "paper";
        } else {
            computerAnswer = "scissors";
        }
        return computerAnswer;
    }





    public static void playHuman(){
        gameInstructions(); // Shows the player the game instructions first

        getPlayerAnswer();
    }

    /**
     * The getPlayerAnswer method obtains a user's input using a Scanner object.
     * The user's input is formatted so that all letters are lowercase.
     * If the user's input is not a valid answer from the validAnswer list, the user is prompted to enter a different input.
     * Depending on the input, the user is either taken back to the main menu, or the method returns the user input string.
     */
    public static String getPlayerAnswer() {

        Scanner userInput = new Scanner(System.in); // Create Scanner object
        System.out.println("Enter Your Answer: "); // Prompt user for input
        String userAnswer = userInput.nextLine().toLowerCase(); // Formats user's input and assigns it to variable

        List validAnswers = Arrays.asList("rock", "paper", "scissors", "quit");

        while (!validAnswers.contains(userAnswer)) { // Prompt user for different input if it's not a valid answer
            System.out.println("Enter A Different Answer: ");
            userAnswer = userInput.nextLine().toLowerCase();
        }

        // Calls upon different methods depending on user input
        if (userAnswer.equals("quit")) {
            System.out.println("You chose quit. Go to the main menu.");
            mainMenu();
        }

        return userAnswer;
    }





    public static void gameHistory() {

    }

    /**
     * The gameQuit method exits the program by terminating the JVM with an exit code 0.
     */
    public static void gameQuit() {
        System.out.println("Thanks for playing!");
        System.exit(0); // exit code 0 indicates successful program termination
    }
}