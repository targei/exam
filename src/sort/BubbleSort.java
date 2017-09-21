package sort;

/**
 * Created by liq on 2017/9/21.
 *
 * 冒泡排序
 * 时间负责度：O（N*N）
 */
public class BubbleSort {

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
        BubbleSort bubble = new BubbleSort();
        int[] data ={6,4,3,2,1,5,4};
        bubble.sort(data);
        for(int x : data){
            System.out.print( x+" ");
        }
    }


}
