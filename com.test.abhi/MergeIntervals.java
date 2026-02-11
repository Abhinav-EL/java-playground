import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/ https://neetcode.io/problems/merge-intervals/history
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length<=1){
            return intervals;
        }
        List<int[]> finalResult = new LinkedList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int[] currInterval = intervals[0];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<=currInterval[1]){
                currInterval[1] = Math.max(currInterval[1],intervals[i][1]);
            } else{
                finalResult.add(currInterval);
                currInterval = intervals[i];
            }
            //Last interval
            if(i==intervals.length-1){
                finalResult.add(currInterval);
            }
        }

        int[][] finalArray = new int[finalResult.size()][];
        for(int i=0; i< finalResult.size();i++){
            finalArray[i] = (int[]) finalResult.get(i);
        }

        return finalArray;
    }
}
