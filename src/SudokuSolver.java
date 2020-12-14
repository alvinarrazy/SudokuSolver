import java.io.Console;
import java.util.*;
import java.util.Arrays;

public class SudokuSolver {

    public static String[] pushStrArray(int n, String arr[], String x)
    {
        int i;

        // create a new array of size n+1
        String newarr[] = new String[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }

    public static int[] pushIntArray(int n, int arr[], int x)
    {
        int i;

        // create a new array of size n+1
        int newarr[] = new int[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }

    public static String[] findEmptySlots(int[][] sudoku){
        String[] emptySlots = {};
        String axisX = "";
        String axisY = "";
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(sudoku[i][j] == 0){
                    axisX = Integer.toString(j);
                    axisY = Integer.toString(i);
                    emptySlots = pushStrArray(emptySlots.length, emptySlots, (axisY + axisX));
                }
            }

        }
        //for(int i=0; i<emptySlots.length;i++)
        //    System.out.println((emptySlots[i]));
        return emptySlots;
    }

    public static boolean checkSameNumber(int[] num, int toFind){
        boolean found = false;

        for (int n : num) {
            if (n == toFind) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static int[] checkRow(int[][] sudoku, int row, int[] usedNumb){
        for(int i=0; i<4; i++){
            if(sudoku[row][i] != 0){
                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[row][i]);
            }
        }
        return usedNumb;
    }

    public static int[] checkColumn(int[][] sudoku, int column, int[] usedNumb){
        for(int i=0; i<4; i++){
            if(sudoku[i][column] != 0){
                if(!checkSameNumber(usedNumb, sudoku[i][column])){
                    usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][column]);
                }
            }
        }
        return usedNumb;
    }

    public static int[] checkBox(int[][] sudoku, int row, int column, int[] usedNumb){
        if(0 <= row && row <= 1){
            if(0 <= column && column <= 1){
                for(int i=0; i<=1; i++){
                    for(int j=0; j<=1;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
            if(1 < column && column <= 3){
                for(int i=0; i<=1; i++){
                    for(int j=2; j<=3;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
        }
        if(1 < row && row <= 3){
            if(0 <= column && column <= 1){
                for(int i=2; i<=3; i++){
                    for(int j=0; j<=1;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
            if(1 < column && column <= 3){
                for(int i=2; i<=3; i++){
                    for(int j=2; j<=3;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
        }
        //System.out.println("Checkbox: " + sudoku[1][1]);
        return usedNumb;
    }

    public static int[][] solver(int[][] sudoku){
        String[] emptySlots = findEmptySlots(sudoku);

        for(int i=0; i< emptySlots.length;i++) {

            int [] usedNumb = {};
            int axisX;
            int axisY;
            int correctNumb = 0;

            axisY = Integer.parseInt(emptySlots[i].split("", 2)[0]);
            axisX = Integer.parseInt(emptySlots[i].split("", 2)[1]);

            usedNumb = checkRow(sudoku, axisY, usedNumb);
            usedNumb = checkColumn(sudoku, axisX, usedNumb);
            usedNumb = checkBox(sudoku, axisY, axisX, usedNumb);

            for (int numb = 1; numb <= 5; numb++) {
                correctNumb = numb;
                if(!checkSameNumber(usedNumb, correctNumb))
                    break;
            }//sampe sini belum masukin ke array
            sudoku[axisY][axisX] = correctNumb;
            System.out.println(correctNumb);

        }
        //System.out.println("number: "+sudoku[2][3]);

        return sudoku;
    }

    public static void main (String[] args){
        /*int[][] sudoku = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };*/
        int[][] sudoku = {
                {0, 3, 4, 0},
                {4, 0, 0, 2},
                {1, 0, 0, 3},
                {0, 2, 1, 0}
        };
        //System.out.println(sudoku[0][0]);
        sudoku = solver(sudoku);
        // Loop through all rows
        for (int[] row : sudoku)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
}
