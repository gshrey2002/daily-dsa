package striver;
import java.util.*;


class PrimMST {
    static class Edge implements Comparable<Edge> {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static int primMST(int[][] graph) {
        int n = graph.length;
        boolean[] inMST = new boolean[n];
        int[] key = new int[n]; 
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; 
        int totalCost = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0)); 
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int u = curr.node;

            if (inMST[u]) continue;
            inMST[u] = true;
            totalCost += curr.weight;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    pq.add(new Edge(v, graph[u][v]));
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2, 0},
                {0, 0, 7, 0, 9, 14, 0, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6, 0},
                {8, 11, 0, 0, 0, 0, 1, 0, 7, 0},
                {0, 0, 2, 0, 0, 0, 6, 7, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int totalCost = primMST(graph);
        System.out.println("Total cost of the minimum spanning tree: " + totalCost);
    }
}
