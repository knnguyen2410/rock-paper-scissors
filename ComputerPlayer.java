import java.util.List;

public class ComputerPlayer extends Player {

    // Instance variables
    private String state;
    private int points;
    private List<String> moves;

    // Create class constructor
    public ComputerPlayer(String state, int points, List<String> moves){
        this.state = state;
        this.points = points;
        this.moves = moves;
    }

    // Getters and Setters
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
    public void stateTracker() {
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
}