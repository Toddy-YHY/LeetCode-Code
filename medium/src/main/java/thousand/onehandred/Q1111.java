package thousand.onehandred;

import org.junit.Test;

/**
 * 1111. 有效括号的嵌套深度
 * <p>
 * Created by Toddy on 2020/4/1.
 */
public class Q1111 {

    @Test
    public void test() {
        int[] ints = maxDepthAfterSplit("()(())()");
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }

    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            ans[i] = (i & 1 ^ ('(' == seq.charAt(i) ? 1 : 0));
        }
        return ans;
    }
}
