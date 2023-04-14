import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

/**
 * This Game class contains the main method, which is where the game execution starts.
 * The class also contains initialized variables for the player instances,
 * and additional methods that chain on each other to create a functioning game.
 */
public class Game {
    // Create empty array lists for each player's result at the end of each round
    static List<String> player1Tracker = new ArrayList<>();
    static List<String> player2Tracker = new ArrayList<>();
    static List<String> computerTracker = new ArrayList<>();

    // Create empty array lists for each player's moves
    static List<String> player1Moves = new ArrayList<>();
    static List<String> player2Moves = new ArrayList<>();
    static List<String> computerMoves = new ArrayList<>();

    // Create instances of each possible player in this game (human player 1, human player 2, computer)
    static Human player1 = new Human(player1Tracker, 0, player1Moves);  // Create player 1 instance
    static Human player2 = new Human(player2Tracker, 0, player2Moves); // Create player 2 instance
    static Computer computerPlayer = new Computer(computerTracker, 0, computerMoves); // Create instance of Computer class

    // Get all score points from the instances
    static int player1Points = player1.getPoints();
    static int player2Points = player2.getPoints();
    static int computerPoints = computerPlayer.getPoints();
    static int tiePoints = 0; // Keep track of ties

    /**
     * This is the main method where our game starts. It welcomes the user with a message, and then calls upon the mainMenu method.
     * @param args - This method takes in a parameter called args, which is a list of Strings.
     * @throws IOException - This is due to the writeFile method, and accounts for an input/output exception error if the GameHistory.txt file is not found.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Rock, Paper, Scissors!"); // Welcome message
        mainMenu(); // Takes user to main menu to start the game
    }

    /**
     * The mainMenu method prints out the game's main menu text when the game is first started.
     * The format with line breaks is kept in the method body. This way, we can visualize how it will look to the player.
     * A Scanner object is used to obtain the user's input and assign it to a String variable.
     * The user's input is formatted so that all letters are lowercase and whitespace is removed.
     * If the user's input is not a valid answer from the validAnswer list, the user is prompted to enter a different input.
     * Depending on the user's input, a different method is called.
     * @throws IOException - This is due to the writeFile method, and accounts for an input/output exception error if the GameHistory.txt file is not found.
     */
    public static void mainMenu() throws IOException {
        System.out.println("""
                        
                        MAIN MENU
                        =====
                        1. Type 'play' to play.
                        2. Type 'scores' to view the current scores.
                        3. Type 'quit' to stop playing.
                        """
        );

        Scanner userInput = new Scanner(System.in); // Create Scanner object
        System.out.println("Enter Your Answer: "); // Prompt user for input
        String userAnswer = userInput.nextLine().toLowerCase().trim(); // Formats user's input and assigns it to a variable

        List<String> validAnswers = Arrays.asList("play", "scores", "quit");

        while (!validAnswers.contains(userAnswer)) { // Prompt user for different input if it's not a valid answer
            System.out.println("Enter A Different Answer: ");
            userAnswer = userInput.nextLine().toLowerCase().trim();
        }

        // Calls upon different methods depending on user input
        if (userAnswer.equals("play")) {
            System.out.println("You chose play.");
            gameMode(); // Asks player to select their game mode (2 players or vs computer)
        } else if (userAnswer.equals("scores")) {
            System.out.println("You chose scores.");
            scores(); // Shows player current game scores
        } else {
            System.out.println("You chose quit.");
            gameQuit(); // Terminates the program
        }
    }

