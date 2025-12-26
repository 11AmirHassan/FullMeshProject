import java.util.*;

public class BFSReader {
    public void bfsRead(WorkStation start, Graph graph) {
        Queue<WorkStation> queue = new LinkedList<>();
        Map<WorkStation, Integer> levels = new HashMap<>();
        Set<WorkStation> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        levels.put(start, 0);

        while (!queue.isEmpty()) {
            WorkStation current = queue.poll();
            int level = levels.get(current);
            System.out.println("Level " + level + ": " + current);

            for (WorkStation neighbor : graph.getAdjList().get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    levels.put(neighbor, level + 1);
                }
            }
        }
    }
}