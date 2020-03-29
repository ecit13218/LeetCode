package com.zhengyao.algorithm.list;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/29 23:09
 * @Description: 移除某个元素
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 */
public class Solution203 {

    /**
     * @description :  哨兵节点法
     * @params : [head, val]
     * @return : com.zhengyao.algorithm.list.ListNode 
     * @author : zhengyao 
     * @date : 2020/3/29 
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode tempHead = new ListNode(0);
        ListNode dummnyNode = tempHead;
        while(head != null){
            if(head.val != val){
                tempHead.next = new ListNode(head.val);
                tempHead = tempHead.next;
            }
            head = head.next;
        }
        return dummnyNode.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
       //判断是否删除头结点
        while (head != null && head.val == val) {
            head = head.next;
        }
        //判空
        if (head == null) {
            return null;
        }
        ListNode finalHead = head;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return finalHead;
    }
    
}
