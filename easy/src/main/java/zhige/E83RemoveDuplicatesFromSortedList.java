package zhige;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 *
 * @see E21MergeTwoSortedLists 合并两个有序链表
 * @see E83RemoveDuplicatesFromSortedList 删除排序链表中的重复元素
 * @see E141LinkedListCycle 环形链表
 * @see E160IntersectionOfTwoLinkedLists 相交链表
 * @see E206ReverseLinkedList 反转链表
 * @see E876MiddleOfTheLinkedList 链表的中间结点
 * @see Eoffer06CongWeiDaoTouDaYinLianBiaoIcof 剑指 Offer 06. 从尾到头打印链表
 *
 * @see M19RemoveNthNodeFromEndOfList 删除链表的倒数第 N 个结点
 * @see M61RotateList 旋转链表
 * @see M86PartitionList 分隔链表
 * @see M142LinkedListCycle2 环形链表 II
 *
 * @see H23MergeKSortedLists 合并K个升序链表
 *
 * @author wangyongzhi
 * @date 2023-02-17
 */
public class E83RemoveDuplicatesFromSortedList {

    /**
     * 快慢指针，如果fast值不等于slow，则slow指向fast，slow才移动。需要断开与重复节点的连接。
     * 否则，如果fast等于slow，只移动fast
     */
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
