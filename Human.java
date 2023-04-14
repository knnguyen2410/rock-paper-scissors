import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Human extends Player implements ManualAnswer{

    // Instance variables
    private List<String> results;
    private int points;
    private List<String> moves;

    // Create class constructor
    public Human(List<String> results, int points, List<String> moves){
        super();
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

    // Abstract methods that we must define from the abstract class
    @Override
    public void resultsTracker() {
        System.out.println("winner or loser");
    }

    @Override
    public void pointsTracker() {
        System.out.println("how many points");
    }

    @Override
    public void movesTracker() {
        System.out.println("which moves");
    }

    /**
     * The getManualAnswer method obtains a user's input using a Scanner object.
     * The user's input is formatted so that all letters are lowercase.
     * If the user's input is not a valid answer from the validAnswer list, the user is prompted to enter a different input.
     */
    @Override
    public String getManualAnswer() {

        Scanner userInput = new Scanner(System.in); // Create Scanner object
        System.out.println("Enter Your Answer: "); // Prompt user for input
        String userAnswer = userInput.nextLine().toLowerCase(); // Formats user's input and assigns it to variable

        List validAnswers = Arrays.asList("rock", "paper", "scissors", "quit");

        while (!validAnswers.contains(userAnswer)) { // Prompt user for different input if it's not a valid answer
            System.out.println("Enter A Different Answer: ");
            userAnswer = userInput.nextLine().toLowerCase();
        }

        return userAnswer;
    }
}