package collection.list;

/**
 * @author: liuluming
 * @CreatedDate: 2017/10/11 上午11:17
 */
public class MergeTwoSortedLinkedList {

    /**
     * 常规解法。
     * 思路：
     先定一个主链表，把另一个链表合并到这个主链表。
     假定一个链表dummy, 为方便遍历，设dummy的初始值为-1，next指向l1(主链表)。
     为了返回值，还得新加一个链表tempLink = dummy
     如果l1的值比l2小，templink = l1, 再遍历l1->next
     如果l1的值比l2大，则把temlink->next = l2, tempLink = tempLink->next, 再把tempLink批回主链表。
     但这样到最后有可能副链表还不为空，再加到后面就好。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        //虚拟链表
        ListNode dummy = new ListNode(-1);
        dummy.next = p1;
        ListNode tempLink = dummy;

        while(p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tempLink = p1;
                p1 = p1.next;
            } else {
                tempLink.next = p2;
                p2 = p2.next;
                tempLink = tempLink.next;
                tempLink.next = p1;
            }
        }
        // 副链表可能还不为空，再加到后面就好。
        if (p2 != null) {
            tempLink.next = p2;
        }

        return dummy.next;

    }


    /**
     * 递归解法。
     * 思路：我们构造一个新的ListNode，就叫做tmp，看着像是一个临时变量。的确，从局部来看它是临时变量，每次都会将l1或者l2赋值给它，但这里的l1和l2都是动态变化的，最重要的是每次return的tmp都是一个新的链表，最后一次返回的也就是我们所合并出来的链表。
     * <p>
     * 我这里构造出来的链表顺序是由小到大的，因此当l1当前节点的值大于l2当前节点的值时，我们取的是l2这个较小的值，并将l2的下一个节点的值和l1当前节点的值放到下一次做对比，依次递归下去。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {


        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val > l2.val) {
            ListNode tmp = l2;
            tmp.next = mergeTwoLists2(l1, l2.next);
            return tmp;
        } else {
            ListNode tmp = l1;
            tmp.next = mergeTwoLists2(l1.next, l2);
            return tmp;
        }
    }
}

/**
 * 总结：
 * 1、两个链表可以同时遍历。
 * 2、
 */
