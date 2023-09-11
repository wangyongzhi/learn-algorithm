package zhige;

/**
 * 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 *
 * @see E141LinkedListCycle
 * @author wangyongzhi
 * @date 2023-02-16
 */
public class M142LinkedListCycle2 {


    public ListNode detectCycle(ListNode head) {

        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }

        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }

        // 重新指向头结点
        slow = head;
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }


    public static void main(String[] args) {
        ListNode listNode1 = ListNode.buildCycle(1,2,3,4,5);
        ListNode listNode2 = ListNode.buildCycle(1);
        ListNode listNode3 = ListNode.buildCycle(1,2);
        M142LinkedListCycle2 list = new M142LinkedListCycle2();
        ListNode result1 = list.detectCycle(listNode1);
        ListNode result2 = list.detectCycle(listNode2);
        ListNode result3 = list.detectCycle(listNode3);


        System.out.println();
    }
}
