import java.util.Arrays;

/**
 * Created by liq on 2017/9/11.
 * 一个字符串，使用一个字符替换另外一个字符，允许替换K次，找出替换后最大可能的重复字符的子串的长度。
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * 424.Longest Repeating Character Replacement
 */
public class LargestRepeatSubstring {
    public static int find(String origStr,int replaceTimes){
        int[] count = new int[128];
        int maxLength=0,maxCount=0;
        int start=0,end =0;
        char[] origStrArray = origStr.toCharArray();
        int strLength = origStrArray.length;
        for(;end<strLength;end++){
            maxCount=Math.max(maxCount,++count[origStrArray[end]]);
            System.out.println("end position  "+end);
            System.out.println("current end char count:  "+count[origStrArray[end]]);
            //该循环可以去掉，因为目的是找最大的，如果end，start同时后移
            while(replaceTimes<(end-start+1-maxCount)){
                count[origStrArray[start++]]--;
            }
            maxLength=Math.max(maxLength,maxCount);
        }
        return maxLength+replaceTimes;
    }


    public static void main(String[] args){
        int maxLength = find("AAABAC",1);
        System.out.println(maxLength);
    }

}
