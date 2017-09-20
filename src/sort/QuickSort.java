package sort;

/**
 * Created by liq on 2017/9/19.
 */
public class QuickSort {

    //仅仅取中间位置的元素作为pivot，不管其大小。
    void quickSortMiddlePosition(int[] data, int head,int tail){
        System.out.println("");
        System.out.print("current array part: ");
        for(int x =head;x<=tail;x++){
            System.out.print(data[x]+"  ");
        }
        System.out.println("");

        int pivotIndex = (tail-head)/2+head;
//        int pivotIndex = (tail+head)/2;
        int pivot=data[pivotIndex];
        System.out.println("pviot index is : "+pivotIndex);
        System.out.println("pviot is : "+pivot);
        //exchange pivot and tail
        data[pivotIndex]=data[tail];
        data[tail]=pivot;

        System.out.println("");
        System.out.print("after exchange pivot: ");
        for(int x =head;x<=tail;x++){
            System.out.print(data[x]+"  ");
        }
        System.out.println("");

        int i = head;
        int j = tail-1;

        while(i<=j){
            //System.out.println("i:"+i+" j:"+j);
            while(i<=tail && data[i]<pivot){
                i++;
               // System.out.println("i:"+i);
            }
            while( j>=head && data[j]>pivot ){
                j--;
               // System.out.println(" j:"+j);
            }
            //both head and tail stopped,exchange them
            if(i<j) {
                int tem = data[i];
                data[i] = data[j];
                data[j] = tem;
                i++;
                j--;
            }else{break;}
        }//end this recursive call

        System.out.println("");
        System.out.print("after sorted part: ");
        for(int x =head;x<=tail;x++){
            System.out.print(data[x]+"  ");
        }
        System.out.println("");

        //exchange pivot and tail back
        int tem = data[i];
        data[i]=data[tail];
        data[tail]=tem;


        System.out.println("");
        System.out.print("after exchange back part: ");
        for(int x =head;x<=tail;x++){
            System.out.print(data[x]+"  ");
        }
        System.out.println("");


        //recursively call tow segments.
        if(head<i) {
            quickSortMiddlePosition(data, head, i-1 );
        }
        if(tail>i){
            quickSortMiddlePosition(data,i+1,tail);
        }

    }

    //取 头/尾/中 三个位置的中间值作为pivot
    void quickSortMiddleValue(int[] data, int head,int tail){
        if(head==tail) return;
        int pivot = getPivot(data,head,tail);
        int i = head+1;
        int j = tail-1;
        if(i<=j){
            while(true){
               while(data[i]<pivot) i++;
               while(data[j]>pivot) j--;
               if(i<j){
                   swapElement(data,i,j);
               }else{
                   break;
               }
            }
        }
        quickSortMiddleValue(data,head,i-1);
        quickSortMiddleValue(data,i++,tail);
    }

    //换取到pivot并将中间值交换到倒数第二位，因为排序过，pivot肯定比尾部的值小。
    public int getPivot(int[] data , int head, int tail) {
        int pivotIndex = (head + tail) / 2;
        //put head,middle,tail with asc order.
        if (data[pivotIndex] < data[head]) {
            swapElement(data, head, pivotIndex);
        }
        if (data[head] > data[tail]) {
            swapElement(data, head, tail);
        }
        if (data[pivotIndex] > data[tail]) {
            swapElement(data, tail, pivotIndex);
        }

        if (tail > 0) {
            //the tail must no little than pivot. so exchange pivot with 2nd back.
            swapElement(data,pivotIndex,tail-1);
            return data[tail-1 ];
        } else {
            throw new IllegalArgumentException("cannot extract the pivot from a array with less 1 length.");
        }

    }
    //交换数组中两个元素的值
    public void swapElement(int[] data, int index1,int index2){
        int tem = data[index1];
        data[index1]=data[index2];
        data[index2]=tem;
    }

    public static void main(String args[]){
        int data[] = {1,43,55,2,9,10};
        //int data[] = {1,0};

        QuickSort quickSort = new QuickSort();
        quickSort.quickSortMiddleValue(data,0,data.length-1);
        System.out.println();
        for(int x : data){
            System.out.print(x+"   ");
        }

    }


}
