import java.util.Arrays;

import com.sun.security.auth.NTDomainPrincipal;

public class Radix {
    public static int getMax(int[] arr) {
        int max=arr[0];
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>max) {
                max=arr[i];
            }
        }
        return max;
    }
    public static void divisionCountSort(int[] arr, int n, int exp, int radix) {
        int output[]=new int[n];
        int count[]=new int[radix];
        Arrays.fill(count,0);

        for(int i=0;i<n;i++) {
            count[(arr[i]/exp)%radix]++;
        }
        for(int i=1;i<radix;i++) {
            count[i]+=count[i-1];
        }
        for(int i=n-1;i>=0;i--) {
            output[count[ (arr[i]/exp)%radix] - 1] = arr[i];
            count[ (arr[i]/exp)%radix ]--;
        }
        for(int i=0;i<n;i++) {
            arr[i]=output[i];
        }
    }
    public static int[] divisionRadixSort(int[] arr, int radix) {
        int m=getMax(arr);
        int n=arr.length;
        for(int exp=1;m/exp>0;exp*=radix) {
            divisionCountSort(arr, n, exp, radix);
        }
        return arr;
    }
    public static void bitshiftCountSort(int[] arr, int n, int digit, int power) {
        int radix=(int)(Math.pow(2,power));
        int[] output=new int[n];
        int[] count=new int[radix];

        for(int i=0;i<n;i++) {
            count[(arr[i]>>digit*power)&(radix-1)]++;
        }
        for(int i=1;i<radix;i++) {
            count[i]+=count[i-1];
        }
        for(int i=n-1;i>=0;i--) {
            output[count[ (arr[i]>>digit*power)&(radix-1)] - 1] = arr[i];
            count[ (arr[i]>>digit*power)&(radix-1) ]--;
        }
        for(int i=0;i<n;i++) {
            arr[i]=output[i];
        }
    }
    public static int[] bitshiftRadixSort(int[] arr, int radix) {
        int max=getMax(arr);
        int num=0;
        int i=0;
        boolean powerOfTwo=false;
        while((int)Math.pow(2, num)<=radix) {
            if(radix==(int)Math.pow(2, num)) {
                powerOfTwo=true;
                break;
            }
            num++;
        }
        if(!powerOfTwo) {
            System.out.println("Not a power of 2!");
        }
        for(;max>0;max=max>>num) {
            bitshiftCountSort(arr, arr.length, i, num);
            i++;
        }
        return arr;
    }

    public static void main (String args[]) {
        int SIZE = 10000;

        //Test 1
        int[] arr1 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr1[i] = i;
        }
        Stopwatch sw1=new Stopwatch();
        divisionRadixSort(arr1, 10);
        double time1=sw1.elapsedTimeMillis();
        System.out.println("The old Radix sort for first array costs "+time1+" ms.");

        Stopwatch sw2=new Stopwatch();
        bitshiftRadixSort(arr1, 2);
        double time2=sw2.elapsedTimeMillis();
        System.out.println("The new Radix sort for first array costs "+time2+" ms.");
        System.out.println();

        // Test2
        int[] arr2 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr2[i] = i + 12345678;
        }
        Stopwatch sw3=new Stopwatch();
        divisionRadixSort(arr2, 10);
        double time3=sw3.elapsedTimeMillis();
        System.out.println("The old Radix sort for first array costs "+time3+" ms.");

        Stopwatch sw4=new Stopwatch();
        bitshiftRadixSort(arr2, 2);
        double time4=sw4.elapsedTimeMillis();
        System.out.println("The new Radix sort for first array costs "+time4+" ms.");
        System.out.println();

        // Test 3
        int[] arr3 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr3[i] = i;
        }
        Stopwatch sw5=new Stopwatch();
        divisionRadixSort(arr3, 10);
        double time5=sw5.elapsedTimeMillis();
        System.out.println("The old Radix sort for first array costs "+time5+" ms.");

        Stopwatch sw6=new Stopwatch();
        bitshiftRadixSort(arr3, 2);
        double time6=sw6.elapsedTimeMillis();
        System.out.println("The new Radix sort for first array costs "+time6+" ms.");
        System.out.println();

        // Test 4
        int[] arr4 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr4[i] = i + 345678;
        }
        Stopwatch sw7=new Stopwatch();
        divisionRadixSort(arr4, 10);
        double time7=sw7.elapsedTimeMillis();
        System.out.println("The old Radix sort for first array costs "+time7+" ms.");

        Stopwatch sw8=new Stopwatch();
        bitshiftRadixSort(arr4, 2);
        double time8=sw8.elapsedTimeMillis();
        System.out.println("The new Radix sort for first array costs "+time8+" ms.");
        System.out.println();

        // Test 5
        int[] arr5 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr5[i] = i;
        }
        Stopwatch sw9=new Stopwatch();
        divisionRadixSort(arr5, 10);
        double time9=sw9.elapsedTimeMillis();
        System.out.println("The old Radix sort for first array costs "+time9+" ms.");

        Stopwatch sw10=new Stopwatch();
        bitshiftRadixSort(arr5, 2);
        double time10=sw10.elapsedTimeMillis();
        System.out.println("The new Radix sort for first array costs "+time10+" ms.");
        System.out.println();

    }
}
