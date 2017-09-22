package sort;

/**
 * Created by liq on 2017/9/21.
 *
 * 希尔排序
 * 时间负责度，
 */
public class ShellSort {

    // gap: N/2,N/4,N/8,N/16.
    //希尔数列：最坏时间复杂度 O(N*N)
    private void sortShell(int[] data){
        for( int gap=data.length/2;gap>0;gap/=2 ){
            for (int p=gap; p < data.length; p+=gap) {//p：待排序。 1 to p-1 已经排序
                int temp = data[p];
                int i = p;
                for (; i > 0 && temp < data[i - gap]; i-=gap) {
                    data[i] = data[i - gap];
                }
                data[i] = temp;//此时i已经在退出时--过，对应位置正好是空出来的位置。
            }//end for i

        }
    }

    // gap: 1,3,7,15... 2的N次方-1.避免公约数
    //希尔数列：最坏时间复杂度 O(2的1.5方)， 比2的平方略好。
    private void sortHibbard(int[] data){
        for( int gap=(data.length/2)-1;gap>0; gap/=2 ){
            gap-=1;
            //最小的gap再减去1可能是0，此时变回1处理。
            if(gap==0){
                gap=1;
            }
            for (int p=gap; p < data.length; p+=gap) {//p：待排序。 1 to p-1 已经排序
                int temp = data[p];
                int i = p;
                for (; i > 0 && temp < data[i - gap]; i-=gap) {
                    data[i] = data[i - gap];
                }
                data[i] = temp;//此时i已经在退出时--过，对应位置正好是空出来的位置。
            }//end for i

        }
    }

    public static void main(String args[]){
        ShellSort insertion = new ShellSort();
        int[] data ={6,8,2,10,23,2222,0,99,77,33,0,3,2,1,5,8};
//        insertion.sortShell(data);
        insertion.sortHibbard(data);
        for(int x : data){
            System.out.print( x+" ");
        }
    }


}