package zhige;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * https://leetcode.cn/problems/linked-list-cycle/
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
