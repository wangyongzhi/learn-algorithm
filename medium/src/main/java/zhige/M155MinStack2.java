package zhige;

import java.util.Stack;

/**
 * 155. 最小栈
 * https://leetcode.cn/problems/min-stack/
 * 时间复杂度 O（1）、空间复杂度都为O（n）
 * @author wangyongzhi
 * @date 2023/7/11
 */
public class M155MinStack2 {

    /**
     * 用来存储所有栈数据
     */
    private Stack<Integer> stackData;
    /**
     * 用来存储最小栈数据，
     * 1、每次比较一下，如果小于等于栈顶数据，则压进去，大于也压当前最小值，这样处理的好处是压的时候麻烦，取的时候方便
     * 2、移除最小值，直接移除stackData、stackMin即可
     */
    private Stack<Integer> stackMin;

    /** initialize your data structure here. */
    public M155MinStack2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();

    }

    public void push(int x) {
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else if (x < this.getMin()) {
            stackMin.push(x);
        }else {
            Integer newMin = this.stackMin.peek();
            stackMin.push(newMin);
        }
        this.stackData.push(x);
    }

    public void pop() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        stackData.pop();
        stackMin.pop();
    }

    public int top() {
        return stackData.peek();

    }

    public int getMin() {
        return stackMin.peek();
    }


    public static void main(String[] args) {
        M155MinStack2 minStack = new M155MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top()); //--> 返回 0.
        System.out.println(minStack.getMin()); //--> 返回 -2.
    }
}
