package zhige;

/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 * @author wangyongzhi
 * @date 2023-02-16
 */
public class E141LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;

        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }

        return false;

    }


    public static void main(String[] args) {
        ListNode listNode1 = ListNode.buildCycle(1,2,3,4,5);
        ListNode listNode2 = ListNode.buildCycle(1);
        ListNode listNode3 = ListNode.buildCycle(1,2);
        E141LinkedListCycle list = new E141LinkedListCycle();
        boolean result1 = list.hasCycle(listNode1);
        boolean result2 = list.hasCycle(listNode2);
        boolean result3 = list.hasCycle(listNode3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }
}