    /**
     * The gameMode method calls upon another method depending on the user's input.
     * Depending on the input, the user can play against another human using the same computer, or play against a computer.
     * The user's input is obtained using a Scanner object.
     * The user's input is formatted so that all letters are lowercase and whitespace is removed.
     * If the user's input is not a valid answer from the validAnswer list, the user is prompted to enter a different input.
     * @throws IOException - This is due to the writeFile method, and accounts for an input/output exception error if the GameHistory.txt file is not found.
     */
    public static void gameMode() throws IOException {
        System.out.println("\n" + "You are Player 1. Is Player 2 a Human or Computer?");

        Scanner userInput = new Scanner(System.in); // Create Scanner object
        System.out.println("Player 2 is a: "); // Prompt user for input
        String userAnswer = userInput.nextLine().toLowerCase().trim(); // Formats user's input and assigns it to a variable

        List<String> validAnswers = Arrays.asList("human", "computer");

        while (!validAnswers.contains(userAnswer)) { // Prompt user for different input if it's not a valid answer
            System.out.println("Enter A Different Answer: ");
            userAnswer = userInput.nextLine().toLowerCase().trim();
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
        System.out.println("""
                        
                        Type 'rock', 'paper', or 'scissors' to play.
                        Type 'quit' to go back to the main menu."""
        );
    }

    /**
     * The getHumanPlayerAnswer method returns a human instance's answer as a String.
     * It obtains this string by using the human instance argument and applying the getManualAnswer method.
     * If the player enters "quit," they are taken back to the main menu.
     * @param player - This allows us to choose between different Human player instances (player1 or player2)
     * @return - Returns a string of the player answer
     * @throws IOException - This is due to the writeFile method, and accounts for an input/output exception error if the GameHistory.txt file is not found.
     */
    public static String getHumanPlayerAnswer(Human player) throws IOException {
        // Gets a human player's answer. Which human player is determined by the parameter (Human player1 vs Human player2 instance)
        String playerAnswer = player.getManualAnswer();
        goToMainMenu(playerAnswer); // Goes to main menu if a player types quit
        return playerAnswer;
    }

    /**
     * The playComputer method first shows the player the game instructions.
     * It then gets the player1Answer by using the getHumanPlayerAnswer method and passing player1 as the argument,
     * and then prints out that answer.
     * It then calls upon the determineWinner method, passing the player1Answer string as the first argument,
     * and the computerPlayer instance of the Computer class as the second argument.
     * @throws IOException - This is due to the writeFile method, and accounts for an input/output exception error if the GameHistory.txt file is not found.
     */
    public static void playComputer() throws IOException {
        gameInstructions(); // Shows the player the game instructions first
        String player1Answer = getHumanPlayerAnswer(player1);
        System.out.println("Player 1 chose: " + player1Answer);
        determineWinner(player1Answer, computerPlayer); // This will allow us to compare player1 and computer inputs to determine winner
    }

    /**
     * The playHuman method first shows the player the game instructions.
     * It then gets the player1Answer by using the getHumanPlayerAnswer method and passing player1 as the argument,
     * and then prints out that answer.
     * It then calls upon the determineWinner method, passing the player1Answer string as the first argument,
     * and the player2 instance of the Human class as the second argument.
     * @throws IOException - This is due to the writeFile method, and accounts for an input/output exception error if the GameHistory.txt file is not found.
     */
    public static void playHuman() throws IOException {
        gameInstructions(); // Shows the player the game instructions first
        String player1Answer = getHumanPlayerAnswer(player1);
        System.out.println("Player 1 chose: " + player1Answer);
        determineWinner(player1Answer, player2); // This will allow us to compare player1 and player2 inputs to determine winner
    }

    /**
     * The determineWinner method has two parameters - the first one is the string of Human player1's answer,
     * and the second is an object of the Player class. This lets us switch between Human and Computer instances for player 2.
     * The method has 4 player2 status variables that will be changed depending on if player2 is a Human or Computer instance:
     * The method uses if-else statements to determine the winner between player1 and player2,
     * and updates the player2 status variables accordingly.
     * It prints out which player won, and adds 1 to the winner's point score.
     * After each round, the results are written to the GameHistory.txt file,
     * and the player(s) is taken back to the main menu.
     * @param player1Answer - This is a string of player1's answer, and is what player2's answer will be compared to.
     * @param player2 - The argument passed for this parameter can be either a Human or Computer instance of the Player class.
     * @throws IOException - This is due to the writeFile method, and accounts for an input/output exception error if the GameHistory.txt file is not found.
     */
    public static void determineWinner(String player1Answer, Player player2) throws IOException {
        // Status variables of player2 that will be changed depending on win-condition.
        String player2Answer;
        Player player2Type;
        List<String> player2Result;
        List<String> player2Skip;

        // Assigns status variables to corresponding instance values (whether player2 is Human or Computer)
        if (player2 instanceof Human){
            player2Answer = getHumanPlayerAnswer((Human) player2);
            System.out.println("Player 2 chose: " + player2Answer + "\n");
            movesTracker(player1Answer, player2Answer, " - ");
            player2Result = player2Tracker;
            player2Skip = computerTracker;
            player2Type = player2;
        } else {
            player2Answer = computerPlayer.getRandomAnswer(); // This is the randomly-generated computer answer
            System.out.println("\n" + "Player 2 chose: " + player2Answer + " (Computer)" + "\n");
            player2Type = computerPlayer;
            movesTracker(player1Answer, " - ", player2Answer);
            player2Result = computerTracker;
            player2Skip = player2Tracker;
        }

        // Checks for the win condition and updates player1 and player2 stats
        if (player1Answer.equals(player2Answer)){ // Compares player1 and player2 answers
            System.out.println("It's a tie!"); // Declares result of the game or winner
            tiePoints = tiePoints + 1; // Increases relevant point counter
            player1Tracker.add("Tie"); // Adds game result for each player to their respective tracker
            player2Result.add("Tie");
            player2Skip.add(" - ");
        } else if (player1Answer.equals("rock")){
            if (player2Answer.equals("paper")){
                System.out.println("Player 2 wins!");
                player2Points = player2Points + 1;
                player2Type.setPoints(player2Points);
                player1Tracker.add("Lose");
                player2Result.add("Win");
                player2Skip.add(" - ");
            } else {
                System.out.println("Player 1 wins!");
                player1Points = player1Points + 1;
                player1.setPoints(player1Points);
                player1Tracker.add("Win");
                player2Result.add("Lose");
                player2Skip.add(" - ");
            }
        } else if (player1Answer.equals("paper")) {
            if (player2Answer.equals("scissors")){
                System.out.println("Player 2 wins!");
                player2Points = player2Points + 1;
                player2Type.setPoints(player2Points);
                player1Tracker.add("Lose");
                player2Result.add("Win");
                player2Skip.add(" - ");
            } else {
                System.out.println("Player 1 wins!");
                player1Points = player1Points + 1;
                player1.setPoints(player1Points);
                player1Tracker.add("Win");
                player2Result.add("Lose");
                player2Skip.add(" - ");
            }
        } else if (player1Answer.equals("scissors")){
            if (player2Answer.equals("rock")){
                System.out.println("Player 2 wins!");
                player2Points = player2Points + 1;
                player2Type.setPoints(player2Points);
                player1Tracker.add("Lose");
                player2Result.add("Win");
                player2Skip.add(" - ");
            } else {
                System.out.println("Player 1 wins!");
                player1Points = player1Points + 1;
                player1.setPoints(player1Points);
                player1Tracker.add("Win");
                player2Result.add("Lose");
                player2Skip.add(" - ");
            }
        }

        // Writes results to the GameHistory.txt file
        writeFile(tiePoints, player1Points, player2Points, computerPoints,
                            player1Tracker, player2Tracker, computerTracker,
                            player1Moves, player2Moves, computerMoves);
        mainMenu(); // Takes player to main menu for next round
    }

    /**
     * The movesTracker method takes in the move strings, and adds each player's move to the array list of their moves.
     * @param player1Answer - human player1's answer String
     * @param player2Answer - human player2's answer String
     * @param computerAnswer - computer's answer String
     */
    public static void movesTracker(String player1Answer, String player2Answer, String computerAnswer){
        player1Moves.add(player1Answer);
        player2Moves.add(player2Answer);
        computerMoves.add(computerAnswer);
    }

    /**
     * The gameHistory method prints out the running history of the game, including points, round results, and move history.
     * It immediately takes the player back to the main menu.
     * @throws IOException - This is due to the writeFile method, and accounts for an input/output exception error if the GameHistory.txt file is not found.
     */
    public static void scores() throws IOException {
        System.out.println("\n" + "These are the current scores.");

        System.out.println("Number of ties: " + tiePoints);
        System.out.println("Player 1 Points: " + player1Points);
        System.out.println("Player 2 Points (Human): " + player2Points);
        System.out.println("Player 2 Points (Computer): " + computerPoints);

        System.out.println("Player 1 Results: " + player1Tracker);
        System.out.println("Player 2 Results: " + player2Tracker);
        System.out.println("Computer Results: " + computerTracker);

        System.out.println("Player 1 Moves: " + player1Moves);
        System.out.println("Player 2 Moves: " + player2Moves);
        System.out.println("Computer Moves: " + computerMoves);

        mainMenu();
    }

    /**
     * The writeFile method takes in all the parameters that we want to track for each round of the game, and writes it into the GameHistory.txt file.
     * The GameHistory.txt file keeps track of all games played, and the length of each move and result list indicates the number of rounds so far.
     * @param tiePoints - number of ties in the game so far
     * @param player1Points - human player 1's points so far
     * @param player2Points - human player 2's points so far
     * @param computerPoints - computer player 2's points so far
     * @param player1Result - if player 1 has won, lost, or tied
     * @param player2Result - if player 2 has won, lost, or tied
     * @param computerResult - if computer has won, lost, or tied
     * @param player1Moves - list of player 1's moves
     * @param player2Moves - list of player 2's moves
     * @param computerMoves - list of computer's moves
     * @throws IOException - This is due to the writeFile method, and accounts for an input/output exception error if the GameHistory.txt file is not found.
     */
    public static void writeFile(int tiePoints, int player1Points, int player2Points, int computerPoints,
                                 List<String> player1Result, List<String> player2Result, List<String> computerResult,
                                 List<String> player1Moves, List<String> player2Moves, List<String> computerMoves
                                 ) throws IOException {
        Path pathToFile = Paths.get("GameHistory.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(Paths.get(pathToFile.toUri()).toFile(), true));

        // Include a timestamp to distinguish rounds played
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        writer.write("Round played on: " + java.time.LocalDateTime.now().format(formatter) + "\n" + "\n");

        writer.write("Number of ties: " + tiePoints + "\n");
        writer.write("Player 1 Points: " + player1Points + "\n");
        writer.write("Player 2 Points (Human): " + player2Points + "\n");
        writer.write("Player 2 Points (Computer): " + computerPoints + "\n" + "\n");

        writer.write("Player 1 Results: " + player1Result + "\n");
        writer.write("Player 2 Results: " + player2Result + "\n");
        writer.write("Computer Results: " + computerResult + "\n" + "\n");

        writer.write("Player 1 Moves: " + player1Moves + "\n");
        writer.write("Player 2 Moves: " + player2Moves + "\n");
        writer.write("Computer Moves: " + computerMoves + "\n" + "\n");

        writer.close();
    }

    /**
     * The goToMainMenu method calls on the mainMenu method if the string parameter is "quit".
     * @param answer - Looks at the player's input and sees if they entered "quit"
     * @throws IOException - This is due to the writeFile method, and accounts for an input/output exception error if the GameHistory.txt file is not found.
     */
    public static void goToMainMenu(String answer) throws IOException {
        if (answer.equals("quit")) {
            System.out.println("\n" + "You chose quit. Go to the main menu.");
            mainMenu();
        }
    }

    /**
     * The gameQuit method exits the program by terminating the JVM with an exit code 0.
     */
    public static void gameQuit() {
        System.out.println("\n" + "The game will end. Thanks for playing!");
        System.exit(0); // exit code 0 indicates successful program termination
    }
}