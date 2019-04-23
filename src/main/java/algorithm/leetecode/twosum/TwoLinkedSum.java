package algorithm.leetecode.twosum;

/**
 * @Package: algorithm.leetecode.twosum
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 19/03/2019.
 */
public class TwoLinkedSum {

    public static void main(String[] args) {
        TwoLinkedSum tls = new TwoLinkedSum();
        tls.test();
    }

    public void test(){
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(4);
        ListNode p3 = new ListNode(3);
        p1.next = p2;
        p2.next = p3;

        ListNode q1 = new ListNode(5);
        ListNode q2 = new ListNode(6);
        ListNode q3 = new ListNode(4);
        q1.next = q2;
        q2.next = q3;
        ListNode first = addTwoNumbers(p1, q1);
        print(first);
    }

    public void print(ListNode p){
        while (p != null) {
            System.out.println(p.val);
            if (p != null) {
                p = p.next;
            }
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //反向遍历， 加法进位
        //carry标识进位
        int carry = 0;
        //新链表头结点
        ListNode first = new ListNode(0);
        ListNode p = l1, q= l2, curr = first;

        //链表长度不同
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null){
                p = p.next;
            }
            if (q!=null){
                q = q.next;
            }
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return first.next;
    }


     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }

         public void setVal(int val) {
             this.val = val;
         }

         public void setNext(ListNode next) {
             this.next = next;
         }

         public int getVal() {
             return val;
         }

         public ListNode getNext() {
             return next;
         }
     }


}
