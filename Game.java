import java.sql.SQLOutput;
import java.util.*;

public class Game {

    // Create empty array lists for each player's result at the end of each round
    static List<String> player1Result = new ArrayList<>(); // Initialize an empty results list for player1
    static List<String> player2Result = new ArrayList<>(); // Initialize an empty results list for player2
    static List<String> computerResult = new ArrayList<>(); // Initialize an empty results list for computer

    // Create empty array lists for each player's moves
    static List<String> player1Moves = new ArrayList<>(); // Initialize an empty moves list for player1
    static List<String> player2Moves = new ArrayList<>(); // Initialize an empty moves list for player2
    static List<String> computerMoves = new ArrayList<>(); // Initialize an empty moves list for computer

    // Create instances of each possible player in this game (human player 1, human player 2, computer)
    static Human player1 = new Human(player1Result, 0, player1Moves);  // Create player 1 instance
    static Human player2 = new Human(player2Result, 0, player2Moves); // Create player 2 instance
    static Computer computerPlayer = new Computer(computerResult, 0, computerMoves); // Create instance of Computer class

    // Grab all score points
    static int tiePoints = 0; // Keep track of ties
    static int player1Points = player1.getPoints();
    static int player2Points = player2.getPoints();
    static int computerPoints = computerPlayer.getPoints();

