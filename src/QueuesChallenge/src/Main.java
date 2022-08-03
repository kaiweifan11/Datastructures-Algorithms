import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        // add your codes here
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        String lowerCase = string.toLowerCase();

        for(int i = 0; i<lowerCase.length(); i++){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c<= 'z'){
                queue.addLast(c);
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            if(!stack.pop().equals(queue.removeFirst())){
                return false;
            }
        }

        return true;
        /*ArrayList queue = new ArrayList();
        StringBuilder stringNoPunctuation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();

        for(int i = 0; i<string.length(); i++){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c<= 'z'){
                stringNoPunctuation.append(c);
            }

        }

        for(int i = string.length()-1; i>=0; i--){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c<= 'z'){
                queue.add(c);
            }
        }

        //System.out.println("queue.size(): " + queue.size());
        int queueSize = queue.size();
        StringBuilder reverseString = new StringBuilder(queue.size());
        for(int i = 0; i<queueSize; i++){
            reverseString.append(queue.remove(0));
        }
        System.out.println("stringNoPunctuation: " + stringNoPunctuation);
        System.out.println("reverseString: " + reverseString);

        return reverseString.toString().equals(stringNoPunctuation.toString());*/
    }
}
