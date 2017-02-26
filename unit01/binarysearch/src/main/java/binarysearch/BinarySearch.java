package binarysearch;

public class BinarySearch {
    private static int start = 0;
    private static int end = 0;
    private static int mid = 0;
    private static int index = -1;

    public static int binarySearch(int[] data, int value){

        index = -1;
        start = 0;

        if(data != null) {
            end = data.length;
            internalSearch(data, value);
        }
        return index;
    }

    private static void internalSearch(int[] data, int value){
        while(start < end){
            mid = (start + end) / 2;
            if (data[mid] == value){
                index = mid;
                break;
            }
            else if(data[mid] < value){
                start = mid + 1;
            }
            else{
                end = mid;
            }
            internalSearch(data, value);
        }
    }
}
