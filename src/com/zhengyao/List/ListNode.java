package com.zhengyao.List;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2019/10/8 16:48
 * @Description: 链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    private void add(int val) {
        ListNode node = this;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(val);
    }
}