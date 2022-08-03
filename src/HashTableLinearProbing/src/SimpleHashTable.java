public class SimpleHashTable {

    private StoredEmployee[] hashTable;

    public SimpleHashTable(){
        hashTable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)){
            int stopIndex = hashedKey;
            // get the next hashedkey
            if(hashedKey == hashTable.length - 1){
                hashedKey = 0;
            }else{
                hashedKey++;
            }

            while(occupied(hashedKey) && hashedKey != stopIndex){
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
        }

        if(occupied(hashedKey)){
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        }else{
            hashTable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }
        return hashTable[hashedKey].employee;
    }

    public Employee remove(String key){
        int hashedKey = findKey(key);
        if( hashedKey == -1){
            return null;
        }

        Employee employee = hashTable[hashedKey].employee;
        hashTable[hashedKey] = null;

        // Rehashing
        // when we add items, we look for first available slot
        // eg. add "Jones" (pos 5) then add "Smith" (pos 5 not available so put pos 6)
        // then we remove Jones (pos 5 becomes null)
        // when we try to get Smith (first hashedKey = 5) we will get null
        // So... when we remove, we need to do rehashing to rearrange the hashtable
        StoredEmployee[] oldHashTable = hashTable;
        hashTable = new StoredEmployee[oldHashTable.length];
        for(int i = 0; i < oldHashTable.length; i++){
            if(oldHashTable[i] != null){
                put(oldHashTable[i].key, oldHashTable[i].employee);
            }
        }
        return employee;
    }

    private int findKey(String key){
        int hashedKey = hashKey(key);
        if(hashTable[hashedKey] != null && hashTable[hashedKey].key.equals((key))){
            return hashedKey;
        }

        int stopIndex = hashedKey;
        // get the next hashedkey
        if (hashedKey == hashTable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex
                && hashTable[hashedKey] != null
                && !hashTable[hashedKey].key.equals(key)){
            hashedKey = (hashedKey + 1) % hashTable.length;
        }

        if(hashTable[hashedKey]!=null && hashTable[hashedKey].key.equals(key)){
            return hashedKey;
        }else{
            return -1;
        }
    }

    private int hashKey(String key){
        return key.length() % hashTable.length;
    }

    private boolean occupied(int index){
        return hashTable[index] != null;
    }

    public void printHashTable(){
        for(int i=0; i< hashTable.length; i++){
            if(hashTable[i] == null){
                System.out.println("Position " + i + ": " + "empty");
            }else{
                System.out.println("Position " + i + ": " + hashTable[i].employee);
            }

        }
    }
}
