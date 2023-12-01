import java.util.*;

public class Searches {
    public static void main(String[] args) {
    BlindSearch search = new BlindSearch();
    String start = "DEN";
    String finish = "LA";

    System.out.println("\nDeep first search");
    search.DFS(start, finish);

    System.out.println("\nBreadth first seach");
    search.BFS(start, finish);
}
}