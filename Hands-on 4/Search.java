import java.util.*;

public class Search {
    public static void main(String[] args) {
        State a = new State("a");
        State b = new State("b");
        State c = new State("c");
        State d = new State("d");
        State e = new State("e");

        a.addNeighbor(b, 100);
        a.addNeighbor(c, 125);
        a.addNeighbor(d, 100);
        a.addNeighbor(e, 75);

        b.addNeighbor(a, 100);
        b.addNeighbor(c, 50);
        b.addNeighbor(d, 75);
        b.addNeighbor(e, 125);

        c.addNeighbor(a, 125);
        c.addNeighbor(b, 50);
        c.addNeighbor(d, 100);
        c.addNeighbor(e, 125);

        d.addNeighbor(a, 100);
        d.addNeighbor(b, 75);
        d.addNeighbor(c, 100);
        d.addNeighbor(e, 50);

        e.addNeighbor(a, 75);
        e.addNeighbor(b, 125);
        e.addNeighbor(c, 125);
        e.addNeighbor(d, 50);

        HillClimbing hillClimbing = new HillClimbing(b);
        System.out.println("Estado inicial: " + hillClimbing.getCurrentState().getName());

        hillClimbing.hillClimb();

        System.out.println("Mejor estado encontrado: " + hillClimbing.getCurrentState().getName());

        System.out.println("Estados visitados:");
        for (State visitedState : hillClimbing.getVisitedStates()) {
            System.out.println(visitedState.getName());
        }
    }
}
