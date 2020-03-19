package fourhandred;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 * Created by Toddy on 2020/3/19.
 */
public class Q409 {

    @Test
    public void test() {
        String s = "bb";
        int i = longestPalindrome(s);
        System.out.println(i);
    }

    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * <p>
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * <p>
     * 注意:
     * 假设字符串的长度不会超过 1010。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * "abccccdd"
     * <p>
     * 输出:
     * 7
     * <p>
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     */
    public int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map m = new HashMap();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                m.remove(s.charAt(i));
                len++;
            } else {
                m.put(s.charAt(i), 1);
            }
        }
        return m.isEmpty() ? len * 2 : len * 2 + 1;
    }

    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }
}
