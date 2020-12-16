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
        int sudokuSize = sudoku[0].length;
        String[] emptySlots = {};
        String axisX = "";
        String axisY = "";
        for(int i=0;i<sudokuSize;i++){
            for(int j=0;j<sudokuSize;j++){
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
        int sudokuSize = sudoku[0].length;
        for(int i=0; i<sudokuSize; i++){
            if(sudoku[row][i] != 0){
                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[row][i]);
            }
        }
        return usedNumb;
    }

    public static int[] checkColumn(int[][] sudoku, int column, int[] usedNumb){
        int sudokuSize = sudoku[0].length;
        for(int i=0; i<sudokuSize; i++){
            if(sudoku[i][column] != 0){
                if(!checkSameNumber(usedNumb, sudoku[i][column])){
                    usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][column]);
                }
            }
        }
        return usedNumb;
    }
    public static int[] checkBox9s(int[][] sudoku, int row, int column, int[] usedNumb){
        //First row
        if(0 <= row && row < 3){
            if(0 <= column && column < 3){
                for(int i=0; i<3; i++){
                    for(int j=0; j<3;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
            if(3 <= column && column < 6){
                for(int i=0; i<3; i++){
                    for(int j=3; j<6;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
            if(6 <= column && column < 9){
                for(int i=0; i<3; i++){
                    for(int j=6; j<9;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
        }
        //Second row
        if(3 <= row && row < 6){
            if(0 <= column && column < 3){
                for(int i=3; i<6; i++){
                    for(int j=0; j<3;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
            if(3 <= column && column < 6){
                for(int i=3; i<6; i++){
                    for(int j=3; j<6;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
            if(6 <= column && column < 9){
                for(int i=3; i<6; i++){
                    for(int j=6; j<9;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
        }
        //Third row
        if(6 <= row && row < 9){
            if(0 <= column && column < 3){
                for(int i=6; i<9; i++){
                    for(int j=0; j<3;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
            if(3 <= column && column < 6){
                for(int i=6; i<9; i++){
                    for(int j=3; j<6;j++){
                        if(sudoku[i][j] != 0)
                            if(!checkSameNumber(usedNumb, sudoku[i][j])){
                                usedNumb = pushIntArray(usedNumb.length, usedNumb, sudoku[i][j]);
                            }
                    }
                }
            }
            if(6 <= column && column < 9){
                for(int i=6; i<9; i++){
                    for(int j=6; j<9;j++){
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

    public static int[] checkBox4s(int[][] sudoku, int row, int column, int[] usedNumb){
        
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

    public static boolean checkIfValid (int[][] sudoku, int axisX, int axisY, int number){
        for(int x = 0; x < 9; x++){
            if(sudoku[axisY][x] == number){
                return false;
            }
        }
        for(int y = 0; y < 9; y++){
            if(sudoku[y][axisX] == number){
                return false;
            }
        }
        for (int x = (axisX / 3) * 3; x < (axisX / 3 + 1) * 3; x++){
            for(int y = (axisY / 3) * 3; y < (axisY /3 + 1)* 3; y++){
                if(sudoku[y][x] == number){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solver(int[][] sudoku){
        for (int axisX = 0; axisX < 9; axisX++){
            for (int axisY = 0; axisY < 9; axisY++){
                if(sudoku[axisY][axisX] == 0){
                    for (int number = 1; number <=9; number++){
                        if(checkIfValid(sudoku, axisX, axisY, number)){
                            sudoku[axisY][axisX] = number;
                            if(solver(sudoku)) return true;
                            sudoku[axisY][axisX] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        for (int[] row : sudoku)
            System.out.println(Arrays.toString(row));
        return true;
    }

    public static void main (String[] args){
        int[][] sudoku = {
                {0, 0, 0, 0, 0, 0, 2, 0, 0},
                {0, 8, 0, 0, 0, 7, 0, 9, 0},
                {6, 0, 2, 0, 0, 0, 5, 0, 0},
                {0, 7, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 4, 0},
                {0, 0, 5, 0, 0, 0, 6, 0, 3},
                {0, 9, 0, 4, 0, 0, 0, 7, 0},
                {0, 0, 6, 0, 0, 0, 0, 0, 0},
        };
        int[][] sudokuZ = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] sudokuX = {
                {0, 0, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0},
        };
        System.out.println(solver(sudokuX));
        // Loop through all rows


    }
}
