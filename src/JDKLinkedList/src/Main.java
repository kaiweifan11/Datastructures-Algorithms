import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 77);

        LinkedList<Employee> list = new LinkedList<>();
        // Add to front
        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        Iterator iter = list.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println(" null ");
//        for(Employee employee: list){
//            System.out.println(employee);
//        }

        // adds to end of list
        list.add(billEnd);
        iter = list.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println(" null ");

        // remove first of list
        list.removeFirst();
        iter = list.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println(" null ");

        // remove last of list
        list.removeLast();
        iter = list.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println(" null ");

        // remove first of list
        list.remove();
        iter = list.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println(" null ");

    }
}