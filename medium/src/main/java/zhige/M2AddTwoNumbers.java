package zhige;

/**
 * 2. 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * https://leetcode.cn/problems/add-two-numbers/
 *
 * @see E415AddStrings 字符串相加
 * @see M2AddTwoNumbers 两数相加，链表
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
 *
 * @author wangyongzhi
 * @date 2023/10/31
 */
public class M2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, dummy = new ListNode(-1);
        ListNode p = dummy;

        int carry = 0;

        //两个链表不为空，或者进位有值的时候，继续进行。
        while (p1 != null || p2 != null || carry > 0) {
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }

            //处理进位
            carry = val / 10;
            //取模就是当前节点的值。
            val = val % 10;
            p.next = new ListNode(val);
            p = p.next;
        }

        return dummy.next;

    }
}
