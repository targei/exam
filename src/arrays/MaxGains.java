package arrays;

/**
 * Created by liq on 2017/10/19.
 * 例子： 数组元素为按时间排列的股价。
 * 求买卖的最大收益
 *
 */
public class MaxGains {
    //方法一，通过slide window移动。
    public int solveWithSlideWindow(int[] data){
        int max=0;
        int buy=0;
        int sale=1;
        int min_i=data[0];
        int max_j=data[1];

        while(sale<data.length){
            if(data[buy]<min_i){
                min_i=data[buy];
            }
            //只有当发现更高的卖点时，才需要往后移动买点，寻找此间的更低买点。
            if(data[sale]>max_j){
                max_j=data[sale];
                max=max_j-min_i;
                sale++;
            }
            if(buy==sale-1){
                sale++;
            }else{
                buy++;
            }
        }

        return max;
    }


    public int solveWithRecurrsive(int[] data,int i,int j) {
        if(j==i){
            return data[i];
        }
        int m = (i+j)/2;
        int maxLeft=solveWithRecurrsive(data,i,m);
        int maxRight=solveWithRecurrsive(data,m+1,j);
        //跨左右的最大收益
        int middle_left_max=data[m];
        int middle_right_max=data[m+1];
        for(int x=m-1;x>=0;x--){
            if(middle_left_max<middle_left_max+data[x]){
                middle_left_max=middle_left_max+data[x];
            }

        }
        for(int y=m+2;y<=j;y++){
            if(middle_right_max<middle_right_max+data[y]){
                middle_right_max=middle_right_max+data[y];
            }

        }
        return Math.max(Math.max(maxLeft,maxRight),middle_left_max+middle_right_max);
    }

    public static  void main(String args[]){
//        MaxGains test = new MaxGains();
//        int[] input = {100,30,50,300,10,600};
//        int rst = test.solveWithSlideWindow(input);
//        System.out.println("max gains:" + rst);


        MaxGains test = new MaxGains();
        int[] input = {100,30,50,300,10,600};
        //转换成相邻的收益数组：day n by , day n+1 sale.
        int []earnings=new int[input.length-1];
        for(int i=0;i<input.length-1;i++){
            earnings[i]=input[i+1]-input[i];
        }

        int rst = test.solveWithRecurrsive(earnings,0,earnings.length-1);
        System.out.println("max gains:" + rst);

    }



}
