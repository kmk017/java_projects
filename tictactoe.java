import java.util.*;


public class tictactoe {
    static char[][] board = new char[3][3]; // 3x3 game board

    // Initialize the board with empty spaces
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print the current board
    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Check if a player has won
    public static boolean checkWinner(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Check if the board is full (for draw)
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // still an empty cell
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        initializeBoard();
        char currentPlayer = 'X';

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your row and column (0, 1, or 2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // Check if the cell is empty
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer; // Place player's move
                printBoard();

                // Check for winner
                if (checkWinner(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                // Check for draw
                if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }

                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        sc.close();
    }
}
