class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
        }
        for(int[] i : edges){
            int a = i[0];
            int b = i[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        Set<Integer> visited = new HashSet<>();

        if(hasCycle(0,-1,adj,visited)) return false;

        return visited.size()==n;
    }

    private boolean hasCycle(int curr, int parent, List<List<Integer>> adj, Set<Integer> visited){
        visited.add(curr);
        for(int neighbor : adj.get(curr)){
            if(neighbor == parent) continue;
            if(visited.contains(neighbor)) return true;
            if(hasCycle(neighbor, curr,adj,visited)) return true;
        }
        return false;
    }
}
