// Using library functions to do sorting
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        // uses pivotquicksort, can use for normal arrays
        Arrays.sort(intArray);
        // uses threads, better for bigger arrays
        Arrays.parallelSort(intArray);

        for(int i = 0; i< intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }
}