/**
 * Created by liq on 2017/9/20.
 */
public class LinkRevert {

    //==============
    // 非递归写法
    //===============

    private Node revertFor(Node head) {
        if(head==null){
            return null;
        }

        Node currNode = head;
        Node pre=null;
        while(true) {
            if (currNode != null) {
                Node next = currNode.getNext();
                currNode.setNext(pre);
                pre = currNode;
                currNode = next;
            }else{
                break;
            }
        }
        head.setNext(null);

        return pre;  //already set as the last current Node.

    }


    //=====================
    //  递归写法 ,笨方法
    //====================
    private Node revertImpl(Node current, Node nextNode){
        if(nextNode==null){
            return current;
        }
        Node tempNode = nextNode.getNext();//保存真正的下一个待处理节点。
        if(tempNode==null){
            nextNode.setNext(current);
            return nextNode;
        }else {
            Node head = revertImpl(nextNode, tempNode);
            nextNode.setNext(current);//反指
            return head;
        }
    }
    private Node revertRecursive(Node head) {
        Node oldHead = head;
        Node newHead = revertImpl(head,head.getNext());
        oldHead.setNext(null);
        return newHead;
    }

    /////////////////////
    //////////  递归写法2
    /////////  巧妙
    ////////////////////
    private Node revert_simple(Node head){
        //如果是空链表，直接返回空
        if(head==null){
            return null;
        }
        //到尾的时候，直接返回该节点，不在往下递归。
        if( head.getNext()==null){
            return head;
        }
        Node nextNode = head.getNext();
        Node reNode = revert_simple(nextNode);//递归到最后一个节点
        nextNode.setNext(head);
        head.setNext(null);
        return reNode;
    }


    //=================
    //  公共部分
    //========================
    private void printLink(Node head){
        System.out.print("head:"+head.v+" => ");
        Node node=head.getNext();
        while(node!=null){
            System.out.print("v:"+node+"->");
            node=node.getNext();
        }
    }


    public static void main(String[] args){
        LinkRevert object = new LinkRevert();
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node2);
        node2.setNext(node3);
        //Node newHead = object.revertRecursive(head);
//        Node newHead = object.revert_simple(head);
        Node newHead = object.revertFor(head);

        object.printLink(newHead);
    }



}
class Node {
    int v=0;
    private Node next = null;
    public void setNext(Node next){
        this.next=next;
    }
    public Node getNext(){
        return this.next;
    }
    
    public Node(int v){
        this.v = v;
    }
    public String toString(){
        if(next == null){
            return "I'm link head, value is :"+v;
        }else{
            return "Node value:"+v;
        }
    }
}