package com.zhengyao.algorithm.list;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/29 23:34
 * @Description: 链表反转
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Solution206 {

    /**
     * @description :  递归解法
     * @params : [head]
     * @return : com.zhengyao.algorithm.list.ListNode 
     * @author : zhengyao 
     * @date : 2020/3/29 
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }else{
            ListNode curr = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return curr;
        }
    }

    /**
     * @description : 三指针反转法 
     * @params : [head]
     * @return : com.zhengyao.algorithm.list.ListNode 
     * @author : zhengyao 
     * @date : 2020/3/29 
     */
    public  ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    
}
