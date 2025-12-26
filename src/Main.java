import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        BFSReader bfs = new BFSReader();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose option: 1) Add Node  2) Connection Test  3) Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter node name: ");
                String name = sc.nextLine();
                System.out.print("Enter IP: ");
                String ip = sc.nextLine();
                graph.addNode(new WorkStation(name, ip));
            } else if (choice == 2) {
                System.out.print("Enter IP to test: ");
                String ip = sc.nextLine();
                WorkStation ws = graph.findByIp(ip);
                if (ws != null) bfs.bfsRead(ws, graph);
                else System.out.println("Node not found!");
            } else break;
        }
    }
}