package project1;

public class Array {
	protected int[][] aMove(int[][] array){
		for(int i = 0; i<4;i++) {
			for(int j=1; j<4;j++) {
				if(array[i][j]!=0) {
					for(int n = 0; n<=j; n++) {
						if(array[i][n]==0) {
							array[i][n] = array[i][j];
							array[i][j] = 0;
							break;
						}
					}
				}
			}
		}return array;
	}
				
	protected int[][] aAdd(int[][] array){
		for(int i = 0; i<4;i++) {
			for(int j=0; j<3;j++) {
				if(array[i][j]==array[i][j+1]) {
					array[i][j]=array[i][j] * 2;
					array[i][j+1]=0;
				}
				
			}
		}return array;
		
	}
	protected boolean aTest(int[][] array) {
		int y = 0;
		for(int i = 0; i<4;i++) {
			for (int j = 1; j < 4; j++) {
				if (array[i][j] != 0) {
					for (int n = 0; n <= j; n++) {
						if (array[i][n] == 0) {
							array[i][n] = array[i][j];
							array[i][j] = 0;
							y++;
							break;
						}
					}
				}
			}
		}
		System.out.println("y: "+y);
		if(y==0) {
			return true;
		}else {
			return false;
		}
	}
	
	protected int[][] dMove(int[][] array){
		for(int i = 0; i<4;i++) {
			for(int j=2; j>-1;j--) {
				if(array[i][j]!=0) {
					for(int k = 3; k>=j; k--) {
						if(array[i][k]==0) {
							array[i][k] = array[i][j];
							array[i][j] = 0;
							break;
						}
					}
				}
			}
		}return array;
	}
	protected int[][] dAdd(int[][] array){
		for(int i = 0; i<4;i++) {
			for(int j=3; j>0;j--) {
				if(array[i][j]==array[i][j-1]) {
						array[i][j]=array[i][j] * 2;
						array[i][j-1] = 0;
				}
				
			}
		}return array;
		
	}
	
	protected boolean dTest(int[][] array) {
		int y = 0;
		for(int i = 0; i<4;i++) {
			for (int j = 2; j > -1; j--) {
				if (array[i][j] != 0) {
					for (int k = 3; k >= j; k--) {
						if (array[i][k] == 0) {
							array[i][k] = array[i][j];
							array[i][j] = 0;
							y++;
							break;
						}
					}
				}
			}
		}
		System.out.println("y: "+y);
		if(y==0) {
			return true;
		}else {
			return false;
		}
	}
	
	protected int[][] sMove(int[][] array){
		for(int i = 3; i>=0;i--) {
			for(int j=0; j<4;j++) {
				if(array[i][j]!=0) { 
					for(int k = 3; k>=i; k--) {
						if(array[k][j]==0) {
							array[k][j] = array[i][j];
							array[i][j] = 0;
							break;
						}
					}
			
				}
			}
		}return array;
	}
	protected int[][] sAdd(int[][] array){
		for(int i = 3; i>0;i--) {
			for(int j=0; j<4;j++) {
				if(array[i][j]==array[i-1][j]) {
						array[i][j]=array[i][j] * 2;
						array[i-1][j] = 0;
				}
			}
		}return array;
	}
	
	protected boolean sTest(int[][] array) {
		int y = 0;
		for(int i = 3; i>=0;i--) {
			for (int j = 0; j < 4; j++) {
				if (array[i][j] != 0) {
					for (int k = 3; k >= i; k--) {
						if (array[k][j] == 0) {
							array[k][j] = array[i][j];
							array[i][j] = 0;
							y++;
							break;
						}
					}
				}
			}
		}
		System.out.println("y: "+y);

		if(y==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	protected int[][] wMove(int[][] array){
		for(int i = 1; i<4;i++) {
			for(int j=0; j<4;j++) {
				if(array[i][j]!=0) { 
					for(int k = 0; k<i; k++) {
						if(array[k][j]==0) {
							array[k][j] = array[i][j];
							array[i][j] = 0;
							break;
						}
					}	
				}	
			}
		}return array;
	}
			
	protected int[][] wAdd(int[][] array){
		for(int i = 0; i<3;i++) {
			for(int j=0; j<4;j++) {
				if(array[i][j]==array[i+1][j]) {
					array[i][j] = array[i][j]*2;
					array[i+1][j]=0;
					
				}
			}
			
		}return array;
	}
	protected boolean wTest(int[][] array) {
		int y = 0;
		for(int i = 1; i<4;i++){
			for (int j = 0; j < 4; j++) {
				if (array[i][j] != 0) {
					for (int k = 0; k < i; k++) {
						if (array[k][j] == 0) {
							array[k][j] = array[i][j];
							array[i][j] = 0;
							y++;
							break;
						}
					}
				}
			}
		}System.out.println("y: "+y);
		if(y==0) {
			return true;
		}else {
			return false;
		}
	}


	/*private  void print(int[][] array) { //this method prints the game.
		System.out.println("-\t-\t-\t-\t-\t-");
		int zero=0;
		for(int i=0; i!=4; i++) {
			System.out.print("|\t");
			for(int j=0; j<4;j++) {
				System.out.print(array[i][j]+"\t");

				if(array[i][j]==0){
					zero ++;
				}
			}


			System.out.print("|");
			System.out.println("");
		}
		System.out.println("-\t-\t-\t-\t-\t-");
		Move move = new Move();
		if(move.aTest(array)) {
			quit();
		}else if(move.aTest(array)) {
			quit();
		}else if(move.aTest(array)) {
			quit();
		}else if(move.aTest(array)) {
			quit();
		}else {
			getInput(array);
		}*/


	

}
