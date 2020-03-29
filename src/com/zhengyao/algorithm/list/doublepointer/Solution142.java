package com.zhengyao.algorithm.list.doublepointer;

import com.zhengyao.algorithm.list.ListNode;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/29 17:50
 * @Description: 环形链表2
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        //快指针
        ListNode fast = head;
        //慢指针
        ListNode slow = head;
        while(fast != null){
            //如果快指针到达终点,证明没有环,返回null
            if(fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            //如果有环的话,第三个指针从头开始走,快指针继续走
            if(fast == slow){
                ListNode third = head;
                //当快指针与第三个指针相遇时,证明到了环的入口
                while(fast != third){
                    third = third.next;
                    fast = fast.next;
                }
                return third;
            }
        }
        return null;
    }
}
