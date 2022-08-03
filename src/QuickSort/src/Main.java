// Quick Sort
// use pivot to check if elements are smaller or bigger than the pivot

public class Main {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        quickSort(intArray, 0, intArray.length);

        for(int i=0; i< intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }

    public static void quickSort(int[] input, int start, int end){
        if(end - start < 2){
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    public static int partition(int[] input, int start, int end){
        // This is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        while(i < j){
            // Empty loop so that we find a input[j] smaller than pivot
            while(i<j && input[--j] >= pivot);
            if(i < j){
                // put j element to position i
                input[i] = input[j];
            }
            // Empty loop so that we find a input[i] greater than pivot
            while(i<j && input[++i]<= pivot);
            if(i < j){
                // put i element to position j
                input[j] = input[i];
            }
        }

        input[j] = pivot;
        // return j as the pivotIndex
        return j;
    }
}