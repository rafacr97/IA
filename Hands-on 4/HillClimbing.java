import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HillClimbing {
    private State currentState;
    private List<State> visitedStates;

    public HillClimbing(State initialState) {
        this.currentState = initialState;
        this.visitedStates = new ArrayList<>();
    }

    public State getCurrentState() {
        return currentState;
    }

    public List<State> getVisitedStates() {
        return visitedStates;
    }

    public void hillClimb() {
        while (true) {
            visitedStates.add(currentState);

            State nextState = findBestNeighbor();
            if (nextState == null || nextState.equals(currentState)) {
                break;
            }
            currentState = nextState;
        }
    }

    private State findBestNeighbor() {
        Map<State, Integer> neighbors = currentState.getNeighbors();
        State bestNeighbor = null;
        int bestCost = Integer.MAX_VALUE;

        for (Map.Entry<State, Integer> entry : neighbors.entrySet()) {
            State neighbor = entry.getKey();
            int cost = entry.getValue();

            if (cost < bestCost && !visitedStates.contains(neighbor)) {
                bestCost = cost;
                bestNeighbor = neighbor;
            }
        }

        return bestNeighbor;
    }
}
