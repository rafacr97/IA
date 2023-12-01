import java.util.*;

public class BlindSearch {
    
    private Map<String, List<String>> connections = new HashMap<>();

    public BlindSearch() {
        connections.put("NY", Arrays.asList("CHI", "TOR", "DEN"));  // NY  -- connect to --> CHI, TOR, DEN.
        connections.put("CHI", Arrays.asList("DEN"));               // CHI -- connect to --> DEN.
        connections.put("TOR", Arrays.asList("CALG", "LA"));        // TOR -- connect to --> CALG, LA.
        connections.put("DEN", Arrays.asList("HOU", "LA", "URB"));  // DEN -- connect to --> HOU, LA, URB.
        connections.put("HOU", Arrays.asList("LA"));                // HOU -- connect to --> LA.
    }
    //Deep First Search Algorithm
    public boolean DFS(String initialState, String finalState) {
        Stack<State> statesToGo = new Stack<>();
        Set<String> visited = new HashSet<>();   

        statesToGo.push(new State(initialState));

        while (!statesToGo.isEmpty()) {            
            State currentState = statesToGo.pop(); 
            String currentCity = currentState.city;

            if (currentCity.equals(finalState)) {             
                System.out.println("Found!: " + currentCity); 
                return true;                                  
            }
            
            if (!visited.contains(currentCity)) {             
                System.out.println("Visited: " + currentCity);
                visited.add(currentCity);                     

                List<String> stateConnections = connections.get(currentCity);.
                if (stateConnections != null) {                              
                    for (String connection : stateConnections) {             
                        if (!visited.contains(connection)) {                 
                            statesToGo.push(new State(connection));          
                        }
                    }
                }
            }
        }

        System.out.println("Can't found the final state.");
        return false;
    }

    public boolean BFS(String initialState, String finalState) {
        Queue<State> cola = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        cola.add(new State(initialState));

        while (!cola.isEmpty()) {
            State currentState = cola.poll();
            String currentCity = currentState.city;

            if (currentCity.equals(finalState)) {
                System.out.println("finalState encontrado: " + currentCity);
                return true;
            }

            if (!visited.contains(currentCity)) {
                System.out.println("Visitando: " + currentCity);
                visited.add(currentCity);

                List<String> stateConnections = connections.get(currentCity);
                if (stateConnections != null) {
                    for (String connection : stateConnections) {
                        if (!visited.contains(connection)) {
                            cola.add(new State(connection));
                        }
                    }
                }
            }
        }

        System.out.println("No se pudo encontrar el finalState.");
        return false;
    }

}