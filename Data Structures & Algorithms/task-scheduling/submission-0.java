class Solution {
    public int leastInterval(char[] tasks, int n) {
       Map<Character, Integer> countMap = new HashMap<>();
        for (char t : tasks) {
            countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(countMap.values());
        Queue<int[]> cooldownQueue = new LinkedList<>();

        int time = 0;
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.offer(cooldownQueue.poll()[0]);
            }
            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;
                if (count > 0) {
                   
                    cooldownQueue.offer(new int[]{count, time + n + 1});
                }
            }
        }
        return time; 
    }
}
