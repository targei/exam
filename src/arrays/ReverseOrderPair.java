package arrays;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

/**
 * Created by liq on 2017/10/20.
 * 找出逆序对个数：一对数组元素，他们的下标从小到大，但是数值从大到小。
 *
 * 两种方法：
 * 暴力发：0(N^2)复杂度。
 * 分治法
 */
public class ReverseOrderPair {


    //暴力方式遍历，比较
    public ArrayList<String> findWithForce(int[] data){
        ArrayList<String> pairs = new ArrayList();
        for(int i=0;i<data.length-1;i++){
            for(int j=i+1;j<data.length;j++){
                if(data[i]>data[j]){
                    pairs.add(data[i]+" and "+data[j]);
                }
            }
        }
        return pairs;
    }

    /**
     * 使用分治处理达到 O(N*LogN)。
     * 归并排序的merge过程中可以发现逆序对
     *  思路：
     *  通过递归，从下片到大片合并处理。每个小片都在内部已经找出了所有的逆序对。在合并时只需要判断两个下片之间存在多少逆序对。
     *  所有的逆序对加在一起。因为排序过程中下表会移动，所以如果想统计数组下标，是排序后的下标，而不是排序前的。
     *
     **/
    public ArrayList<String> findWithDivideAndConquer(int[] data) {
        ArrayList<String> pairs = new ArrayList();
        //todo 就是归并排序。

        return pairs;

    }

    public static void main(String args[]){
        int[] data = {5,4,9};

        ReverseOrderPair object = new ReverseOrderPair();
        ArrayList<String> reverseOrderPairs = object.findWithForce(data);
        for(String x : reverseOrderPairs){
            System.out.println(x);
        }

    }




}
