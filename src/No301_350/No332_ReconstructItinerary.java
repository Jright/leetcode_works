package No301_350;

import java.util.*;

public class No332_ReconstructItinerary {

    // We need to return the ORDER in which the flights should be taken to reach
    // ALL the destinations (if possible) starting at JFK
    // This is a typical GRAPH situation where we have multiple edges from one vertex to go to
    // Form a graph (Map<String, Queue<String>) Key -> Departing City, Val -> Queue of Arrival city from key
    // Once graph is formed, do a DFS starting from JFK
    // Once we get a PATH (it means we are at end of the valid PATH, since DFS), start adding from end to start
    // (JFK) in a LinkedList

    // TC : O(ELogE) where E is number of edges. Because we offer each edge into queue (any) once and then poll it out once
    // SC : O(E)

    Map<String, PriorityQueue<String>> graph;
    LinkedList<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets.size() == 1) {
            return tickets.get(0);
        }

        this.graph = new HashMap<>();
        this.result = new LinkedList<>();

        // make graph with values in Lexi order (make sure by min queue)
        for (List<String> ticket : tickets) {
            this.graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            this.graph.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK");

        return this.result;
    }

    private void dfs(String departure) {
        PriorityQueue<String> arrivals = this.graph.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        this.result.addFirst(departure);
    }

}
