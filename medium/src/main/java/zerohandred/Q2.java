package zerohandred;

import org.junit.Test;
import pojo.ListNode;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * Created by Toddy on 2020/3/19.
 */
public class Q2 {

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        l1.next = l2;
        System.out.println(addTwoNumbers(l1, l3));
    }


    /**
     * 从第一位开始加，如果相加超过10，则进位，如果短链表node为null，设为0，
     * 最后一个node加起来超过10，则创建新的node
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int last = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + last;
            last = sum / 10;
            sum = sum % 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (last == 1) {
            tail.next = new ListNode(1);
        }
        return head.next;
    }
}
