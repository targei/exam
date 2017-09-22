package sort;

/**
 * Created by liq on 2017/9/21.
 * http://www.cnblogs.com/oumyye/p/4522467.html
 * 桶排序
 * d 为位数，r 为基数，n 为原数组个数。
 * 在基数排序中，因为没有比较操作，所以在复杂上，
 * 最好的情况与最坏的情况在时间上是一致的，均为 O(d * (n + r))。
 *
 */

public class BucketSort {

    private void sort(int[] data){
        for(int i=data.length ; i>0;i--){
            //把大的冒泡到顶部
            for(int j=0; j<i-1;j++){//注意： 要比较当前位置和下一个位置，所以循环条件终止于 倒数第二个元素。
                if(data[j]>data[j+1]){
                    int temp = data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }//end for j
        }//end for i
    }

    public static void main(String args[]){
        BucketSort sort = new BucketSort();
        int[] data ={6,4,3,2,1,5,4};
        sort.sort(data);
        for(int x : data){
            System.out.print( x+" ");
        }
    }


}
