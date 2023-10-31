package zhige;

/**
 *
 * 415. 字符串相加
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 *
 * https://leetcode.cn/problems/add-strings/description/
 *
 * @author wangyongzhi
 * @date 2023/10/28
 */
public class E415AddStrings {

    /**
     * 从右往左加。
     * carry代表进位，比如6+7=13, carry=1，
     * 加之后的结果模10就是那一位的结果。也就是13中的3
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        //只要两者还有值，就要继续加
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        //如果加到最后还有个进位，需要再最高位加上个1
        if(carry == 1) {
            res.append(1);
        }
        //反转一下。
        return res.reverse().toString();

    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123";

        E415AddStrings e415AddStrings = new E415AddStrings();
        String s = e415AddStrings.addStrings(s1, s2);
        System.out.println(s);

    }
}
