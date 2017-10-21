package com.company.algo;

public class DetectCycleInLinkedList {
    class Node {
        int data;
        Node next;
    }


    boolean hasCycle(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;

    }
}
