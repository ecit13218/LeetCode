package com.zhengyao.List.doublepointer;

import com.zhengyao.List.ListNode;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2019/10/8 16:48
 * @Description: 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //哨兵节点
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode fast = tempHead;
        ListNode slow = tempHead;
        int index = 0;
        while(fast != null){
            //使用双指针法,快指针先走,快指针先走N+1步,这样两者相差步数为n,即找到了需要删除的那个节点,找到之后删除即可
            if(index >= n+1 ){
                slow = slow.next;
            }
            index++;
            fast = fast.next;
        }
        //删除节点
        slow.next = slow.next.next;
        //返回有效节点
        return tempHead.next;
    }
}
