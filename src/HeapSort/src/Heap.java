public class Heap {
    private int[] heap;
    // size is the next available position in array
    private int size;

    public Heap(int capacity){
        heap = new int[capacity];
    }

    public void sort(){
        int lastHeapIndex = size - 1;

        // move the first element to the last and
        // call the fixHeapBelow function
        // repeat
        for(int i = 0; i< lastHeapIndex; i++){
            int tmp = heap[0];
            heap[0] = heap[lastHeapIndex - 1];
            heap[lastHeapIndex - 1] = tmp;

            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

    public void insert(int value){
        if(isFull()){
            throw new IndexOutOfBoundsException("Heap is Full");
        }

        heap[size++] = value;
        fixHeapAbove(size);
    }

    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }

        return heap[0];
    }

    public int delete(int index){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Heap is Empty");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];

        // always replace the deleted node with the last node
        heap[index] = heap[size - 1];

        if(index == 0 || heap[index] < heap[parent]){
            fixHeapBelow(index, size - 1);
        }else{
            fixHeapAbove(index);
        }

        size--;
        return deletedValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex){
        int childToSwap;

        while(index <= lastHeapIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if(leftChild <= lastHeapIndex){
                if(rightChild > lastHeapIndex){
                    childToSwap = leftChild;
                }else{
                    // if value of left child > right child swap left
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if(heap[index] < heap[childToSwap]){
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                }else{
                    break;
                }

                index = childToSwap;
            }
            else {
                break;
            }
        }
    }

    private void fixHeapAbove(int index){
        int newValue = heap[index];
        while(index > 0 && newValue > heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    public void printHeap(){
        for(int i=0; i<size; i++){
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public boolean isFull(){
        return size == heap.length;
    }

    public int getParent(int index){
        return (index - 1) / 2;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getChild(int index, boolean left){
        return 2 * index + (left ? 1 : 2);
    }
}
