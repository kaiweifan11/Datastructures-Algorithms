import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Min Heap (smallest first)
        //PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

//        System.out.println(pq.peek());
//        System.out.println(pq.remove());
//        System.out.println(pq.peek());

        // poll is the same as remove
        // difference is remove can take a value to remove
//        System.out.println(pq.poll());
//        System.out.println(pq.peek());
        //System.out.println(pq.remove(54));

        Object[] ints = pq.toArray();
        for(Object num: ints){
            System.out.println(num);
        }

//        System.out.println(pq.peek());
//
//        pq.add(-1);
//        System.out.println(pq.peek());
    }
}