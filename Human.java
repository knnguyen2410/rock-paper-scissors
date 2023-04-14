import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This Human class is a subclass of the abstract Player class, and implements the ManualAnswer interface.
 * By creating a Human class, I can then create an instance of a human player,
 * applying the Human class's relevant methods/getters and setters.
 * This is especially useful, because I will need two instances of human players - for player1 and player2.
 */
public class Human extends Player implements ManualAnswer{

    // Instance variables
    private List<String> results;
    private int points;
    private List<String> moves;

    // Create class constructor
    public Human(List<String> results, int points, List<String> moves){
        super(); // super allows us to access the constructor and methods of the superclass/parent class Player
        this.results = results;
        this.points = points;
        this.moves = moves;
    }

    // Getters and Setters
    public List<String> getResults() {
        return results;
    }

    public void getResults(List<String> results) {
        this.results = results;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

    /**
     * The getManualAnswer method obtains a user's input using a Scanner object.
     * The user's input is formatted so that all letters are lowercase and whitespace is removed.
     * If the user's input is not a valid answer from the validAnswer list, the user is prompted to enter a different input.
     * @return - returns the user's answer as a String
     */
    @Override
    public String getManualAnswer() {

        Scanner userInput = new Scanner(System.in); // Create Scanner object
        System.out.println("\n" + "Enter Your Answer: "); // Prompt user for input
        String userAnswer = userInput.nextLine().toLowerCase().trim(); // Formats user's input and assigns it to variable

        List validAnswers = Arrays.asList("rock", "paper", "scissors", "quit");

        while (!validAnswers.contains(userAnswer)) { // Prompt user for different input if it's not a valid answer
            System.out.println("Enter A Different Answer: ");
            userAnswer = userInput.nextLine().toLowerCase().trim();
        }

        return userAnswer;
    }
}