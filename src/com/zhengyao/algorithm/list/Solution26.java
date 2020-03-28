package com.zhengyao.algorithm.list;
/*
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
class Solution26 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(l1,l2);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null){
                return l2;
            }
            if(l2 == null){
                return l1;
            }
            ListNode tempHead = new ListNode(0);
            ListNode head = tempHead;
            while(l1 != null && l2 != null){
                if(l1.val > l2.val){
                    tempHead.next = l2;
                    l2 = l2.next;
                }else{
                    tempHead.next = l1;
                    l1 = l1.next;
                }
                tempHead = tempHead.next;
            }
            tempHead.next = l1 == null ? l2 : l1;
            return head.next;

    }
}