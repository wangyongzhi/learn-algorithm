package zhige;

/**
 * 876. 链表的中间结点
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 *
 * @see E21MergeTwoSortedLists 合并两个有序链表
 * @see E83RemoveDuplicatesFromSortedList 删除排序链表中的重复元素
 * @see E141LinkedListCycle 环形链表
 * @see E160IntersectionOfTwoLinkedLists 相交链表
 * @see E206ReverseLinkedList 反转链表
 * @see E876MiddleOfTheLinkedList 链表的中间结点
 * @see Eoffer06CongWeiDaoTouDaYinLianBiaoIcof 剑指 Offer 06. 从尾到头打印链表
 *
 * @see M2AddTwoNumbers 两数相加，链表
 * @see M19RemoveNthNodeFromEndOfList 删除链表的倒数第 N 个结点
 * @see M61RotateList 旋转链表
 * @see M86PartitionList 分隔链表
 * @see M142LinkedListCycle2 环形链表 II
 *
 * @see H23MergeKSortedLists 合并K个升序链表
 *
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
