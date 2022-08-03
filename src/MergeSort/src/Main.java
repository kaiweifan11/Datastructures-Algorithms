// Merge Sort
// Split the array into 2 sub arrays left and right
// repeat splitting sub arrays until you get all 1 element arrays
// then merge them back

public class Main {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        mergeSort(intArray, 0, intArray.length);

        for(int i=0; i< intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] input, int start, int end){
        if(end-start < 2){
            return;
        }

        int mid = (start + end) /2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end){
        // if the first element in the left is smaller than
        // the last element in the right,
        // then it is sorted
        if(input[mid - 1] <= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        // while left array is before mid and right array is before end
        while(i < mid && j < end){
            // if input[i] smaller than input[j], then add it into temp array
            temp[tempIndex++] = input[i] <= input[j]? input[i++] : input[j++];
        }

        // copy remaining elements
        // if mid - i <1 it will not copy
        System.arraycopy(input, i, input,start + tempIndex, mid - i);

        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}