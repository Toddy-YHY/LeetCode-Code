package zerohandred;

import org.junit.Test;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * Created by Toddy on 2020/3/23.
 */
public class Q28 {

    @Test
    public void test() {
        System.out.println(strStr("a", "a"));
    }

    /**
     *
     */
    public int strStr(String haystack, String needle) {
        if (null == needle || needle.length() == 0) {
            return 0;
        }
        if (null == haystack || haystack.length() == 0) {
            return -1;
        }
        char[] chars = haystack.toCharArray();
        char[] find = needle.toCharArray();
        int len = 0;
        for (int i = 0; len < chars.length - find.length + 1; ) {
            if (chars[len + i] != find[i]) {
                i = 0;
                len++;
            } else {
                i++;
                if (i == find.length) {
                    return len;
                }
            }
        }
        if (len > chars.length - find.length ) {
            return -1;
        }
        return len;
    }


}
