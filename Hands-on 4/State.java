import java.util.HashMap;
import java.util.Map;

public class State {
    private String name;
    private Map<State, Integer> neighbors;

    public State(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
    }

    public void addNeighbor(State neighbor, int cost) {
        neighbors.put(neighbor, cost);
    }

    public String getName() {
        return name;
    }

    public Map<State, Integer> getNeighbors() {
        return neighbors;
    }
}
