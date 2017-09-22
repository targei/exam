package sort;

/**
 * Created by liq on 2017/9/21.
 *
 * 插入排序
 * 时间负责度：O（N*N）
 */
public class InsertionSort {

    private void sorts(int[] data){
        for(int p=1;p<data.length;p++){//p：待排序。 1 to p-1 已经排序
            int temp=data[p];
            int i=p;
            for(;i>0 && temp<data[i-1];i--) {
                data[i] = data[i - 1];
            }
            data[i]=temp;//此时i已经在退出时--过，对应位置正好是空出来的位置。
        }//end for i
    }

    public static void main(String args[]){
        InsertionSort insertion = new InsertionSort();
        int[] data ={6,4,1,10,21,3};
        insertion.sorts(data);
        for(int x : data){
            System.out.print( x+" ");
        }
    }


}
