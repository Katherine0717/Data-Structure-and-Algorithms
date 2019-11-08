package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab3_Task1 {
	
	//Task 1:
	public static void print2Darray(int[][] array) {
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<4; j++) {
				System.out.print(array[i][j]+"\t");
			}
			System.out.println("");
		}
		
	}
	
	
	public static void print2DList(ArrayList<ArrayList<Integer>> list) {
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<4; j++) {
				System.out.print(list.get(i).get(j)+"\t");
			}
			System.out.println("");
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("This class prints a formatted 4x4 two dimensional integer array.");
		Scanner scan = new Scanner(System.in);
		System.out.println("Input:");
		String[] input = scan.nextLine().split(";|\\s");
		
		//Task 1:
		// 2D List
		int k = 0;
		int[][] array = new int[4][4];
		for(int i=0;i < 4; i++) {
			for(int j=0; j<4; j++) {
				array[i][j] = Integer.parseInt(input[k]);
				k++;

			}
			
		}
		System.out.println("Print with 2D integer array:");
		print2Darray(array);
		System.out.println(" ");
		
		
		//Task 1:
		// 2D ArrayList
		ArrayList<ArrayList<Integer>> array2 = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i < 4; i++) {
			ArrayList<Integer> input2 = new ArrayList<Integer>();
			for(int j=0; j<4; j++) {
				input2.add(array[i][j]);
			}
			array2.add(input2);
		}
		System.out.println("Print with 2D ArrayList: ");
		print2DList(array2);


		scan.close();
	}

}
