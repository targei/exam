/**
 * Created by liq on 2017/10/17.
 * 用于进程调度、服务器请求调度等。特点：无状态
 * 可以通过增加权值实现负载均衡（比如服务器的处理能力强的时候，可以把权值设置的高一些，这样可以分配更多的请求）
 * RobinRound:平等
 * WeightRobinRound：带权值
 *
 */

public class RobinRound {

    public static void main(String args[]){
//        BasicRobinRound basic = new BasicRobinRound(5);
//        for(int i = 0 ; i < 12 ; i ++ ){
//            basic.request();
//        }
        System.out.println("=====================================================");
        //
        WeightRobinRound wrb = new WeightRobinRound(4);
        for(int i = 0 ; i < 20 ; i ++ ){
            wrb.request();
        }
    }

}


 class BasicRobinRound {
     //使用链表构造一个环
     int size = 0;
     NodeType head = new NodeType(0);

     //使用时的位置
     NodeType curr = head;
     public BasicRobinRound(int count){
         size=count;
         NodeType current = head;
         for(int i=1;i<count;i++){
             NodeType tem =new NodeType(i+10);
             if(current==null){
                 head=current;
             }else{
                 current.next=tem;
             }
             current=tem;
         }
         current.next=head;
     }
     public void request(){
         curr=curr.next;
         System.out.println(curr.weight);
     }

}


 class WeightRobinRound {

     //使用链表构造一个环
     NodeType head = new NodeType(1);

     //使用时的位置
     NodeType curr = head;
     public WeightRobinRound(int count){
         NodeType current = head;
         for(int i=1;i<count;i++){

             NodeType tem =new NodeType(i+1);
             if(current==null){
                 head=current;
             }else{
                 current.next=tem;
             }
             current=tem;
             System.out.println("weight:"+current.weight +" , cw :"+current.cw);
         }
         current.next=head;
     }
     public void request(){
         while(true) {
             curr.cw = curr.cw-1;
             if (curr.cw < 0) {
                 curr=curr.next;
                 if(curr==head){
                     resetWeight(head);
                 }
             }else{
                 System.out.println("after process this rquest. curent node status: weight:"+curr.weight +" , cw :"+curr.cw);
                 break;
             }
         }
     }

     public void resetWeight(NodeType node){
         if(node.next!=head){
             resetWeight(node.next);
         }
         System.out.println("--reset:");
         System.out.println("before reset :　weight:"+node.weight +" , cw :"+node.cw);
         node.cw =node.weight;
         System.out.println("after reset :　weight:"+node.weight +" , cw :"+node.cw);

     }


}

// 链表节点
 class NodeType{
     public int weight;
     public NodeType next;
     public int cw = 0;
     NodeType(int weight, NodeType next){
         this.next   = next;
         this.weight = weight;
     }
    NodeType(int weight){
        this.weight = weight;
        this.cw=weight;
    }


}

