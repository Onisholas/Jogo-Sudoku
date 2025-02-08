import java.util.Random;

public class SudokuBoard {
    private int[][] board;
    private static final int SIZE = 9;
    private static final int SUBGRID_SIZE = 3;

    public SudokuBoard() {
        board = new int[SIZE][SIZE];
    }

    public void generateBoard(int difficulty) {
        fillBoard();
        removeNumbers(difficulty);
    }

    private boolean fillBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(row, col, num)) {
                            board[row][col] = num;
                            if (fillBoard()) {
                                return true;
                            }
                            board[row][col] = 0; // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // board is filled
    }

    private void removeNumbers(int difficulty) {
        Random rand = new Random();
        int cellsToRemove = 0;

        switch (difficulty) {
            case 1: // easy
                cellsToRemove = 36;
                break;
            case 2: // medium
                cellsToRemove = 45;
                break;
            case 3: // hard
                cellsToRemove = 54;
                break;
        }

        while (cellsToRemove > 0) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                cellsToRemove--;
            }
        }
    }

    public boolean isValid(int row, int col, int num) {
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num || board[x][col] == num) {
                return false;
            }
        }

        int startRow = row - row % SUBGRID_SIZE;
        int startCol = col - col % SUBGRID_SIZE;
        for (int i = 0; i < SUBGRID_SIZE; i++) {
            for (int j = 0; j < SUBGRID_SIZE; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.print("\n");
        }
    }

    public boolean isComplete() {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                if (board[r][d] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean setCell(int row, int col, int num) {
        if (isValid(row, col, num) && board[row][col] == 0) {
            board[row][col] = num;
            return true;
        }
        return false;
    }

    public void showSolution() {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.print("\n");
        }
    }
}