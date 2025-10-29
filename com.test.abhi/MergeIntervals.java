import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));

        List<int[]> finalList = new ArrayList<>();
        int[] currInt = intervals[0];
        if(0 == intervals.length-1){
            finalList.add(currInt);
        } else {
            for(int i=1; i < intervals.length; i++){
                int[] now = intervals[i];
                //System.out.println("Passed Now: "+ now[0]+ ","+ now[1]);
                
                if(currInt[1]>=now[0]){
                    //System.out.println("Cond Current Int: "+ currInt[0]+ ","+ currInt[1]);
                    currInt[1] = Math.max(currInt[1], now[1]);
                    //System.out.println("Cond Current Int after: "+ currInt[0]+ ","+currInt[1]);
                } else {
                    //System.out.println("Current Int Here: "+ currInt[0]+ ","+ currInt[1]);
                    //System.out.println("Now Int Here: "+ now[0]+ ","+ now[1]);
                    finalList.add(currInt);
                    currInt = now;
                }
                if(i == intervals.length-1){
                    finalList.add(currInt);
                }
            }
        }
        

        int[][] finalArray = new int[finalList.size()][];
        for(int i=0; i< finalList.size();i++){
            finalArray[i] = (int[]) finalList.get(i);
        }

        return finalArray;
    }
}
