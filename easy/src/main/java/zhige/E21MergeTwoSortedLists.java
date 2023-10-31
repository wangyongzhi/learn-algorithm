package zhige;


/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * https://leetcode.cn/problems/merge-two-sorted-lists/
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
 * @date 2023-02-15
 */
public class E21MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // 搞个虚拟头结点，用来组成一个新的链表。
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;

        //如果都不为空的情况下，比较链表的第一个节点大小，谁小谁接上p
        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        //可能有一个链表提前结束，把另一个的拼接上。
        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        //把虚拟头结点去掉，去next
        return dummy.next;

    }


    /**
     * 相比mergeTwoLists
     * 这个方法，把每次p1或者p2的节点添加到p时，去掉了p1或者p2的后置节点。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {

        // 搞个虚拟头结点，用来组成一个新的链表。
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;

        //如果都不为空的情况下，比较链表的第一个节点大小，谁小谁接上p
        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                ListNode temp1 = p2.next;
                p2.next = null;
                p.next = p2;
                p2 = temp1;
            } else {
                ListNode temp1 = p1.next;
                p1.next = null;
                p.next = p1;
                p1 = temp1;
            }
            // p 指针不断前进
            p = p.next;
        }

        //可能有一个链表提前结束，把另一个的拼接上。
        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        //把虚拟头结点去掉，去next
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(1, 2, 4);
        ListNode listNode2 = ListNode.build(1, 3, 4);
        E21MergeTwoSortedLists list = new E21MergeTwoSortedLists();
        ListNode listNode = list.mergeTwoLists1(listNode1, listNode2);

        ListNode.print(listNode);



    }
}
