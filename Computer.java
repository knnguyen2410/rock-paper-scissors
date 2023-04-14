import java.util.List;
import java.util.Random;

public class Computer extends Player implements RandomAnswer{

    // Instance variables
    private List<String> results;
    private int points;
    private List<String> moves;

    // Create class constructor
    public Computer(List<String> results, int points, List<String> moves){
        super();
        this.results = results;
        this.points = points;
        this.moves = moves;
    }

    // Getters and Setters
    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
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
     * The getRandomAnswer method uses a random number generator which acts as the computer's input.
     * The method generates a number from 0-2, and each number corresponds to a different rock/paper/scissors move for the computer.
     * The resulting string is then returned.
     */
    @Override
    public String getRandomAnswer() {
        Random random = new Random(); // Create a new instance of the random class
        int randomNumber = random.nextInt(3); // Generates random integer from 0-2
        String randomAnswer = "";
        if (randomNumber == 0) { // Computer answer updates based on random number generated
            randomAnswer = "rock";
        } else if (randomNumber == 1) {
            randomAnswer = "paper";
        } else {
            randomAnswer = "scissors";
        }
        return randomAnswer;
    }
}