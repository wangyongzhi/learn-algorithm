package radishdata.top;

/**
 * 142. 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * @author wangyongzhi
 * @date 2023-02-16
 */
public class M142LinkedListCycleIi {


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
        M142LinkedListCycleIi list = new M142LinkedListCycleIi();
        ListNode result1 = list.detectCycle(listNode1);
        ListNode result2 = list.detectCycle(listNode2);
        ListNode result3 = list.detectCycle(listNode3);


        System.out.println();
    }
}
