// Counting Sort
// cannot have negative or float
// Good for if array size is similar to biggest value in the array
// if not space complexity will be very high eg, array size = 10, biggest value = 1000000
// Time complexity O(N)

public class Main {
    public static void main(String[] args) {
        int[] intArray = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };

        countingSort(intArray, 1, 10);

        for(int i=0; i< intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }

    public static void countingSort(int[] input, int min, int max){
        int[] countArray = new int[max-min +1];

        for(int i=0; i<input.length; i++){
            countArray[input[i] - min]++;
        }

        int j = 0;
        for(int i = min; i <= max; i++){
            while(countArray[i-min] > 0){
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}