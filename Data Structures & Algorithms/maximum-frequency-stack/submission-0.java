class FreqStack {

    private Map<Integer, Integer> frequency;
    private Map<Integer, Stack<Integer>> group;
    private int maxFreq;
    public FreqStack() {
         frequency = new HashMap<>();
         group = new HashMap<>();
         maxFreq = 0;
    }
    
    public void push(int val) {
        int f = frequency.getOrDefault(val, 0) + 1;
        frequency.put(val,f);
        if (f > maxFreq) {
            maxFreq = f;
        }
        group.computeIfAbsent(f, z -> new Stack<>()).push(val);
    }
    
    public int pop() {
        int val = group.get(maxFreq).pop();
        frequency.put(val,frequency.get(val)-1);
        if(group.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return val;
    }

}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */