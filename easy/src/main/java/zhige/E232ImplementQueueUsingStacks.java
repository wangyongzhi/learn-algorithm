package zhige;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * @author wangyongzhi
 * @date 2023/7/11
 */
public class E232ImplementQueueUsingStacks {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    public E232ImplementQueueUsingStacks() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    /**
     * pop栈要一次性加满
     * 如果pop栈不为空，则不能往里面加，因为后面进入的就先取出了。
     */
    private void pushToPop() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    /**
     * 往队列里面加入数据
     */
    public void push(int x) {
        stackPush.push(x);
    }

    /**
     * 移除一个数据
     */
    public int pop() {
        pushToPop();
        return stackPop.pop();
    }

    /**
     * 获取一个数据，不移除。
     */
    public int peek() {
        pushToPop();
        return stackPop.peek();
    }

    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }

    public static void main(String[] args) {
        E232ImplementQueueUsingStacks myQueue = new E232ImplementQueueUsingStacks();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false

    }
}
