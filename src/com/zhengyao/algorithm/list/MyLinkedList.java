package com.zhengyao.algorithm.list;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/26 11:45
 * @Description: 设计链表
 */
  class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) { val = x; }
}

public class MyLinkedList {
    int size;
    ListNode2 head;  // sentinel node as pseudo-head
    public MyLinkedList() {
        size = 0;
        head = new ListNode2(0);
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size){
            return -1;
        }
        ListNode2 node = head;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode2 temp = head;
        ListNode2 nowHead = temp.next;
        temp.next = new ListNode2(val);
        temp.next.next = nowHead;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode2 temp = head;
        ListNode2 addNode = new ListNode2(val);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = addNode;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode2 temp = head;
        ListNode2 addNode = new ListNode2(val);
        if (size < index) {
            return;
        }else if (size == index) {
            addAtTail(val);
        } else {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            ListNode2 nowNext = temp.next;
            temp.next = addNode;
            temp.next.next = nowNext;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode2 temp = head;
        if (size <= index) {
            return;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }
/*["MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
        [[],[4],[1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]*/
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(4);
        myLinkedList.get(1);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(5);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.addAtHead(7);
        myLinkedList.get(3);
        myLinkedList.get(3);
        myLinkedList.get(3);
        myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(4);

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
