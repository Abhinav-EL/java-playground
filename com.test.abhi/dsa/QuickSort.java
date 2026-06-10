package dsa;

public class QuickSort {

   public static void main(String[] args){
    int[] sortArr = {10, 5, 3, 12, 50};
    sort(sortArr, 0, sortArr.length-1);
    for(int val: sortArr){
        System.out.println(val);
    }
   }
    
    static void sort(int[] a, int lo, int hi){
        if(hi<=lo) return;
        int k = partition(a, lo, hi);
        sort(a, lo, k-1);
        sort(a, k+1, hi);
    }

    static int partition(int[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;

        while(true){
            while(a[++i]<a[lo]){
                if(i ==hi) break;
            }
            while(a[--j]>a[lo]){
                if(j==lo) break;
            }

            if(i>=j){
                break;
            }
            
            swap(a, i, j);
            
        }
        swap(a, lo, j);
        return j;
    }

    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
