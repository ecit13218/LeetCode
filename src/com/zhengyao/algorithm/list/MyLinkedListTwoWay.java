package com.zhengyao.algorithm.list;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/28 10:24
 * @Description: 双向链表
 */

class ListNode3{
    int val;
    ListNode3 next;
    ListNode3 prev;
    ListNode3(int x) { val = x; }
}
public class MyLinkedListTwoWay {

    int size;
    ListNode3 head;  // sentinel node as pseudo-head
    public MyLinkedListTwoWay() {
        size = 0;
        head = new ListNode3(0);
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size){
            return -1;
        }
        ListNode3 node = head;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode3 temp = head;
        ListNode3 nowHead = temp.next;
        temp.next = new ListNode3(val);
        temp.next.next = nowHead;
        if (nowHead != null) {
            nowHead.prev = temp.next;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode3 temp = head;
        ListNode3 addNode = new ListNode3(val);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = addNode;
        addNode.prev = temp;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode3 temp = head;
        ListNode3 addNode = new ListNode3(val);
        if (size < index) {
            return;
        }else if (size == index) {
            addAtTail(val);
        } else {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            ListNode3 nowNext = temp.next;
            temp.next = addNode;
            temp.next.next = nowNext;
            addNode.prev = temp;
            if (nowNext != null) {
                nowNext.prev = addNode;
            }
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode3 temp = head;
        if (size <= index) {
            return;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        if (temp.next != null && temp.next.next != null) {
            temp.next.next.prev = temp;
        }
        size--;
    }
    public static void main(String[] args) {
        MyLinkedListTwoWay myLinkedListTwoWay = new MyLinkedListTwoWay();
        myLinkedListTwoWay.addAtHead(1);
        myLinkedListTwoWay.deleteAtIndex(0);
    }
}
