package hw2;

public class HW2 {
	
	//static printArrayNonGen() method:
	
	public static void printArrayNonGen(Object[] x) {
		System.out.print("{");
		for(Object temp:x) {
			System.out.print(temp+" ");
		}
		System.out.println("}");
	}
	
	
	//static printArray() using method overloading
	
	public static void printArray(Integer[] a) {
		System.out.print("{");
		for(Integer temp:a) {
			System.out.print(temp+" ");
		}
		System.out.println("}");
	}
	
	public static void printArray(Double[] b) {
		System.out.print("{");
		for(Double temp:b) {
			System.out.print(temp+" ");
		}
		System.out.println("}");
	}
	
	public static void printArray(Character[] c) {
		System.out.print("{");
		for(Character temp:c) {
			System.out.print(temp+" ");
		}
		System.out.println("}");
	}
	
	public static void printArray(String[] d) {
		System.out.print("{");
		for(String temp:d) {
			System.out.print(temp+" ");
		}
		System.out.println("}");
	}
	
	
	//single static method printArrayGen() that uses the generic
	
	public static <T> void printArrayGen(T[] y) {
		System.out.print("{");
		for(T temp:y) {
			System.out.print(temp+" ");
		}
		System.out.println("}");

	}
	
	//non-generic techniques, implementing a static method getMax()

	public static Comparable getMax(Comparable [] anArray) {
		// This is not a type save version.
		Comparable Max = anArray[0];
		for(int i=1; i!=anArray.length;i++) {
			int val = Max.compareTo(anArray[i]);
			if(val<=0) {
				Max = anArray[i];
			}else {
				continue;
			}
		}
		return Max;
	}
	
	
	//generic techniques, implementing a type safe version of 
	//the method named getMaxGen()
	
	public static <T extends Comparable <T>> T getMaxGen(T[] anArray) {
		T Max = anArray[0];
		for(int i=1; i!=anArray.length;i++) {
			int val = Max.compareTo(anArray[i]);
			if(val<=0) {
				Max = anArray[i];
			}else {
				continue;
			}
		}
		return Max;
	}
	
	public static void main(String [] args) {
		Integer [] intArray = {1, 2, 3, 4, 5 };
		Double [] doubArray = {1.1, 2.2, 3.3, 4.4};
		Character [] charArray = {'H','E','L', 'L', 'O' };
		String [] strArray = {"once", "upon", "a", "time" };
		printArrayNonGen(intArray);
		printArrayNonGen(doubArray);
		printArrayNonGen(charArray);
		printArrayNonGen(strArray);
		printArray(intArray);
		printArray(doubArray);
		printArray(charArray);
		printArray(strArray);
		printArrayGen(intArray);
		printArrayGen(doubArray);
		printArrayGen(charArray);
		printArrayGen(strArray);
		System.out.println(getMax(intArray));
		System.out.println(getMax(doubArray));
		System.out.println(getMax(charArray));
		System.out.println(getMax(strArray));
		System.out.println(getMaxGen(intArray));
		System.out.println(getMaxGen(doubArray));
		System.out.println(getMaxGen(charArray));
		System.out.println(getMaxGen(strArray));
	}

}
