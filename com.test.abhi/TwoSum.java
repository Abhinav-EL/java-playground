import java.util.TreeMap;
/**
 * Works easily with two for loops.
 * This implementation doesn't work when there repeating enteries, like [3, 3]
 */
//https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        TreeMap<Integer, Integer> indexMap = new TreeMap<Integer, Integer>();
        for(int i=0; i< nums.length; i++){
            indexMap.put(nums[i], i);
        }

        for(Integer key: indexMap.keySet()){
            if(indexMap.containsKey(target-key)){
                answer[0] = indexMap.get(key);
                answer[1] = indexMap.get(target-key);
                return answer;
            }
        }

        return answer;
    }
}

