package zhige;

/**
 * 344. 反转字符串
 * https://leetcode.cn/problems/reverse-string/
 * @author wangyongzhi
 * @date 2023-02-19
 */
public class E344ReverseString {


    public void reverseString(char[] s) {

        int left = 0, right = s.length - 1;

        for (; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }


    }



    public static void main(String[] args) {
        char[] chars = {'h','e','l','l','o'};

        E344ReverseString array = new E344ReverseString();
        array.reverseString(chars);

        ArrayUtils.print(chars);

        System.out.println("");

    }
}
