package homework;

import java.util.Arrays;
import java.util.Scanner;

public class HW1_isAnagram {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string:");
		String x = scanner.next();
		System.out.println("Enter another string:");
		String y = scanner.next();
		scanner.close();
		isAnagram(x,y);
		
	}
		
	public static void isAnagram(String x,String y) {
		char[] charX = x.toCharArray();
		char[] charY = y.toCharArray();
		
		Arrays.sort(charX);
		Arrays.sort(charY);

		if(charX.length==charY.length) {
			for(int i = 0; i!=charX.length; i+=1) {
				if(charX[i]==charY[i]) {
					continue;
				}else {
					System.out.println("They are not anagrams.");
					return;
				}
			}
			System.out.println("They are anagrams.");

		}else {
			System.out.println("They are not anagrams.");

		}

	}

}
