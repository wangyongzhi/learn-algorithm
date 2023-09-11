package zhige;

/**
 * 876. 链表的中间结点
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 * @author wangyongzhi
 * @date 2023-02-16
 */
public class E876MiddleOfTheLinkedList {

    /**
     * 快慢指针，快指针走到末尾的时候，慢指针就是中点。
     * 如果是偶数个，中点指的靠右的那个。
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }


    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(1,2,3,4,5);
        ListNode listNode2 = ListNode.build(1,2,3,4,5,6);
        E876MiddleOfTheLinkedList list = new E876MiddleOfTheLinkedList();
        ListNode result1 = list.middleNode(listNode1);
        ListNode result2 = list.middleNode(listNode2);

        ListNode.print(result1);
        ListNode.print(result2);

    }
}
