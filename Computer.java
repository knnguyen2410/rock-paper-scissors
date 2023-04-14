import java.util.List;
import java.util.Random;

/**
 * This Computer class is a subclass of the abstract Player class, and implements the RandomAnswer interface.
 * By creating a Computer class, I can then create an instance of a computer player,
 * applying the Computer class's relevant methods/getters and setters.
 * In this class, we populate the body of the getRandomAnswer method,
 * and use its functionality to create a random answer for any Computer instance.
 */
public class Computer extends Player implements RandomAnswer{

    // Instance variables
    private List<String> results;
    private int points;
    private List<String> moves;

    // Create class constructor
    public Computer(List<String> results, int points, List<String> moves){
        super(); // super allows us to access the constructor and methods of the superclass/parent class Player
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

    /**
     * The getRandomAnswer method uses a random number generator which acts as the computer's input.
     * The method generates a number from 0-2, and each number corresponds to a different rock/paper/scissors move for the computer.
     * @return - returns an answer as a String which is determined randomly.
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