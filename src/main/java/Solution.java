import java.util.*;

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Dejkstra algo
        //building a graph
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            double probability = succProb[i];

            if (!graph.containsKey(node1)) {
                graph.put(node1, new HashMap<>());
            }
            graph.get(node1).put(node2, probability);

            if (!graph.containsKey(node2)) {
                graph.put(node2, new HashMap<>());
            }
            graph.get(node2).put(node1, probability);

        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a.probabilityFromStart));
        double[] probabilities = new double[n];
        pq.offer(new Node(start, 1));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            if (currentNode.index == end) {
                return currentNode.probabilityFromStart;
            }

            if (currentNode.probabilityFromStart > probabilities[currentNode.index]) {
                probabilities[currentNode.index] = currentNode.probabilityFromStart;
                Map<Integer, Double> neighbours = graph.get(currentNode.index);
                if (neighbours != null) {
                    for (Map.Entry<Integer, Double> neighbour : neighbours.entrySet()) {
                        int neighbourIndex = neighbour.getKey();
                        double probability = neighbour.getValue();
                        pq.offer(new Node(neighbourIndex, currentNode.probabilityFromStart * probability));
                    }
                }
            }

        }


        return 0.0;
    }
}

class Node {
    int index;
    double probabilityFromStart;

    public Node(int index, double probabilityFromStart) {
        this.index = index;
        this.probabilityFromStart = probabilityFromStart;
    }

    @Override
    public String toString() {
        return "Node{" +
                "index=" + index +
                ", probabilityFromStart=" + probabilityFromStart +
                '}';
    }
}
