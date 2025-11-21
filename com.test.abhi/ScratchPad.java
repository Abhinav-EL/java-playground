import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * No specific question implementation.
 */
public class ScratchPad {
    
    public static void main(String[] args) {
        //MaxRainWater();
        //StringPerumtation();
        //slidingWindow();
        ListDiff();
    }

    /**
     * Does case matter? Example of permutation? Do we consider substrings? 
     * Is there a limit to the size? What characters are supported?
     * Option -- Count the chars for first and then compare then to second -- O(n)
     */
    private static void StringPerumtation(){
        String one = "ABC";
        String two = "CBA";
        
        char[] chr1 = one.toCharArray();
        Arrays.sort(chr1);

        char[] chr2 = two.toCharArray();
        Arrays.sort(chr2);

        System.out.println(Arrays.compare(chr1, chr2));
    }

    private static void slidingWindow(){
        int[] arr = {10, 3, 6, 20};

        int[] arr2 = new int[arr.length];
        arr2[0] = arr[0];

        for(int i=1; i < arr.length; i++){
            arr2[i] = arr2[i-1] + arr[i];
        }

        for(int i=0; i < arr2.length; i++){
            System.out.println(arr2[i]);
        }
        
    }

    private static void ListDiff(){
        List<Integer> list = new LinkedList<>();
        list.add(7);
        list.add(3);
        list.add(6);
        list.add(3);
        list.add(4);

        List<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(4);

        list.removeAll(list2);

        for(Integer val : list){
            System.out.println(val);
        }
    }

    /**
     * What's the datatype? Length of the LinkedList?
     * What do return?
     */
    private static void removeDuplicates(){
        
    }

    private static void MaxRainWater(){
        int arr[] = {3, 0, 1, 0, 4, 0, 2};
        
        int currentMaxIndex = 0;
        int maxVal = 0;

        for(int i=0; i< arr.length; i++){
            if(arr[i]>arr[currentMaxIndex]){
                maxVal = (arr[currentMaxIndex] * (i+1))-1;
                currentMaxIndex = i;
            }

            System.out.println(maxVal);
        }
    }
}
