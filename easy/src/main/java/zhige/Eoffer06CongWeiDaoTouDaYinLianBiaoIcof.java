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
