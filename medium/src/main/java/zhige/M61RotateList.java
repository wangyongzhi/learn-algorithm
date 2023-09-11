package zhige;

/**
 * 61. 旋转链表
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * https://leetcode.cn/problems/rotate-list/description/
 *
 * @author wangyongzhi
 * @date 2023/9/11
 */
public class M61RotateList {

    /**
     * 把链表首位相连，变成一个环。需要先遍历一遍
     * 如果k>=n，那可以用k取模n。
     * 然后走k步，把首尾节点处理一下。
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 1;
        ListNode p = head;

        //遍历一遍算出链表长度为n。此处必须是p.next,这样遍历到可以遍历到最后一个不为null的节点。
        // 如果是用p，则遍历到了null节点，没法与head连接在一起了。
        while (p.next != null) {
            n++;
            p = p.next;
        }

        int mod = k % n;
        if (mod == 0) {
            return head;
        }

        //要移动的步数。
        // 注意这个时候，p已经在原先链表的末尾节点了，要移动的步数不再是k
        //如果是12345，那现在p指向的是5.
        //最终要变为45123，相当于从5开始，移动 n-mod，然后再把尾部断掉即可。
        int add = n - mod;

        //把末尾拼上头
        p.next = head;

        while (add-- > 0) {
            p = p.next;
        }

        //剪断这个环。
        ListNode tmp = p.next;
        p.next = null;

        return tmp;

    }
}
