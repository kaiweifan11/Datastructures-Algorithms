// Radix Sort
// compares each digit of the elements
// i.e. compare 1's position and arrange
// then compare 10's position and arrange
// then compare 100's position and arrange
// then compare 1000's position and arrange

public class Main {
    public static void main(String[] args) {
        int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };

        radixSort(radixArray, 10, 4);

        for(int i=0; i< radixArray.length; i++){
            System.out.println(radixArray[i]);
        }
    }

    public static void radixSort(int[] input, int radix, int width){
        for (int i=0; i<width; i++){
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix){
        int numItems = input.length;
        int[] countArray = new int[radix];
        // for every value in input
        for(int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }

        // make the countingSort a stable sort
        for(int j = 1; j<radix; j++){
            countArray[j] += countArray[j-1];
        }

        int[] temp = new int[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--){
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++){
            input[tempIndex] = temp[tempIndex];
        }
    }

    public static int getDigit(int position, int value, int radix){
        // cast Math.pow(10, position) to int
        // returns the remainder
        return value / (int) Math.pow(radix, position) % radix;
    }

}