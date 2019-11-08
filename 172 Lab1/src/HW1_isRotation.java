package homework;

import java.util.Scanner;

public class HW1_isRotation {
	public static void main(String []args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string:");
		String x = scanner.next();
		System.out.println("Enter another string:");
		String y = scanner.next();
		scanner.close();
		isRotation(x, y);
	}
	
	public static void isRotation(String x, String y) {
		if(x.length()==y.length()) {
			for(int i = 1; i != x.length(); i += 1) {
				String str1 = x.substring(i, x.length());
				String str2 = x.substring(0,i);
				String newStr = str1 + str2;

				if(newStr.equals(y)) {
					System.out.println(x+" is a rotation of "+ y);
					return;
				}else {
					continue;
				}
			}
			System.out.println(x+" is not a rotation of "+ y);
		}else {
			System.out.println(x+" is not a rotation of "+ y);

		}
	}
}
