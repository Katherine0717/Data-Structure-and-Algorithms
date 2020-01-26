public class Heap <E extends Comparable<E>> {

    public Heap(){

    }

    public void heapify(E[] array){
        int size = array.length;
        for(int i = size/2; i >= 0; i--){
            heapifyHelper(array,size, i);
        }
    }

    public E[] heapifyHelper(E[] array, int size, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < size && array[left].compareTo(array[largest])>0){
            largest = left;
        }
        if(right < size && array[right].compareTo(array[largest])>0){
            largest = right;
        }

        if(largest != i){
            E temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapifyHelper(array,size,largest);
        }

        return array;
    }

    public void heapSort(E[] array){
        heapify(array);
        int size = array.length;
        for(int i = 0; i < array.length; i++){
            removeMax(array, size--);
        }

    }

    public E[] removeMax(E[] array, int size){
        E Max = array[0];
        array[0] = array[size-1];
        array[size-1] = Max;

        size--;
        for(int i = size/2; i >= 0; i--){
            heapifyHelper(array, size, i);
        }
        return array;
    }

}
