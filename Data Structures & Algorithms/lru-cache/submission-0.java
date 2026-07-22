class LRUCache {
    private class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final Map<Integer,Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        }
        else{
            if(map.size()==capacity){
                Node lruNode = tail.prev;
                removeNode(lruNode);
                map.remove(lruNode.key);
            }
            Node newNode = new Node(key,value);
            addNodeToHead(newNode);
            map.put(key,newNode);
        }
    }


    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addNodeToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    private void moveToHead(Node node){
        removeNode(node);
        addNodeToHead(node);
    }
}
