package bitmap;

/**
 * Created by liq on 2017/10/17.
 * Question：
 * 几亿个整数中需要查找是否包含某几个特殊的。
 * 下面的测试中不考虑那么大的文件，只是实现一个bitmap的查找算法
 * 如：有40亿个身份证号，判断某一个身份证号是否在其中。
 */
public class BitMapSearch {
    private boolean find( int[] bitmap,long x){
        boolean found = false;
        int element = bitmap[(int)x>>5];
        int reminder=(int)x&31;
        if(reminder>0) {
            if ((element & (1 << reminder - 1)) > 1) {
                found = true;
            }
        }
        return found;
    }

    //使用一个char数组保存bitmap。每个char可以保存8位。
    public int[] buildBitMap(long[] data){
        int[] bitmap = new int[10];
        for(long v : data){
            int index= (int)v>>5;
            System.out.println("After"+v+" divided by 32:"+index);
            System.out.println(Integer.toBinaryString(31));
            int reminder=(int)v&31;//余数
            System.out.println("商："+index+"  余数:"+reminder);
            if (reminder > 0) {
               bitmap[index]|=(1<<(reminder-1));
            }
        }
        return bitmap;
    }


    public static void main(String args[]){
        //数据集
        BitMapSearch object = new BitMapSearch();
        long[] data = new long[]{2};//342101197701021810L
        int[] bitmap = object.buildBitMap(data);
        for(int x:bitmap){
            System.out.println(Integer.toBinaryString(x));
        }

        int toFind = 2;
        if(object.find(bitmap,toFind)){
            System.out.println("found:"+toFind);
        }else{
            System.out.println("Not found:"+toFind);
        }
    }

}
