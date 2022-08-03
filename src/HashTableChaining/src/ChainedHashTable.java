import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {

    private LinkedList<StoredEmployee>[] hashTable;

    public ChainedHashTable(){
        hashTable = new LinkedList[10];
        for(int i = 0; i< hashTable.length; i++){
            hashTable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        hashTable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while(iterator.hasNext()){
            employee = iterator.next();
            if(employee.key.equals(key)){
                return employee.employee;
            }
        }

        return null;
    }

    public Employee remove(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = 0;
        while(iterator.hasNext()){
            employee = iterator.next();
            if(employee.key.equals(key)){
                break;
            }else{
                index++;
            }
        }

        System.out.println(hashTable[hashedKey]);
        System.out.println(index);

        if(employee == null){
            return null;
        }else{
            hashTable[hashedKey].remove(index);
            return employee.employee;
        }
    }

    private int hashKey(String key){
        //return key.length() % hashTable.length;
        return Math.abs(key.hashCode() % hashTable.length);
    }

    public void printHashTable(){
        for(int i=0; i< hashTable.length; i++){
            if(hashTable[i].isEmpty()){
                System.out.println("Position " + i + ": " + "empty");
            }else{
                System.out.print("Position " + i + ": ");
                ListIterator<StoredEmployee> iterator = hashTable[i].listIterator();
                while(iterator.hasNext()){
                    System.out.print(iterator.next().employee);
                    System.out.print("->");
                }
                System.out.println("null");
            }

        }
    }
}
