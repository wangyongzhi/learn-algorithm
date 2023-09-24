package zhige;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 *
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/implement-stack-using-queues/description/
 *
 * @author wangyongzhi
 * @date 2023/9/23
 */
public class E225ImplementStackUsingQueues {

    private Queue<Integer> q ;
    private int topStack = 0;

    public E225ImplementStackUsingQueues() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        topStack = x;
    }

    public int pop() {
        //先把队列最后一个元素（也即是栈顶元素）的前面的元素都移到它之后。
        // 以123为例，当前栈顶元素是3
        int size = q.size();
        while (size > 2) {
            q.offer(q.poll());
            size--;
        }
        //以123为例，移除3，还需要更新2为栈顶元素。刚才的判断>2，其实只移动了1到3后面，现在队列最前面是2，顺序为231
        topStack = q.poll();
        //把2放到1后面
        q.offer(topStack);
        //返回3
        return q.poll();
    }

    public int top() {
        return topStack;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
