import java.sql.SQLOutput;
import java.util.*;

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
        System.out.println("You are Player 1. Is Player 2 a Human or Computer?");

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
     *     The determineWinner method takes in two strings,
     *     and uses if-else statements to determine the win condition of each round.
     *     It prints out which player won.
     *     After each round, the player is taken back to the main menu.
     */
    public static void determineWinner(String answer1, String answer2){
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

        List<String> player1Moves = new ArrayList<>(); // Initialize an empty moves list for player1
        Human player1 = new Human("", 0, player1Moves);  // Create player 1 instance
        String player1Answer = player1.getManualAnswer(); // Get player 1's answer
        goToMainMenu(player1Answer);

        List<String> computerMoves = new ArrayList<>(); // Initialize an empty moves list for computer
        Computer computerPlayer = new Computer("", 0, computerMoves); // Create instance of Computer class
        String computerAnswer = computerPlayer.getRandomAnswer(); // This is the randomly-generated computer answer

        System.out.println("Player 1 chose: " + player1Answer);
        System.out.println("Player 2 chose: " + computerAnswer + " (Computer)");
        determineWinner(player1Answer, computerAnswer); // Compares user and computer inputs to determine winner
    }

    /**
     * The playHuman method uses the results of the getPlayerAnswer method twice (once for each player).
     * It takes the two Strings and passes them as arguments for the compareAnswers method.
     */
    public static void playHuman(){
        gameInstructions(); // Shows the player the game instructions first

        List<String> player1Moves = new ArrayList<>(); // Initialize an empty moves list for player1
        Human player1 = new Human("", 0, player1Moves);  // Create player 1 instance

        List<String> player2Moves = new ArrayList<>(); // Initialize an empty moves list for player2
        Human player2 = new Human("", 0, player2Moves); // Create player 2 instance

        String player1Answer = player1.getManualAnswer(); // Get player 1's answer
        System.out.println("Player 1 chose: " + player1Answer);
        goToMainMenu(player1Answer); // Goes to main menu if a player types quit

        String player2Answer = player2.getManualAnswer(); // Get player 2's answer
        System.out.println("Player 2 chose: " + player2Answer);
        goToMainMenu(player2Answer); // Goes to main menu if a player types quit

        determineWinner(player1Answer, player2Answer); // Compares both inputs to determine winner
    }

    /**
     * The goToMainMenu method calls on the mainMenu method if the string parameter is "quit".
     * @param answer
     */
    public static void goToMainMenu(String answer){
        if (answer.equals("quit")) {
            System.out.println("You chose quit. Go to the main menu.");
            mainMenu();
        }
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