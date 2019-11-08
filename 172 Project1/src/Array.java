import java.util.Random;

public class Array {
    int[][] array = new int[4][4];
    private int random; // a random number
    protected int movable; // if any element is moved
    protected int addable; // if any two elements are added
    protected int zero; // how many 0 on the board
    private int counter; // how many valid move
    private int maximum = 0; // the maximum number on the board


    //constructor:
    protected Array() {
        int[][] array = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = 0;   //array start with all 0.
            }
        }
        addRandom();
        addRandom();
    }


    //setters:
    private void setRandom() {
        this.random = random2or4();
    }

    public void setMovable() {
        this.movable = 0;
    }

    public void setAddable() {
        this.addable = 0;
    }

    public void setZero() {
        this.zero = 0;
    }

    public void setArray(int[][] NewArray) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.array[i][j] = NewArray[i][j];   //array start with all 0.
            }
        }
    }

    //getters:
    public int[][] getArray() {
        return this.array;
    }

    protected int getZero(){ //get if there are empty places
        for(int i = 0; i<4;i++) {
            for (int j = 0; j < 4; j++) {
                if(array[i][j]==0){
                    zero++;
                    break;
                }
            }
        }
        return zero;
    }

    private int getMax(){
        for(int i = 0; i<4;i++) {
            for (int j = 0; j < 4; j++) {
                if(array[i][j]>maximum){
                    maximum = array[i][j];
                }
            }
        }
        return maximum;
    }

    protected void addRandom() {
        setRandom();
        Random Random = new Random();
        boolean b = true;
        while (b) {
            int x = Random.nextInt(4);
            int y = Random.nextInt(4);
            if (array[x][y] == 0) { // in case this random position already has a number;
                array[x][y] = random;
                b = false;
            }
        }
    }

    private int random2or4() {  // this method randomly pick 2 or 4 with 0.8 and 0.2 possibility
        Random Random = new Random();
        int[] listRandom = {2, 2, 2, 2, 2, 2, 2, 2, 4, 4};// create a list with 10 numbers, and the probability to choose 2 is 0.8.
        return listRandom[Random.nextInt(10)]; //randomly choose 2 or 4.
    }


    public boolean TestMove() { //test if it is a valid move.
        if (movable==0 && addable == 0) {
            return false; // didn't move at all
        }else {
            counter++;
            return true; // it moves
        }

    }

    protected int[][] aMove(){
        for(int i = 0; i<4;i++) {
            for(int j=1; j<4;j++) {
                if(array[i][j]!=0) {
                    for(int n = 0; n<=j; n++) {
                        if(array[i][n]==0) {
                            array[i][n] = array[i][j];
                            array[i][j] = 0;
                            movable++;
                            break;
                        }
                    }
                }
            }
        }
        return array;
    }

    protected int[][] aAdd(){
        for(int i = 0; i<4;i++) {
            for(int j=0; j<3;j++) {
                if(array[i][j]!=0 && array[i][j]==array[i][j+1]) {
                    array[i][j]=array[i][j] * 2;
                    array[i][j+1]=0;
                    addable++;
                }

            }
        }
        return array;
    }

    protected int[][] dMove(){
        for(int i = 0; i<4;i++) {
            for(int j=2; j>-1;j--) {
                if(array[i][j]!=0) {
                    for(int k = 3; k>=j; k--) {
                        if(array[i][k]==0) {
                            array[i][k] = array[i][j];
                            array[i][j] = 0;
                            movable++;
                            break;
                        }
                    }
                }
            }
        }
        return array;
    }

    protected int[][] dAdd(){
        for(int i = 0; i<4;i++) {
            for(int j=3; j>0;j--) {
                if(array[i][j]!=0 && array[i][j]==array[i][j-1]) {
                    array[i][j]=array[i][j] * 2;
                    array[i][j-1] = 0;
                    addable++;
                }

            }
        }
        return array;
    }


    protected int[][] sMove(){
        for(int i = 3; i>=0;i--) {
            for(int j=0; j<4;j++) {
                if(array[i][j]!=0) {
                    for(int k = 3; k>=i; k--) {
                        if(array[k][j]==0) {
                            array[k][j] = array[i][j];
                            array[i][j] = 0;
                            movable++;
                            break;
                        }
                    }

                }
            }
        }
        return array;
    }

    protected int[][] sAdd(){
        for(int i = 3; i>0;i--) {
            for(int j=0; j<4;j++) {
                if(array[i][j]!=0 && array[i][j]==array[i-1][j]) {
                    array[i][j]=array[i][j] * 2;
                    array[i-1][j] = 0;
                    addable++;
                }
            }

        }
        return array;
    }

    protected int[][] wMove(){
        for(int i = 1; i<4;i++) {
            for(int j=0; j<4;j++) {
                if(array[i][j]!=0) {
                    for(int k = 0; k<i; k++) {
                        if(array[k][j]==0) {
                            array[k][j] = array[i][j];
                            array[i][j] = 0;
                            movable++;
                            break;
                        }
                    }
                }
            }
        }
        return array;
    }

    protected int[][] wAdd(){
        for(int i = 0; i<3;i++) {
            for(int j=0; j<4;j++) {
                if(array[i][j]!=0 && array[i][j]==array[i+1][j]) {
                    array[i][j] = array[i][j]*2;
                    array[i+1][j]=0;
                    addable++;
                }
            }

        }
        return array;
    }

    protected boolean TestA(){  //test if left direction still can be moved
        setMovable();
        setAddable();
        aMove();
        aAdd();
        aMove();
        boolean b = TestMove();
        if(b){
            return true; //It still can be moved.
        }else{
            return false; // can't move anymore
        }
    }

    protected boolean TestD(){  //test if right direction still can be moved
        setMovable();
        setAddable();
        dMove();
        dAdd();
        dMove();
        boolean b = TestMove();
        if(b){
            return true; //It still can be moved.
        }else{
            return false; // can't move anymore
        }
    }

    protected boolean TestW(){
        setMovable();
        setAddable();
        wMove();
        wAdd();
        wMove();
        boolean b = TestMove();
        if(b){
            return true; //It still can be moved.
        }else{
            return false; // can't move anymore
        }
    }

    protected boolean TestS(){
        setMovable();
        setAddable();
        sMove();
        sAdd();
        sMove();
        boolean b = TestMove();
        if(b){
            return true; //It still can be moved.
        }else{
            return false; // can't move anymore
        }
    }

	protected void print() { //this method prints the game.
        System.out.println("-\t-\t-\t-\t-\t-");
        for (int i = 0; i != 4; i++) {
            System.out.print("|\t");
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("-\t-\t-\t-\t-\t-");
        System.out.println("");
        System.out.println("The maximum number on board is " + getMax() + ".");
        System.out.println("You have "+counter+" valid moves.");
    }
}
