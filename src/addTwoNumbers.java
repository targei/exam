
//https://leetcode.com/problems/add-two-numbers/description/
//题目规定链表头指向最低位。

public class addTwoNumbers {

    public ListNode addTwoNumbers_better(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    public ListNode addTwoNumbers_myself(ListNode l1, ListNode l2) {
        ListNode currNode = null;
        ListNode uppperNode = null;
        ListNode lowestNode = null;
        if (l1 == null && l2 == null) {
            return null;
        }
        while (l1 != null || l2 != null) {
            if (currNode == null) {//first time
                currNode = new ListNode(0);
                lowestNode=currNode;
            }

            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + currNode.val;
            int newV = sum % 10;
            int moveUP = sum / 10;
            currNode.val = newV;

            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null) {
                l2 = l2.next;
            }

            if(moveUP>0) {
                uppperNode = new ListNode(moveUP);
                currNode.next = uppperNode;
            }else if(l1!=null || l2!=null){//still need caculate , create upper
                uppperNode = new ListNode(0);
                currNode.next = uppperNode;
            }
            currNode=uppperNode;
        }

        return lowestNode;
    }

    public static void main(String args[]){
        addTwoNumbers o = new addTwoNumbers();
        //12+19
        ListNode l1 = new ListNode(2);
        l1.next=new ListNode(1);

        ListNode l2 = new ListNode(1);
        //l2.next=new ListNode(1);

        ListNode rst = o.addTwoNumbers_myself(l1,l2);
        while(rst.next!=null){
            System.out.print(rst.val);
            rst=rst.next;
        }
        System.out.print(rst.val);

    }

}



//链接表节点，每个节点保存一个数组，一个列表用来保存一个数。
//顺序 从低位到高位
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
