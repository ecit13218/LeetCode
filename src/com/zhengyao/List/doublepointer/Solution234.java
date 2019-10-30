package com.zhengyao.List.doublepointer;

import com.zhengyao.List.ListNode;

import java.util.List;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2019/10/30 17:41
 * @Description: 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Solution234 {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.add(0);
        node.add(0);
        System.out.println(isPalindrome(node));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast1 = head;
        ListNode slow1 = head;
        ListNode slow2 = head;
        //先判断中间链表节点在哪里
        while(fast1 != null && fast1.next != null){
            fast1 = fast1.next.next;
            slow1 = slow1.next;
        }
        //反转后半段链表
        slow1 = reverseList(slow1);
        //当slow2指针走到中间指针时,证明已经到头了,可以停了
        ListNode slow1TempHead = slow1;
        while(slow1 != null && slow1TempHead != slow2){
            //判断是否正常
            if(slow1.val != slow2.val){
                return false;
            }
            slow1 = slow1.next;
            slow2 = slow2.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static ListNode reverseNodeByRe(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode curr = reverseNodeByRe(node.next);
        node.next.next = node;
        node.next = null;
        return curr;
    }
}
