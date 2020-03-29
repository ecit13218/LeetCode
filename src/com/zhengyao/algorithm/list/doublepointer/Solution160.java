package com.zhengyao.algorithm.list.doublepointer;

import com.zhengyao.algorithm.list.ListNode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/29 18:00
 * @Description: 相交链表
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB){
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (nodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    
}
