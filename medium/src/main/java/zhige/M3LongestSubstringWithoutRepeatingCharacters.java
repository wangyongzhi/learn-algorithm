package zhige;

import java.util.HashMap;

/**
 *
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * @author wangyongzhi
 * @date 2023/9/19
 */
public class M3LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        //记录结果
        int res = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            //当字符的数量大于1时，左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            //记录结果
            res = Math.max(res, right - left);
        }

        return res;
    }
}
