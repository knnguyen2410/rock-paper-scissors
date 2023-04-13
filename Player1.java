import java.util.List;

public class Player1 extends Player {

    // Instance variables
    private String name;
    private String state;
    private int points;
    private List<String> moves;

    public Player1(String name, String state, int points, List<String> moves){ // Create class constructor
        this.name = name;
    }
    public String getName() { // Getter
        return name;
    }
    public void setName(String name) { // Setter
        this.name = name;
    }

    // Abstract methods that we must define since we are extending the abstract class
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