public class sudoku_solver {
    public static void main(String[] args) {
        char[][] input = {
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '3', '6', '.', '.', '.', '.', '.'},
                {'.', '7', '.', '.', '9', '.', '2', '.', '.'},
                {'.', '5', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '.', '4', '5', '7', '.', '.'},
                {'.', '.', '.', '1', '.', '.', '.', '3', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '6', '8'},
                {'.', '.', '8', '5', '.', '.', '.', '1', '.'},
                {'.', '9', '.', '.', '.', '.', '4', '.', '.'}
        };
        solveSudoku(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print("{");
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + ", ");
            }
            System.out.println("},");
        }
    }



    public static void solveSudoku(char[][] board) {
        int[][] boardNum = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    boardNum[i][j] = 0;
                } else {
                    boardNum[i][j] = Character.getNumericValue(board[i][j]);
                }
            }
        }
        solveSudokuHelper(boardNum);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = (char)(boardNum[i][j] + 48);
            }
        }
    }

    public static boolean solveSudokuHelper(int[][] grid) {
        // get the indices of the first unassigned value in the grid
        int[] ra = Unassigned(grid);
        // check if index doesn't exist = base case
        if (ra[0] == -1) {
            return true;
        }
        int row = ra[0];
        int col = ra[1];
        // check suitability of numbers 1 through 9
        for (int a = 1; a <= grid.length; a++) {
            // proceed to recursive case only if
            // int a doesn't already exist in the same row, col or 3x3 box
            if (isSafe(grid, row, col, a)) {
                grid[row][col] = a;
                boolean check = solveSudokuHelper(grid);
                if (check) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }

    // returns the indices of the first unassigned position on the board
    public static int[] Unassigned(int[][] arr) {
        // indices of first unassigned position on board
        int[] ra = new int[2];
        ra[0] = -1; ra[1] = -1; // indicates all positions assigned
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    ra[0] = i;
                    ra[1] = j;
                    return ra;
                }
            }
        }
        return ra;
    }

    // is the potential number in the row
    public static boolean usedInRow(int[][] grid, int row, int num) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    // is the potential number in the column
    public static boolean usedInCol(int[][] grid, int col, int num) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean usedInBox(int[][] grid, int boxRowStart, int boxColStart, int num) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + boxRowStart][j + boxColStart] == num) {
                    return true;
                }
        return false;
    }

    // is it safe to place that number at that position based on row, column, box numbers
    public static boolean isSafe(int[][] grid, int row, int col, int num) {
        boolean rowSafety = !usedInRow(grid, row, num);
        boolean colSafety = !usedInCol(grid, col, num);
        boolean boxSafety = !usedInBox(grid, (row - row % 3), (col - col % 3), num);
        return (rowSafety && colSafety && boxSafety);
    }
}




        /*
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char cur = board[i][j];
                if (cur == '.') {
                    for (int a: bag) {
                        // a is an option
                        boolean aIsOption = true;
                        // go through the row
                        for (char r: board[i]) {
                            if (r != '.' && a == Character.getNumericValue(r)) {
                                aIsOption = false;
                                break;
                            }
                        }
                        if (aIsOption) {
                            // go through the column
                            for (char v: verticle[j]) {
                                if (v != '.' && a == Character.getNumericValue(v)) {
                                    aIsOption = false;
                                }
                            }
                        }
                        if (aIsOption) {
                            // check the 3x3 box
                            int iLocFromMiddle = i - 4;
                            int jLocFromMiddle = j - 4;

                        }




                    }



                }
            }
        }



        ArrayList<Integer>[][] possibilities = new ArrayList[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char cur = board[i][j];
                int curNum = Character.getNumericValue(cur);
                if (cur != '.') {
                    possibilities[i][j].add(curNum);
                } else {
                    for (int a: bag) {
                        possibilities[i][j].add(a);
                    }
                }
            }
        }


        char[][][] boxes_3_3 = new char[3][3][3];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // 9 total 3x3 boxes
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        for (int p = 0; p < 3; p++) {
                            boxes_3_3[m][n][p] =
                        }
                    }
                }



            }
        }

*/