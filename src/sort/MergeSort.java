package sort;

/**
 * Created by liq on 2017/9/19.
 */
public class MergeSort {

    public void sort(int[] data, int[] tempArray, int head, int tail) {
        if (head >= tail){
            return;
        }else {
            int splitPostion = (head + tail) / 2;
            sort(data, tempArray, head, splitPostion);
            sort(data, tempArray, splitPostion + 1, tail);
            merge(data, tempArray, head, splitPostion, tail);
        }
    }

    //把原数组中的两个字串的mrege结果放入到临时数组，然后在copty会原数组的相应位置。
    private void merge(int[] data, int[] tempArray, int head, int splitPostion, int tail) {

        int i = head;
        int j=splitPostion+1;
        int k = head;
        while(true) {
            if (data[i] < data[j]) {
                tempArray[k++] = data[i++];
            } else if (data[i] > data[j]) {
                tempArray[k++] = data[j++];
            } else {
                tempArray[k++] = data[i++];
                tempArray[k++] = data[j++];
            }
            //只要有一个子串处理完，就无需在比较，退出循环
            if(i>splitPostion || j>tail) break;
        }
        //判断还没有来的及处理的元素，追加到后面
        //重点
        if(i>splitPostion){
            while(j<=tail){
                tempArray[k++] = data[j++];
            }
        }
        if(j>tail){
            while(i<=splitPostion){
                tempArray[k++] = data[i++];
            }
        }

        for(int p=0;p<k;p++){
            data[p]=tempArray[p];
        }

    }

    public static void main(String[] args){
        MergeSort ms = new MergeSort();
        int[] data = {10,5,4,1,9,8,2,5,4,1,9,8,2};
        int temArray[] = new int[data.length];
        ms.sort(data,temArray,0,data.length-1);

        for(int x : data){
            System.out.print(x+",");
        }
    }
}
