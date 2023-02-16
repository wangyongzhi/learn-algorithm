package radishdata.top;

import java.util.*;

/**
 * 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 * @author wangyongzhi
 * @date 2023-02-16
 */
public class H23MergeKSortedLists {


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


    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(1, 4, 5);
        ListNode listNode2 = ListNode.build(1, 3, 4);
        ListNode listNode3 = ListNode.build(2, 6);

        ListNode[] listNodes = (ListNode[]) Arrays.asList(listNode1, listNode2, listNode3).toArray();

        H23MergeKSortedLists list = new H23MergeKSortedLists();
        ListNode listNode = list.mergeKLists(listNodes);

        ListNode.print(listNode);



    }
}
