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

    // Grab all score points
    static int player1Points = player1.getPoints();
    static int player2Points = player2.getPoints();
    static int computerPoints = computerPlayer.getPoints();
    static int tiePoints = 0; // Keep track of ties

    /**
     * This is the main method where our game starts. It welcomes the user with a message, and then calls upon the mainMenu method.
     */
    public static void main(String[] args) throws IOException {
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
        String userAnswer = userInput.nextLine().toLowerCase(); // Formats user's input and assigns it to a variable

        List<String> validAnswers = Arrays.asList("play", "scores", "quit");

        while (!validAnswers.contains(userAnswer)) { // Prompt user for different input if it's not a valid answer
            System.out.println("Enter A Different Answer: ");
            userAnswer = userInput.nextLine().toLowerCase();
        }

        // Calls upon different methods depending on user input
        if (userAnswer.equals("play")) {
            System.out.println("You chose play.");
            gameMode();
        } else if (userAnswer.equals("scores")) {
            System.out.println("You chose scores.");
            scores();
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
    public static void gameMode() throws IOException {
        System.out.println("You are Player 1. Is Player 2 a Human or Computer?");

        Scanner userInput = new Scanner(System.in); // Create Scanner object
        System.out.println("Player 2 is a: "); // Prompt user for input
        String userAnswer = userInput.nextLine().toLowerCase(); // Formats user's input and assigns it to a variable

        List<String> validAnswers = Arrays.asList("human", "computer");

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
        System.out.println("""
                        Type 'rock', 'paper', or 'scissors' to play.
                        Type 'quit' to go back to the main menu.
                        """
        );
    }

    /**
     * The getPlayer1Answer method returns player 1's answer as a String.
     * It obtains this string by using the player1 instance and applying the getManualAnswer method.
     * If the player enters "quit," they are taken back to the main menu.
     */
    public static String getHumanPlayerAnswer(Human player) throws IOException {
        String player1Answer = player.getManualAnswer(); // Get player 1's answer
        goToMainMenu(player1Answer); // Goes to main menu if a player types quit
        return player1Answer;
    }

    /**
     * The playComputer method uses the results of the getPlayerAnswer and getComputerAnswer methods.
     * It takes the two Strings and passes them as arguments for the compareAnswers method.
     */
    public static void playComputer() throws IOException {
        gameInstructions(); // Shows the player the game instructions first
        String player1Answer = getHumanPlayerAnswer(player1);
        System.out.println("Player 1 chose: " + player1Answer);
        determineWinner(player1Answer, computerPlayer); // Compares user and computer inputs to determine winner
    }

    /**
     * The playHuman method uses the results of the getPlayerAnswer method twice (once for each player).
     * It takes the two Strings and passes them as arguments for the compareAnswers method.
     */
    public static void playHuman() throws IOException {
        gameInstructions(); // Shows the player the game instructions first
        String player1Answer = getHumanPlayerAnswer(player1);
        System.out.println("Player 1 chose: " + player1Answer);
        determineWinner(player1Answer, player2); // Compares both inputs to determine winner
    }

    /**
     *     The determineWinner method takes in two strings,
     *     and uses if-else statements to determine the win condition of each round.
     *     It prints out which player won, and adds 1 to the winner's point score.
     *     After each round, the player is taken back to the main menu.
     */
    public static void determineWinner(String player1Answer, Player player2) throws IOException {
        String player2Answer;
        Player player2Type;
        List<String> player2Result;
        List<String> player2Skip;

        if (player2 instanceof Human){
            player2Answer = getHumanPlayerAnswer((Human) player2);
            System.out.println("Player 2 chose: " + player1Answer);
            movesTracker(player1Answer, player2Answer, " - ");
            player2Result = player2Tracker;
            player2Skip = computerTracker;
            player2Type = player2;
        } else {
            player2Answer = computerPlayer.getRandomAnswer(); // This is the randomly-generated computer answer
            System.out.println("Player 2 chose: " + player2Answer + " (Computer)");
            player2Type = computerPlayer;
            movesTracker(player1Answer, " - ", player2Answer);
            player2Result = computerTracker;
            player2Skip = player2Tracker;
        }

        if (player1Answer.equals(player2Answer)){
            System.out.println("It's a tie!");
            tiePoints = tiePoints + 1;
            player1Tracker.add("Tie");
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

        writeFile(tiePoints, player1Points, player2Points, computerPoints,
                            player1Tracker, player2Tracker, computerTracker,
                            player1Moves, player2Moves, computerMoves);
        mainMenu(); // Takes player to main menu for next round
    }

    /**
     * The movesTracker method takes in the move strings, and adds each player's move to the array list of their moves.
     */
    public static void movesTracker(String player1Answer, String player2Answer, String computerAnswer){
        player1Moves.add(player1Answer);
        player2Moves.add(player2Answer);
        computerMoves.add(computerAnswer);
    }

    /**
     * The gameHistory method prints out the running history of the game, including points, round results, and move history.
     */
    public static void scores() throws IOException {
        System.out.println("These are the current scores.");

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
     * The writeFile method takes in all the parameters that we want to track for each round of the game, and writes it into an output.txt file.
     * It then increments the game number counter by 1.
     * We throw an IOException (an input/output exception) because then it accounts for the file not existing.
     */
    public static void writeFile(int tiePoints, int player1Points, int player2Points, int computerPoints,
                                 List<String> player1Result, List<String> player2Result, List<String> computerResult,
                                 List<String> player1Moves, List<String> player2Moves, List<String> computerMoves
                                 ) throws IOException {
        Path pathToFile = Paths.get("GameHistory.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(Paths.get(pathToFile.toUri()).toFile(), true));

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
     */
    public static void goToMainMenu(String answer) throws IOException {
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