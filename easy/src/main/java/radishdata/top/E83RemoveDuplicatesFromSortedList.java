package radishdata.top;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * @author wangyongzhi
 * @date 2023-02-17
 */
public class E83RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head, slow = head;

        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }

        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(1,2,2,3,4,5,5,6);
        ListNode.print(listNode1);

        E83RemoveDuplicatesFromSortedList list = new E83RemoveDuplicatesFromSortedList();
        ListNode result1 = list.deleteDuplicates(listNode1);
        ListNode.print(result1);
    }
}
