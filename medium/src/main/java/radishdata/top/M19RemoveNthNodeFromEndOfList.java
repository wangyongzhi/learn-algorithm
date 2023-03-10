package radishdata.top;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @author wangyongzhi
 * @date 2023-02-16
 */
public class M19RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        if (x == null) {
            return null;
        }
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;

    }

    /**
     * 返回链表的倒数第 k 个节点。
     * 第一个节点下走k步，然后第二个节点从头开始走，等第一个节点走到头的时候，第二个节点刚好是倒数第k个节点。
     *
     * @param head
     * @param k
     */
    private ListNode findFromEnd(ListNode head, int k) {

        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
        return p2;
    }


    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(1,2,3,4,5);
        M19RemoveNthNodeFromEndOfList list = new M19RemoveNthNodeFromEndOfList();
        ListNode listNode = list.removeNthFromEnd(listNode1, 2);

        ListNode.print(listNode);

    }
}
