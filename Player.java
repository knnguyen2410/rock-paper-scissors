import java.util.List;

public abstract class Player { // Create abstract Player class

    // This class manages the player's state through abstract methods
    public abstract void resultsTracker();
    public abstract void pointsTracker();
    public abstract void movesTracker();

    // Instance variables
    private List<String> results;
    private int points;
    private List<String> moves;

    // Create class constructor
    public Player() {

    }

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
