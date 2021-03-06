package lab5;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MaxFlow {
    private int amountOfNodes = -1;
    private int amountOfEdges = -1;
    private int[][] flowMatrix;

    public MaxFlow(String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't open file: " + fileName);
            System.exit(1);
        }

        amountOfNodes = scanner.nextInt();
        amountOfEdges = scanner.nextInt();
        flowMatrix = new int[amountOfNodes][amountOfNodes];

        while (scanner.hasNext()) {
            // --> int x... = scanner.nextInt() <---
            flowMatrix[scanner.nextInt()][scanner.nextInt()] = scanner.nextInt();
        }
        scanner.close();
    }

    public int maxFlow() {
        int maxFlow = 0, flow;

        System.out.println("Nodes: " + amountOfNodes + " Edges: " + amountOfEdges);
        //Kopiera matrisen
        int[][] res = new int[flowMatrix.length][flowMatrix[0].length];
        for (int i = 0; i < flowMatrix.length; i++) {
            res[i] = flowMatrix[i].clone();
        }

        //För rail.txt
        for (int i = 0; i < amountOfNodes; i++) {
            for (int j = 0; j < amountOfNodes; j++) {
                if (res[i][j] == -1) {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        do {
            flow = bfs(res);
            maxFlow += flow;
        } while (flow > 0);
        return maxFlow;
    }

    private int bfs(int[][] res) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amountOfNodes];
        int[] connected = new int[amountOfNodes];
        connected[0] = 0;
        visited[0] = true;
        queue.add(0);
        boolean found = false;

        //Standard bfs
        while (!queue.isEmpty() && !found) {
            int parent = queue.remove();
            for (int i = 0; i < amountOfNodes; i++) {
                if (!visited[i] && res[parent][i] > 0) {
                    connected[i] = parent;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }


        int flow = Integer.MAX_VALUE;
        int u;
        //Letar efter minsta talet (flaskhalsen)
        for (int v = amountOfNodes - 1; v != 0; v = connected[v]) {
            u = connected[v];
            flow = Math.min(flow, res[u][v]);
        }

        //Uppdatera res-matrisen
        for (int v = amountOfNodes - 1; v != 0; v = connected[v]) {
            u = connected[v];
            res[u][v] -= flow;
            res[v][u] += flow;
        }
        return flow;
    }
}
