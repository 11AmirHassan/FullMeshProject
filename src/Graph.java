import java.util.*;

public class Graph {
    private Map<WorkStation, List<WorkStation>> adjList = new HashMap<>();

    public boolean addNode(WorkStation ws) {
        // Check IP uniqueness
        for (WorkStation existing : adjList.keySet()) {
            if (existing.getIp().equals(ws.getIp())) {
                System.out.println("IP already exists! Try another.");
                suggestIPs();
                return false;
            }
        }

        // Add node
        adjList.putIfAbsent(ws, new ArrayList<>());

        // Connect to all existing nodes (full mesh)
        for (WorkStation other : adjList.keySet()) {
            if (!other.equals(ws)) {
                adjList.get(ws).add(other);
                adjList.get(other).add(ws);
            }
        }
        return true;
    }

    private void suggestIPs() {
        System.out.println("Suggested IPs: 192.168.1.10, 192.168.1.11, 192.168.1.12");
    }

    public WorkStation findByIp(String ip) {
        for (WorkStation ws : adjList.keySet()) {
            if (ws.getIp().equals(ip)) return ws;
        }
        return null;
    }

    public Map<WorkStation, List<WorkStation>> getAdjList() {
        return adjList;
    }
}