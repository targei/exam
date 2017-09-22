package sort;

/**
 * Created by liq on 2017/9/21.
 *
 * 冒泡排序
 * 时间负责度：O（N*N）
 */
public class SelectionSort {

    private void sort(int[] data){
        for(int i = 0; i<data.length-1 ; i++){//循环到倒数第二个元素，因为还需要与最后一个元素比较
            //把最小的放到i的位置。开始跟余下的比较 [i+1 to end]
            int index=i;
            for(int j=i+1; j<data.length;j++){
                if(data[j]<data[index]){
                    int temp = data[j];
                    data[j]=data[index];
                    data[index]=temp;
                }
            }//end for j
        }//end for i
    }

    public static void main(String args[]){
        SelectionSort selection = new SelectionSort();
        int[] data ={6,4,3,2,1,5,4};
        selection.sort(data);
        for(int x : data){
            System.out.print( x+" ");
        }
    }


}
