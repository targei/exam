package sort;

import javax.swing.text.AsyncBoxView;

/**
 * Created by liq on 2017/9/22.
 */
public class HeapSort {

    private void swap(int data[],int i, int j) {
        int tem = data[i];
        data[i]=data[j];
        data[j]=tem;
    }


    // suppose index i is the heep root. and it is changed.
    //j is last index keeper.
    private void buildHeap(int data[],int i,int stop) {
        int selectChild=0;
        for(;selectChild<stop;i=selectChild){
            int leftChildIdx = 2 * i + 1;
            int rightChildIdx = 2 * i + 2;
            int tem = data[i];
            selectChild = leftChildIdx;
            //如果存在左儿子或者右儿子比父节点大，则将大值交换到父节点。
            if(leftChildIdx<stop) {
                if (rightChildIdx < stop && data[rightChildIdx] > data[leftChildIdx]) {
                    selectChild = rightChildIdx;
                }
                if (tem < data[selectChild]) {
                    swap(data, i, selectChild);
                }else{
                    break;//父节点大，因为子树都是拍过序，终止循环。此时堆已经构建成。
                }
            }else{
                break;
            }
        }
    }

    //sort with heap.
    private void sort(int[] data) {
        //build the heap. from last not leaf node to the root.
        for(int i = data.length/2;i>=0;i--) { //length/2 ;  最深的leaf所在层的父层。也许也是叶子节点，判断其长度，忽略即可。
            buildHeap(data,i,data.length-1);
        }
        System.out.println("after build:");
        printArray(data);

        //大顶跟数组数组后面未排序的部分交换，然后堆排序。一次循环
        for(int j = data.length-1;j>=0;j--){
            swap(data,0,j);
            System.out.println("after swap:"+j);
            printArray(data);
            buildHeap(data,0,j-1);
            System.out.println("after build:"+j);
            printArray(data);
        }

    }

    private static void printArray(int[] data){
        for(int x : data){
            System.out.print(x+",");
        }
        System.out.print("\n");
    }


    public static void main(String[] args){
        HeapSort heapSort = new HeapSort();
        int[] data = {10,10,0,4,10,0,4,1111,0,10,32,4,4,9};
        heapSort.sort(data);

        System.out.println("After sort:");
        printArray(data);
    }


}
