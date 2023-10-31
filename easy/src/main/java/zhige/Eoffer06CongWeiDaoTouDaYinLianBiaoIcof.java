package zhige;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/description/
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
 * @author wangyongzhi
 * @date 2023/9/13
 */
public class Eoffer06CongWeiDaoTouDaYinLianBiaoIcof {


    /**
     * 方法2：用一个栈把链表数据存储起来，然后在逐个打印即可。
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        int size = stack.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop();
        }
        return arr;

    }

    ArrayList<Integer> tmp = new ArrayList<>();
    /**
     * 方法一：本质上是链表递归的后序位置打印
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        //先按后续递归的方式，把结果存到tmp数组里面。
        traverse(head);

        //再打印list的结果即可。
        return tmp.stream().mapToInt(Integer::intValue).toArray();

    }

    private void traverse(ListNode head) {
        if (head == null) {
            return;
        }

        traverse(head.next);

        tmp.add(head.val);

    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 2, 3, 4, 5);
        Eoffer06CongWeiDaoTouDaYinLianBiaoIcof clazz = new Eoffer06CongWeiDaoTouDaYinLianBiaoIcof();
        int[] ints = clazz.reversePrint(head);
        ArrayUtils.print(ints);


        ListNode head1 = ListNode.build(1, 2, 3, 4, 5);
        Eoffer06CongWeiDaoTouDaYinLianBiaoIcof clazz1 = new Eoffer06CongWeiDaoTouDaYinLianBiaoIcof();
        int[] ints1 = clazz1.reversePrint2(head1);
        ArrayUtils.print(ints1);

    }
}
