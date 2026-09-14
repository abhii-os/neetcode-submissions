class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadset = new HashSet<>(Arrays.asList(deadends));
        if(deadset.contains("0000")) return -1;
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited  = new HashSet<>();

        queue.add("0000");
        visited.add("0000");
        int turns = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String curr = queue.poll();
                if(curr.equals(target)) return turns;

                for(String neighbor:getNeighbors(curr)){
                    if(!deadset.contains(neighbor) && !visited.contains(neighbor)){
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            turns++;
        }
        return -1;
    }

    private List<String> getNeighbors(String curr){
        List<String> neighbors = new ArrayList<>();
        char[] arr = curr.toCharArray();

        for(int i=0;i<4;i++){
            char original = arr[i];

            arr[i] = original == '9'?'0':(char)(original+1);
            neighbors.add(new String(arr));

            arr[i] = original == '0'?'9':(char)(original-1);
            neighbors.add(new String(arr));

            arr[i]=original;
        }
        return neighbors;
    } 
}