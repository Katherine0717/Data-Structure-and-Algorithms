package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab3_Task2 {
	
	//Task 2:
	public static int[][] runningSum2DArray(int[][] array, int dir) {
		if(dir==1) {
			for(int i = 0; i<4; i++) {
				for(int j = 0; j<5; j++) {
					for(int k = j+1; k<4; k++) {
						array[i][j]=array[i][k]+array[i][j];
					}
				}
			}return array;
		}else if(dir==2){
			for(int i = 0; i<4; i++) {
				for(int j = 3; j>-1; j--) {
					for(int k = 0; k<j; k++) {
						array[i][j]=array[i][k]+array[i][j];
					}
				}
			}
			return array;
		}else if(dir==3) {
			for(int i = 0; i<4; i++) {
				for(int j = 0; j<4; j++) {
					for(int k = i+1; k<4; k++) {
						array[i][j]=array[k][j]+array[i][j];
					}
				}
			}return array;
		}else {
			for(int i = 3; i>-1; i--) {
				for(int j = 0; j<4; j++) {
					for(int k = 0; k<i; k++) {
						array[i][j]=array[k][j]+array[i][j];

					}
				}
			}return array;
		}
}
	public static ArrayList<ArrayList<Integer>> runningSum2DArrayList(ArrayList<ArrayList<Integer>>list, int dir) {
		if(dir==1) {
			for(int i = 0; i<4; i++) {
				for(int j = 0; j<4; j++) {
					for(int k = j+1; k<4; k++) {
						list.get(i).set(j, list.get(i).get(j)+list.get(i).get(k));
					}
				}
			}
			return list;
		}else if(dir==2){
			for(int i = 0; i<4; i++) {
				for(int j = 3; j>-1; j--) {
					for(int k = 0; k<j; k++) {
						list.get(i).set(j, list.get(i).get(k)+list.get(i).get(j));

					}
				}
			}
			return list;
		}else if(dir==3) {
			for(int i = 0; i<4; i++) {
				for(int j = 0; j<4; j++) {
					for(int k = i+1; k<4; k++) {
						list.get(i).set(j, list.get(k).get(j)+list.get(i).get(j));

					}
				}
			}return list;
		}else {
			for(int i = 3; i>-1; i--) {
				for(int j = 0; j<4; j++) {
					for(int k = 0; k<i; k++) {
						list.get(i).set(j, list.get(k).get(j)+list.get(i).get(j));

					}
				}
			}return list;
		}
	}
	
	
	
	public static void main(String[] args) {
		
		//Same input method with task 1:
		
		System.out.println("This class prints running sum.");
		Scanner scan = new Scanner(System.in);
		System.out.println("Input:");
		String[] input = scan.nextLine().split(";|\\s");
		int k = 0;
		int[][] array = new int[4][4];
		for(int i=0;i < 4; i++) {
			for(int j=0; j<4; j++) {
				array[i][j] = Integer.parseInt(input[k]);
				k++;

			}
			
		}
		ArrayList<ArrayList<Integer>> array2 = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i < 4; i++) {
			ArrayList<Integer> input2 = new ArrayList<Integer>();
			for(int j=0; j<4; j++) {
				input2.add(array[i][j]);
			}
			array2.add(input2);
		}

	
		
		//Task 2 
		// 2D List
		System.out.println(" ");
		System.out.println("Enter 1,2,3,4 for left,right,up,down.");
		int dir = scan.nextInt();
		System.out.println("Print with 2D integer array:");
		runningSum2DArray(array,dir);
		Lab3_Task1.print2Darray(array);
		System.out.println(" ");


		
		//Task 2
		// 2D ArrayList
		runningSum2DArrayList(array2,dir);
		System.out.println("Print with 2D ArrayList: ");
		Lab3_Task1.print2DList(array2);

		scan.close();
	}

}
