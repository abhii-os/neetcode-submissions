/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }

        Node curr = head;
        while(curr != null){
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node cloneHead = head.next;
        Node cloneCurr = cloneHead;

        while(curr!=null){
            curr.next = curr.next.next;
            if(cloneCurr.next != null){
                cloneCurr.next = cloneCurr.next.next;
            }
            curr = curr.next;
            cloneCurr = cloneCurr.next;
        }
        return cloneHead;
    }
}
