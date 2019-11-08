package lab3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Lab3_Task3 {
	public static void main(String[] args) {
		System.out.println("This class tests ArrayList can be iterated in different ways.");
		
		//get input
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a list of number:");
		String[] part = scan.nextLine().split("\\s+");
		
		
		//get a list of input numbers:
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i=0; i<part.length;i++) {
			array.add(Integer.parseInt(part[i]));
		}
		
		//four way to iterate.
		printArrayBasicLoop(array);
		printArrayListEnhancedLoop(array);
		printArrayListForLoopListIterator(array);
		printArrayListWhileLoopListIterator(array);
		scan.close();
	}
	
	
	public static void printArrayBasicLoop(ArrayList<Integer> al) {
		for(int i = 0; i < al.size();i++) {
			System.out.println(al.get(i));
		}
			
	}
	public static void printArrayListEnhancedLoop(ArrayList<Integer> al) {
		for(int temp:al) {
			System.out.println(temp);
		}
		
	}
	public static void printArrayListForLoopListIterator(ArrayList<Integer> al) {
		for(Iterator<Integer> iterator = al.iterator();iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		
	}
	public static void printArrayListWhileLoopListIterator(ArrayList<Integer> al) {
		Iterator<Integer> iterator = al.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	

}
