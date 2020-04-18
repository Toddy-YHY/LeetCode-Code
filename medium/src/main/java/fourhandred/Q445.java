package fourhandred;

import org.junit.Test;
import pojo.ListNode;

import java.util.Stack;

/**
 * 445. 两数相加 II
 * <p>
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * Created by Toddy on 2020/4/14.
 */
public class Q445 {

    @Test
    public void test() {
        ListNode n1 = new ListNode(7);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(4);
        n1.next.next.next = new ListNode(3);
        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(n1, n2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        int last = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || last > 0) {
            int v1 = s1.isEmpty() ? 0 : s1.pop();
            int v2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = v1 + v2 + last;
            last = sum / 10;
            ListNode listNode = new ListNode(sum % 10);
            listNode.next = head;
            head = listNode;
        }
        return head;
    }
}
