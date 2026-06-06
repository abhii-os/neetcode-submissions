class MyHashMap {
    private static final int BASE = 769;
    private Node[] buckets;
    public MyHashMap() {
        buckets = new Node[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new Node(-1, -1); // Initialize with dummy nodes
        }
        
    }
    private int getHash(int key) {
        return key % BASE;
    }
    
    public void put(int key, int value) {
        int index = getHash(key);
        Node prev = find(buckets[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = getHash(key);
        Node prev = find(buckets[index], key);
        return (prev.next == null) ? -1 : prev.next.value;
    }
    
    public void remove(int key) {
        int index = getHash(key);
        Node prev = find(buckets[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private Node find(Node bucket, int key) {
        Node curr = bucket;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    private class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */