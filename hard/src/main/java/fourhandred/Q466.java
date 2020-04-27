package fourhandred;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 466. 统计重复个数
 * 由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
 * <p>
 * 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
 * <p>
 * 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。
 * <p>
 * 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * s1 ="acb",n1 = 4
 * s2 ="ab",n2 = 2
 * <p>
 * 返回：
 * 2
 * <p>
 * Created by Toddy on 2020/4/19.
 */
public class Q466 {

    @Test
    public void test() {
        System.out.println(getMaxRepetitions("acb", 4, "ab", 2));
    }


    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int index1 = 0;
        int index2 = 0;
        if (len1 == 0 || len2 == 0 || len1 * n1 < len2 * n2) {
            return 0;
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int ans = 0;
        for (; index1 / len1 < n1; index1++) { // 遍历整个 Ra
            if (index1 % len1 == len1 - 1) { //在 Sa 末尾
                Integer val = map1.get(index2 % len2);
                if (val != null) { // 出现了循环，进行快进
                    int cycleLen = index1 / len1 - val / len1;               // 每个循环占多少个 Sa
                    int cycleNum = (n1 - 1 - index1 / len1) / cycleLen;   // 还有多少个循环
                    int cycleS2Num = index2 / len2 - map2.get(index2 % len2) / len2;// 每个循环含有多少个 Sb

                    index1 += cycleNum * cycleLen * len1; // 将 Ra 快进到相应的位置
                    ans += cycleNum * cycleS2Num;     // 把快进部分的答案数量加上
                } else { // 第一次，注意存储的是未取模的
                    map1.put(index2 % len2, index1);
                    map2.put(index2 % len2, index2);
                }
            }

            if (s1.charAt(index1 % len1) == s2.charAt(index2 % len2)) {
                if (index2 % len2 == len2 - 1) {
                    ans += 1;
                }
                index2 += 1;
            }
        }
        return ans / n2;
    }
}
