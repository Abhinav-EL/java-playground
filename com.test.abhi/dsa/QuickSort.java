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
        int k = partition(a, lo, hi);
        partition(a, lo, k-1);
        partition(a, k+1, hi);
    }

    static int partition(int[] a, int lo, int hi){
        int k = lo;
        int i = k;
        int j = hi+1;

        while(true){
            while(++i<hi){
                if(a[i]>a[k]) break;
            }
            while(--j>lo && a[j]>a[k]){
                if(a[j]<a[k]) break;
            }

            if(i>=j){
                break;
            }
            
            swap(a, i, j);
            
        }
        swap(a, k, j);
        return j;
    }

    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
