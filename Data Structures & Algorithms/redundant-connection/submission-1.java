class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (!union(u, v, parent, rank)) {
                return edge;
            }
        }

        return new int[0];
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i], parent); // Path compression
    }

    private boolean union(int i, int j, int[] parent, int[] rank) {
        int rootI = find(i, parent);
        int rootJ = find(j, parent);

        if (rootI == rootJ) {
            return false; // Cycle detected
        }

        // Union by rank
        if (rank[rootI] < rank[rootJ]) {
            parent[rootI] = rootJ;
        } else if (rank[rootI] > rank[rootJ]) {
            parent[rootJ] = rootI;
        } else {
            parent[rootJ] = rootI;
            rank[rootI]++;
        }

        return true;
    }
}