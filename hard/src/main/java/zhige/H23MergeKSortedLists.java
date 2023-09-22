package zhige;

import java.util.*;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 *
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 * @see E21MergeTwoSortedLists
 * @author wangyongzhi
 * @date 2023-02-16
 */
public class H23MergeKSortedLists {


    /**
     * 需要使用一个小顶堆，每次把最小的拿出来比较。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null){
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }

            // p 指针不断前进
            p = p.next;

        }

        return dummy.next;

    }


    /**
     * 相比mergeKLists
     * 这个方法，把每次p1或者p2的节点添加到p时，去掉了p1或者p2的后置节点。
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        //需要新链表时，使用一个虚拟节点技巧
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }

        while (!queue.isEmpty()) {
            //由于是小顶堆，拿出来的肯定是头节点最小的那个链表。
            ListNode head = queue.poll();

            ListNode tmp = head.next;
            head.next = null;
            p.next = head;

            if (tmp != null) {
                queue.add(tmp);
            }

            p = p.next;
        }

        return dummy.next;

    }


    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(1, 4, 5);
        ListNode listNode2 = ListNode.build(1, 3, 4);
        ListNode listNode3 = ListNode.build(2, 6);

        ListNode[] listNodes = (ListNode[]) Arrays.asList(listNode1, listNode2, listNode3).toArray();

        H23MergeKSortedLists list = new H23MergeKSortedLists();
        ListNode listNode = list.mergeKLists1(listNodes);

        ListNode.print(listNode);



    }
}
