import java.util.List;

/**
 * This is an abstract Player class that can be extended from for both Human and Computer subclasses.
 */
public abstract class Player { // Create abstract Player class

    // Instance variables
    private List<String> results;
    private int points;
    private List<String> moves;

    // Default constructor
    public Player() {

    }

    // Create class constructor
    public Player(List<String> results, int points, List<String> moves){
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

}
