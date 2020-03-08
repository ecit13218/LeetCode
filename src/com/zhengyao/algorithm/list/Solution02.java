package com.zhengyao.algorithm.list;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2019/12/14 10:33
 * @Description: 链表的两数相加
 */
public class Solution02 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        ListNode node = addTwoNumbers2(l1, l2);
        while (node != null) {
            System.out.print(node.val+",");
            node = node.next;
        }
    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode tempHead = temp;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            temp.add(sum % 10);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            temp.add(carry);
        }
        return tempHead;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int v1 = 0;
        int v2 = 0;
        ListNode tempHead = new ListNode(0);
        ListNode temp = tempHead;
        while(l1 != null){
            v1 = v1 * 10 + l1.val;
            l1 = l1.next;
        }
        while(l2 != null){
            v2 = v2 * 10 + l2.val;
            l2 = l2.next;
        }
        int resultV1 = reverseVal(v1);
        int resultV2 = reverseVal(v2);
        int result = resultV1 + resultV2;
        while(result > 0){
            ListNode node = new ListNode(result % 10);
            result = result / 10;
            tempHead.next = node;
            tempHead = tempHead.next;
        }
        return temp.next;
    }

    public static int reverseVal(int val){
        int result = 0;
        while(val > 0){
            result = val % 10 + result * 10;
            val = val / 10;
        }
        return result;
    }
}
