package zhige;

/**
 *
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * @author wangyongzhi
 * @date 2023-02-19
 */
public class M5LongestPalindromicSubstring {

    /**
     * abacd
     * abbacd
     * 回文子串分为奇偶两种情况。从中间扩散的方式查找，奇数的时候l=r，偶数的时候，r=l+1
     */
    public String longestPalindrome(String s) {

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            String max = s1.length() > s2.length() ? s1 : s2;
            res = res.length() > max.length() ? res : max;
        }
        return res;
    }


    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    private String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--; r++;
        }

        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        // 以abacd为例，这时候l已经减到了-1，r等于3，所以l需要+1
        return s.substring(l + 1, r);
    }


    public static void main(String[] args) {
        String s = "bacad";

        M5LongestPalindromicSubstring substring = new M5LongestPalindromicSubstring();
        String r = substring.longestPalindrome(s);

        System.out.println(r);



        String s2 = "bacade";

        M5LongestPalindromicSubstring substring2 = new M5LongestPalindromicSubstring();
        String r2 = substring2.longestPalindrome(s2);

        System.out.println(r2);


    }
}
