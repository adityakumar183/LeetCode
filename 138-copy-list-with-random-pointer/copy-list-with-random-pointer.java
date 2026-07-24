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
    // Method 01:- Using LinkedList
    // public Node deepCopy(Node head){
    //     Node head2 = new Node(head.val);
    //     Node t1 = head.next;
    //     Node t2 = head2;
    //     while(t1!=null){
    //         Node temp = new Node(t1.val);
    //         t2.next = temp;
    //         t2 = t2.next;
    //         t1 = t1.next;
    //     }
    //     return head2;
    // }
    // public void connectAlternatively(Node head, Node head2){
    //     Node t1 = head;
    //     Node t2 = head2;
    //     Node dummy = new Node(-1);
    //     Node t = dummy;
    //     while(t1!=null && t2!=null){
    //         t.next = t1;
    //         t1 = t1.next;
    //         t = t.next;
    //         t.next = t2;
    //         t2 = t2.next;
    //         t = t.next;
    //     }
    // }
    // public void assignRandom(Node head, Node head2){
    //     Node t1 = head;
    //     Node t2 = head2;
    //     while(t1!=null){
    //         t2 = t1.next;
    //         if(t1.random!=null) t2.random = t1.random.next;
    //         t1 = t1.next.next;
    //     }
    // }
    // public void split(Node head, Node head2){
    //     Node t1 = head;
    //     Node t2 = head2;
    //     while(t1!=null){
    //         t1.next = t2.next;
    //         t1 = t1.next;
    //         if(t1==null) break;
    //         t2.next = t1.next;
    //         t2 = t2.next;
    //     }
    // }

    // public Node copyRandomList(Node head) {
    //     if(head==null) return null;
    //     // step 1 : Create deep copy
    //     Node head2 = deepCopy(head);
    //     // step 2 : Join head and head2 alternatively
    //     connectAlternatively(head,head2);
    //     // step 3 : Assign random pointer
    //     assignRandom(head,head2);
    //     // step 4 : Split the Linked List
    //     split(head,head2);

    //     return head2;
    // }

    // Method 02:- Using HashMap
    public Node copyRandomList(Node head){
        if(head == null) return null;
        // deep copy
        Node head2 = new Node(head.val);
        Node temp2 = head2;
        Node temp = head.next;
        while(temp!=null){
            Node dup = new Node(temp.val);
            temp2.next = dup;
            temp2 = dup;
            temp = temp.next;
        }
        // map marking
        HashMap<Node, Node> map = new HashMap<>();
        temp2 = head2;
        temp = head;
        while(temp!=null){
            map.put(temp,temp2);
            temp = temp.next;
            temp2 = temp2.next;
        }
        // assign duplicate
        for(Node original : map.keySet()){
            Node duplicate = map.get(original);
            if(original.random != null){
                duplicate.random = map.get(original.random);
            }
        }
        return head2;
    }
}