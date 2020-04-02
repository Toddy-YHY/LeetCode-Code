package zerohandred;

import org.junit.Test;

/**
 * 58. 最后一个单词的长度
 * <p>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * Created by Toddy on 2020/3/29.
 */
public class Q58 {

    @Test
    public void test() {
        String s = "12 122 33   3";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }

    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].length() > 0) {
                return split[i].length();
            }
        }
        return 0;
    }

    public int lengthOfLastWord2(String s) {
        s = s.trim();
        int start = s.lastIndexOf(" ") + 1;
        return s.substring(start).length();
    }

    public int lengthOfLastWord3(String s) {
        s = s.trim();
        return s.length() - 1 - s.lastIndexOf(" ");
    }
}
