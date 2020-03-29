package com.zhengyao.algorithm.list.doublepointer;

import com.zhengyao.algorithm.list.ListNode;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/29 17:46
 * @Description: 判断链表是否有环
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //使用快指针进行判断
        while(fast != null){
            //这里必须要判断一下，否则就有可能快指针会空指针异常，如果确认有终点，则认为这是没有环	
            if(fast.next == null){
                return false;
            }
            //快指针走两步
            fast = fast.next.next;
            //慢指针走一步
            slow = slow.next;
            //如果相遇的话，则证明有环，否则快指针一定会走到终点
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
