public class HeapTest {
    public static void main(String[] args) {
        Heap h = new Heap<Integer>();

        Integer[] arr = {5, 18, 3, 25, 27, 45, 97, 88, 26, 16, 49, 67};
        h.heapify(arr);
        for(int temp:arr){
            System.out.print(temp + " ");
        }
        System.out.println();

        Integer[] arr2 = {15,99,3,77,27,45,7,88,26,5};
        h.heapSort(arr2);
        for(int temp:arr2){
            System.out.print(temp + " ");
        }
        System.out.println();
    }
}
