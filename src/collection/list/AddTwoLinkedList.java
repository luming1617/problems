package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 *
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 2) + (5 -> 6 -> 4)
 Output: 6 -> 0 -> 8
 *
 * @author: liuluming
 * @CreatedDate: 2017/10/9 上午11:35
 */
public class AddTwoLinkedList {

    /**
     * 我的解法：
     * 一开始我把链表转成了线性表List，然后用索引取值，很傻。
     * 正确的遍历做法是：使用while，判断next是否为空。
     * 不足：使用了一个List临时存储链表的节点，空间占用较大。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int nextValue = 0;
        List<ListNode> resultList = new ArrayList<>();
        //题目并没有要求传入的链表长度一致，所以只要任意一个链表还没结束，就还要继续计算；如果结果超过9，也要继续计算。
        while (l1 != null || l2 != null || nextValue == 1) {

            // 计算当前位置的值。
            Integer value = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + nextValue;
            //除10取整，当nextValue==1时，继续计算。
            nextValue = value / 10;
            //除10取余
            value = value % 10;

            ListNode result = new ListNode(value);
            resultList.add(result);

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //将线性表转为链表
        for (int j = 0; j < resultList.size(); j++) {
            if (j != resultList.size() - 1) {
                resultList.get(j).next = resultList.get(j + 1);
            }
        }
        return resultList.get(0);
    }

    /**
     * 推荐方法：
     * 创建链表数组，可以先建一个虚拟链表头，next指向真正的表头元素。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        // 最后一次计算得到的置的值如果大于9，则必须再进一位。
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}

/**
 * 总结：
 *
 1. 遍历链表数组，使用while，判断next是否为空。而不是先转List，再用索引；
 2. 创建链表数组，可以先建一个虚拟链表头，next指向真正的表头元素（方法2）；避免再遍历一边，赋值next（方法1）。
 */