    public static void main(String[] args) {
        System.out.println("Welcome to Rock, Paper, Scissors! \n"); // Welcome message
        mainMenu(); // Takes user to main menu to start the game
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
     * The playComputer method uses the results of the getPlayerAnswer and getComputerAnswer methods.
     * It takes the two Strings and passes them as arguments for the compareAnswers method.
     */
    public static void playComputer(){
        gameInstructions(); // Shows the player the game instructions first

        String player1Answer = player1.getManualAnswer(); // Get player 1's answer
        goToMainMenu(player1Answer);

        String computerAnswer = computerPlayer.getRandomAnswer(); // This is the randomly-generated computer answer

        System.out.println("Player 1 chose: " + player1Answer);
        System.out.println("Player 2 chose: " + computerAnswer + " (Computer)");

        movesTracker(player1Answer, "N/A", computerAnswer);
        determineWinnerVSComputer(player1Answer, computerAnswer); // Compares user and computer inputs to determine winner
    }

    /**
     * The playHuman method uses the results of the getPlayerAnswer method twice (once for each player).
     * It takes the two Strings and passes them as arguments for the compareAnswers method.
     */
    public static void playHuman(){
        gameInstructions(); // Shows the player the game instructions first

        String player1Answer = player1.getManualAnswer(); // Get player 1's answer
        System.out.println("Player 1 chose: " + player1Answer);
        goToMainMenu(player1Answer); // Goes to main menu if a player types quit

        String player2Answer = player2.getManualAnswer(); // Get player 2's answer
        System.out.println("Player 2 chose: " + player2Answer);
        goToMainMenu(player2Answer); // Goes to main menu if a player types quit

        movesTracker(player1Answer, player2Answer, "N/A");
        determineWinnerVSHuman(player1Answer, player2Answer); // Compares both inputs to determine winner
    }

    public static void movesTracker(String player1Answer, String player2Answer, String computerAnswer){
        player1Moves.add(player1Answer);
        player2Moves.add(player2Answer);
        computerMoves.add(computerAnswer);
    }

    /**
     *     The determineWinner method takes in two strings,
     *     and uses if-else statements to determine the win condition of each round.
     *     It prints out which player won, and adds 1 to the winner's point score.
     *     After each round, the player is taken back to the main menu.
     */
    public static void determineWinnerVSComputer(String player1Answer, String computerAnswer){
        if (player1Answer.equals(computerAnswer)){
            System.out.println("It's a tie!");
            tiePoints = tiePoints + 1;
            player1Result.add("Tie");
            player2Result.add("N/A");
            computerResult.add("Tie");
        } else if (player1Answer.equals("rock")){
            if (computerAnswer.equals("paper")){
                System.out.println("Player 2 wins!");
                computerPoints = computerPoints + 1;
                computerPlayer.setPoints(computerPoints);
                player1Result.add("Lose");
                player2Result.add("N/A");
                computerResult.add("Win");
            } else {
                System.out.println("Player 1 wins!");
                player1Points = player1Points + 1;
                player1.setPoints(player1Points);
                player1Result.add("Win");
                player2Result.add("N/A");
                computerResult.add("Lose");
            }
        } else if (player1Answer.equals("paper")) {
            if (computerAnswer.equals("scissors")){
                System.out.println("Player 2 wins!");
                computerPoints = computerPoints + 1;
                computerPlayer.setPoints(computerPoints);
                player1Result.add("Lose");
                player2Result.add("N/A");
                computerResult.add("Win");
            } else {
                System.out.println("Player 1 wins!");
                player1Points = player1Points + 1;
                player1.setPoints(player1Points);
                player1Result.add("Win");
                player2Result.add("N/A");
                computerResult.add("Lose");
            }
        } else if (player1Answer.equals("scissors")){
            if (computerAnswer.equals("rock")){
                System.out.println("Player 2 wins!");
                computerPoints = computerPoints + 1;
                computerPlayer.setPoints(computerPoints);
                player1Result.add("Lose");
                player2Result.add("N/A");
                computerResult.add("Win");
            } else {
                System.out.println("Player 1 wins!");
                player1Points = player1Points + 1;
                player1.setPoints(player1Points);
                player1Result.add("Win");
                player2Result.add("N/A");
                computerResult.add("Lose");
            }
        }

        mainMenu(); // Takes player to main menu for next round
    }

    /**
     *     The determineWinner method takes in two strings,
     *     and uses if-else statements to determine the win condition of each round.
     *     It prints out which player won, and adds 1 to the winner's point score.
     *     After each round, the player is taken back to the main menu.
     */
    public static void determineWinnerVSHuman(String player1Answer, String player2Answer){
        if (player1Answer.equals(player2Answer)){
            System.out.println("It's a tie!");
            tiePoints = tiePoints + 1;
            player1Result.add("Tie");
            player2Result.add("Tie");
            computerResult.add("N/A");
        } else if (player1Answer.equals("rock")){
            if (player2Answer.equals("paper")){
                System.out.println("Player 2 wins!");
                player2Points = player2Points + 1;
                player2.setPoints(player2Points);
                player1Result.add("Lose");
                player2Result.add("Win");
                computerResult.add("N/A");
            } else {
                System.out.println("Player 1 wins!");
                player1Points = player1Points + 1;
                player1.setPoints(player1Points);
                player1Result.add("Win");
                player2Result.add("Lose");
                computerResult.add("N/A");
            }
        } else if (player1Answer.equals("paper")) {
            if (player2Answer.equals("scissors")){
                System.out.println("Player 2 wins!");
                player2Points = player2Points + 1;
                player2.setPoints(player2Points);
                player1Result.add("Lose");
                player2Result.add("Win");
                computerResult.add("N/A");
            } else {
                System.out.println("Player 1 wins!");
                player1Points = player1Points + 1;
                player1.setPoints(player1Points);
                player1Result.add("Win");
                player2Result.add("Lose");
                computerResult.add("N/A");
            }
        } else if (player1Answer.equals("scissors")){
            if (player2Answer.equals("rock")){
                System.out.println("Player 2 wins!");
                player2Points = player2Points + 1;
                player2.setPoints(player2Points);
                player1Result.add("Lose");
                player2Result.add("Win");
                computerResult.add("N/A");
            } else {
                System.out.println("Player 1 wins!");
                player1Points = player1Points + 1;
                player1.setPoints(player1Points);
                player1Result.add("Win");
                player2Result.add("Lose");
                computerResult.add("N/A");
            }
        }

        mainMenu(); // Takes player to main menu for next round
    }

    public static void gameHistory() {
        System.out.println("This is the game History");

        System.out.println("Number of ties: " + tiePoints);
        System.out.println("Player 1 Points: " + player1.getPoints());
        System.out.println("Player 2 Points (Human): " + player2.getPoints());
        System.out.println("Player 2 Points (Computer): " + computerPlayer.getPoints());

        System.out.println("Player 1 Results: " + player1Result);
        System.out.println("Player 2 Results: " + player2Result);
        System.out.println("Computer Results: " + computerResult);

        System.out.println("Player 1 Moves: " + player1Moves);
        System.out.println("Player 2 Moves: " + player2Moves);
        System.out.println("Computer Moves: " + computerMoves);

        mainMenu();
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

    /**
     * The gameQuit method exits the program by terminating the JVM with an exit code 0.
     */
    public static void gameQuit() {
        System.out.println("Thanks for playing!");
        System.exit(0); // exit code 0 indicates successful program termination
    }
}