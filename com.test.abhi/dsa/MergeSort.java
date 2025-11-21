package dsa;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 3, 6, 3};
        int[] aux = new int[arr.length];
        
        sort(arr, aux, 0, arr.length-1);
        for(int k=0; k< arr.length; k++){
            System.out.println(arr[k]);
        }
    }

    private static void sort(int[] arr, int[] aux, int lo, int hi){
        if(hi<=lo) return;

        int mid = lo + (hi-lo)/2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid+1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    private static void merge(int[] arr, int[] aux, int lo, int mid, int hi){
        int i = lo;
        int j = mid+1;

        for(int k=lo; k<= hi; k++){
            aux[k] = arr[k];
        }

        for(int k=lo; k<= hi; k++){
            if(i>mid) arr[k] = aux[j++];
            else if(j>hi) arr[k] = aux[i++];
            else if (aux[i]> aux[j]) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }
}
