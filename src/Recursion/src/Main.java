// Recursion

public class Main {
    public static void main(String[] args) {
        // Shows factorial of 4
        System.out.println("iterativeFactorial");
        System.out.println(iterativeFactorial(4));
        System.out.println("recursiveFactorial");
        System.out.println(recursiveFactorial(4));
    }

    /*
        1! = 1 * 0! = 1
        2! = 2 * 1! = 2
        3! = 3 * 2! = 6
        4! = 4 * 3! = 24
    */

    public static int recursiveFactorial(int num){
        if(num == 0){
            return 1;
        }
        // i.e. 4! = 4 * 3!
        return num * recursiveFactorial(num -1);
    }

    public static int iterativeFactorial(int num){
        if(num == 0){
            return 1;
        }

        int factorial = 1;

        for(int i = 1; i<= num; i++){
            factorial *= i;
        }

        return factorial;
    }
}