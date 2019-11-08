/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms. 
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class Sorting {
    /**
     *
     * Sorts the numbers present in the file based on the algorithm provided.
     * 0 = Arrays.sort() (Java Default)
     * 1 = Bubble Sort
     * 2 = Selection Sort 
     * 3 = Insertion Sort 
     * 4 = Mergesort
     * 5 = Quicksort
     *
//   * @param args the command-line arguments
     */

    public static int[] ArraySort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static int[] BubbleSort(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(arr[j]<arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }

    public static int[] SelectionSort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++) {
            int min=i;
            for(int j=i+1;j<n;j++) {
                if(arr[j]<arr[min]) {
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }

    public static int[] InsertionSort(int[] arr) {
        int n=arr.length;
        for(int i=1;i<n;i++) {
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key) {
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
        return arr;
    }

    public static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int [n1];
        int R[] = new int [n2];
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static int[] MergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            MergeSort(arr, l, m);
            MergeSort(arr , m+1, r);
            merge(arr, l, m, r);
        }
        return arr;
    }
    public static int partition(int[] arr,int low,int high)
    {
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }

    public static int[] QuickSort(int[] arr,int low,int high)//Quick Sort, pivot as the last element
    {
        if(low<high)
        {
            int pos=partition(arr, low, high);
            QuickSort(arr, low, pos-1);
            QuickSort(arr, pos+1, high);
        }
        return arr;
    }
    public static void WriteToFile(int[] arr,String fileName){
        try {
            FileWriter fWriter=new FileWriter(fileName);
            for(int i=0;i<arr.length;i++) {
                fWriter.write(arr[i]+"\n");
            }
            fWriter.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void Sort(int SortMethod,int[] arr,String fileName){
        if(SortMethod==0) {
            arr=ArraySort(arr);
        }
        else if(SortMethod==1) {
            arr=BubbleSort(arr);
        }
        else if(SortMethod==2) {
            arr=SelectionSort(arr);
        }
        else if(SortMethod==3) {
            arr=InsertionSort(arr);
        }
        else if(SortMethod==4) {
            arr=MergeSort(arr,0,arr.length-1);
        }
        else if(SortMethod==5) {
            arr=QuickSort(arr,0,arr.length-1);
        }
        WriteToFile(arr, fileName);
    }

    public static void main(String[] args)  {
        In in = new In(args[0]);
        // Storing file input in an array
        int[] a = in.readAllInts();

        int[] b=new int[a.length];
        for(int i=0;i<a.length;i++) {
            b[i]=a[i];
        }
        Arrays.sort(b);

        int[] c=new int[b.length];
        int j=b.length-1;
        for(int i=0;i<b.length;i++) {
            c[i]=b[j];
            j--;
        }

        int[] d=new int[c.length];
        Random r=new Random();
        int swap=(int)(0.1*c.length);
        int random= r.nextInt(c.length);
        int random1=r.nextInt(c.length);
        while(random1==random) {
            random1=r.nextInt(c.length);
        }
        int i=0;
        while(i<swap) {
            int temp=c[random];
            c[random]=c[random1];
            c[random1]=temp;
            i++;
        }
        for(int k=0;k<c.length;k++) {
            d[k]=c[k];
        }
        int SortMethod=Integer.parseInt(args[1]);


        // TODO: Generate 3 other arrays, b, c, d where
        // b contains sorted integers from a (You can use Java Arrays.sort() method)
        // c contains all integers stored in reverse order 
        // (you can have your own O(n) solution to get c from b
        // d contains almost sorted array 
        //(You can copy b to a and then perform (0.1 * d.length)  many swaps to acheive this.   

        //TODO: 
        // Read the second argument and based on input select the sorting algorithm
        //  * 0 = Arrays.sort() (Java Default)
        //  * 1 = Bubble Sort
        //  * 2 = Selection Sort 
        //  * 3 = Insertion Sort 
        //  * 4 = Mergesort
        //  * 5 = Quicksort
        //  Perform sorting on a,b,c,d. Pring runtime for each case along with timestamp and record those. 
        // For runtime and priting, you can use the same code from Lab 4 as follows:




        // TODO: For each array, a, b, c, d:
        Stopwatch timer = new Stopwatch();

        // TODO: Perform Sorting and store the result in an  array
        double time = timer.elapsedTimeMillis();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        //TODO: Replace with your own netid
        String netID = "nxiong";

        //TODO: Replace with the algorithm used
        String algorithmUsed = "";
        if(SortMethod==0) {
            algorithmUsed="Arrays.sort()";
        }
        else if(SortMethod==1) {
            algorithmUsed="Bubble Sort";
        }
        else if(SortMethod==2) {
            algorithmUsed="Selection Sort";
        }
        else if(SortMethod==3) {
            algorithmUsed="Insertion Sort";
        }
        else if(SortMethod==4) {
            algorithmUsed="Mergesort";
        }
        else if(SortMethod==5) {
            algorithmUsed="Quicksort";
        }

        //TODO: Replace with the  array used
        Stopwatch timera = new Stopwatch();
        Sort(SortMethod,a,"a.txt");
        double timea = timera.elapsedTimeMillis();
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "a", timea, timeStamp, netID, args[0]);
        Stopwatch timerb = new Stopwatch();
        Sort(SortMethod,b,"b.txt");
        double timeb = timerb.elapsedTimeMillis();
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "b", timeb, timeStamp, netID, args[0]);
        Stopwatch timerc = new Stopwatch();
        Sort(SortMethod,c,"c.txt");
        double timec = timerc.elapsedTimeMillis();
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "c", timec, timeStamp, netID, args[0]);
        Stopwatch timerd = new Stopwatch();
        Sort(SortMethod,d,"d.txt");
        double timed = timerd.elapsedTimeMillis();
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "d", timed, timeStamp, netID, args[0]);
        // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)

    }
} 