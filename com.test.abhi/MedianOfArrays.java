import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> arrayList =  new ArrayList<>();
        for(int i=0; i<nums1.length; i++){
            arrayList.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
            arrayList.add(nums2[i]);
        }

        Collections.sort(arrayList);

        int mid = arrayList.size()/2;
        if(arrayList.size()%2 == 0){
            double retInt = (arrayList.get(mid-1) + arrayList.get(mid));
            
            return retInt/2;
        } else {
            return (arrayList.get(mid));
        }
    }
}
