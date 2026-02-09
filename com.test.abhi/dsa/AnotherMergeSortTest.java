package dsa;

public class AnotherMergeSortTest {

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 3, 6, 3};
        MergeSort mergeSort = new MergeSort(arr);
        mergeSort.sort();
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    
    static class MergeSort{
        int[] arr;

        public MergeSort(int[] arr2Sort){
            this.arr = arr2Sort;
        }

        public int[] sort(){
            int[] aux = new int[arr.length];

            return sort(this.arr, aux, 0, arr.length-1);
        }

        private int[] sort(int[] arr, int[] aux, int lo, int hi){
            if(hi<=lo) return arr;

            int mid = lo + (hi-lo)/2;

            sort(arr, aux, lo, mid);
            sort(arr, aux, mid+1, hi);
            merge(arr, aux, lo, mid, hi);
            return arr;
        }

        private void merge(int[] arr, int[] aux, int lo, int mid, int hi){
            for(int i=0; i<=hi; i++){
                aux[i] = arr[i];
            }

            int k = lo;
            int i = lo;
            int j = mid+1;

            while(k<=hi) {
                if(i>mid) arr[k] = aux[j++];
                else if(j>hi) arr[k] = aux[i++];
                else {
                   if(aux[i] < aux[j]){
                    arr[k] = aux[i++];
                   } else {
                    arr[k] = aux[j++];
                   }
                }
                k++;
            }
        }
    }
}
