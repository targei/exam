/**
 * Created by liq on 2017/10/23.
 *
 */
public class LargestRectangleInHistogram {

    //暴力方法，前后扫描 N^2
    public int findWithForce(int[] data){
        int maxArea = 0;
        for(int i=0;i<data.length;i++){
            int thisBar=data[i];
            int tem=0;
            for(int j=i-1;j>=0 && data[j]>thisBar;j--){
                tem+=maxArea;
            }
            for(int k=i+1;k<data.length&& data[k]>thisBar;k++){
                tem+=maxArea;
            }
            int currMax=Math.max(thisBar,tem);
            maxArea=Math.max(currMax,maxArea);
        }
        return maxArea;
    }


    public static void main(String args){
        //数组的每个元素是柱状图的高，设柱状图宽度唯一。简化输入数据。
        int[] bars = new int[]{1,2,1,3};
        LargestRectangleInHistogram object = new LargestRectangleInHistogram();
        int maxArea = object.findWithForce(bars);
        System.out.println(maxArea);
    }


}
