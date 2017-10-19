package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by liq on 2017/10/19.
 * 找出数组中和为0的任意三个数，可能会有多个结果。
 * 思路：一个数循环，另外两个数在剩余空间互相逼近。 夹逼法。
 * 复杂度： 2次方复杂度。
 * https://leetcode.com/problems/3sum/discuss/
 *
 */
public class Sum3 {

    public ArrayList<String> sum3(int[] array,int sumOf3){
        ArrayList result = new ArrayList<String>();
        Arrays.sort(array);
        for(int i=0; i<array.length-2; i++){//三个数据和，所以i移动到还剩两个元素就需要停止了。
            //如果非首元素，且当前元素与上一个元素相同时，不需要重复处理，直接移动下标。
            if(i>0 && array[i]==array[i-1]){
                i++;
                continue;
            }
            int low=i+1;
            int hi=array.length-1;
            int sumOf2=sumOf3-array[i];
            while(low<hi){
                int currSum=array[low]+array[hi];
                if(array[low]+array[hi]==sumOf2){
                    //bypass same element.
                    while(array[low]==array[low+1])low++;
                    while(array[hi]==array[hi-1])hi--;
                    result.add(array[i]);
                    result.add(array[low]);
                    result.add(array[hi]);
                    result.add("=============");
                    low++;
                    hi--;
                }else if(currSum<sumOf2){
                    low++;
                }else if(currSum>sumOf2){
                    hi--;
                }else{
                 //nothing.
                }
            }
        }

        return result;
    }


    public static void main(String args[]){
        int[] a = {1,2,4,9,8,2,4,3,3};
        Sum3 sum3 = new Sum3();
        ArrayList rst = sum3.sum3(a,7);
        for (Object x:rst){
            System.out.println(x);
        }
    }


}

