package zhige;

import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * @author wangyongzhi
 * @date 2023/9/20
 */
public class E20ValidParentheses {

    public boolean isValid(String s) {
        //用一个栈存左括号，如果遇到右括号，就弹出一个左括号
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                if (!stack.isEmpty() && leftOf(c) == stack.peek()) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }

        return stack.isEmpty();


    }

    private Character leftOf(char c) {
        if (c == ')') {
            return '(';
        }
        if (c == '}') {
            return '{';
        }
        if (c == ']') {
            return '[';
        }
        return null;
    }
}
