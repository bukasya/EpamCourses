package mergesortup;

public class MergeSortUp {

    private static int[] aux;

    public static void sort(int[] src){

        int n = src.length;
        aux = new int[n];

        for(int size = 1; size < n; size += size){
            for(int lo = 0; lo < n - size; lo += size+size){ //size - size of subarray
                merge(src, lo, lo+size-1, Math.min(lo+size+size-1, n-1)); //lo - index in subarray
            }
        }
    }

    private static void merge(int[] src, int lo, int mid, int hi){

        int i = lo;
        int j = mid+1;

        for(int k = lo; k <= hi; k++){
            aux[k] = src[k];
        }

        for(int k = lo; k <= hi; k++){
            if(i > mid)
                src[k] = aux[j++];
            else if(j > hi)
                src[k] = aux[i++];
            else if(aux[i] < aux[j])
                src[k] = aux[i++];
            else
                src[k] = aux[j++];
        }
    }
}
