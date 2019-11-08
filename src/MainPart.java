import java.util.*;

public class MainPart {
    public static void getInput(Array array) { //this method gets input from the user.
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Enter which position you want to move(q to quit, and r to restart):");
        String input = scan.next();
        boolean booleans = true;
        while (booleans) {
            if (input.equals("q")) {
                booleans = false;
                quit(array);
            } else if (input.equals("r")) {
                booleans = false;
                restart(array);
            } else if (input.equals("a") || input.equals("d") || input.equals("w") || input.equals("s")) {
                move(input, array);
                booleans = false;
            } else {
                input = scan.next();  //if the user inputs something outside "q/r/a/d/w/s", nothing will happen.
                //Just input again.
            }
        }
        scan.close();
    }

    public static void move(String input, Array array) {  //this method create a move object and move numbers.
        //Array move = new Array();
        array.setMovable();
        array.setAddable();
        array.setZero();
        if (input.equals("a")) {
            array.aMove();
            array.aAdd();
            array.aMove();

        } else if (input.equals("d")) {
            array.dMove();
            array.dAdd();
            array.dMove();

        } else if (input.equals("s")) {
            array.sMove();
            array.sAdd();
            array.sMove();

        } else if (input.equals("w")) {
            array.wMove();
            array.wAdd();
            array.wMove();
        }


        //check if it is a valid move, or if games over.
        boolean validMove = array.TestMove();
        if (validMove) { //if it is a valid move.
            array.setZero();
            int zero = array.getZero(); // check if it still has 0
            if(zero==0) { // if no 0
                Array TestArray = new Array(); // put all values into a new board and test it
                TestArray.setArray(array.getArray());
                boolean gameOver = TestGameOver(TestArray);
                if(gameOver) {
                    array.print();
                    getInput(array);
                }else {
                    GameIsOver(array);
                }
            }else {
                array.addRandom();
                array.setZero();
                zero = array.getZero();
                if (zero == 0) { // if no 0
                    Array TestArray = new Array(); // put all values into a new grid and test it
                    TestArray.setArray(array.getArray());
                    boolean gameOver = TestGameOver(TestArray);
                    if(gameOver) {
                        array.print();
                        getInput(array);
                    }else {
                        array.print();
                        GameIsOver(array);
                    }
                } else {
                    array.print();
                    getInput(array);
                }
            }

        }else {
            array.setZero();
            int zero = array.getZero();
            if(zero==0) { // if no 0
                Array TestArray = new Array(); // put all values into a new grid and test it
                TestArray.setArray(array.getArray());
                boolean gameOver = TestGameOver(TestArray);
                if(gameOver) {
                    System.out.println("It is not a valid move.");
                    array.print();
                    getInput(array);
                }else {
                    GameIsOver(array);
                }
            }else {
                System.out.println("");
                System.out.println("It is not a valid move.");
                array.print();
                getInput(array);
            }

        }
    }


    public  static boolean TestGameOver(Array TestArray){
       boolean gameOver = TestArray.TestA();
       if(gameOver) {
           return true; //game is not over.
       }else{
           gameOver = TestArray.TestD();
           if(gameOver){
               return true;
           }else{
               gameOver = TestArray.TestS();
               if(gameOver){
                   return true;
               }else{
                   gameOver = TestArray.TestW();
                   if(gameOver){
                       return true;
                   }else{
                       return false; // all 4 directions have no more move
                   }
               }
           }
       }
    }

    public static void GameIsOver(Array array) {  // this method prints "Game over" if the user lost.
        Scanner scan = new Scanner(System.in);
        System.out.println("Game over.");
        restart(array);
    }

    public static void quit(Array array){
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to quit? [Y/N]");
        String confirm = scan.next();
        boolean booleans = true;
        while (booleans) {
            if(confirm.equals("Y")){
                booleans = false;
                System.out.println("Game over.");
            }else if(confirm.equals("N")){
                booleans = false;
                getInput(array);
            }else{
                confirm = scan.next();
            }
        }scan.close();

    }

    public static void restart(Array array) {  // this method restarts the game.
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to restart? [Y/N]");
        String confirm = scan.next();
        boolean booleans = true;
        while (booleans) {
            if (confirm.equals("Y")) {
                booleans = false;
                System.out.println("You are playing a game called 2048.\nUse a,s,d,w to "
                        + "represent to move left,down,right, or up.\nIf you want to stop or restart during"
                        + "the game, enter q to quit and r to restart.");
                Array array2 = new Array(); //create a new Array object
                array2.print();
                getInput(array2);
            }else if(confirm.equals("N")){
                booleans = false;
                System.out.println("Bye bye.");
            } else {
                confirm = scan.next();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("You are playing a game called 2048.\nUse a,s,d,w to "
                + "represent to move left,down,right, or up.\nIf you want to stop or retart during"
                + "the game, enter q to quit and r to restart.");
        Array array = new Array();
        array.print();
        getInput(array);
    }

}
