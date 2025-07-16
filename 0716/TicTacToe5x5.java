
import java.util.Scanner;

public class TicTacToe5x5 {

    public static final int SIZE = 5;

    public static void main(String[] args) {
        char[][] board = new char[SIZE][SIZE];
        try (Scanner sc = new Scanner(System.in)) {
            initBoard(board);
            System.out.println("=== 5x5 井字遊戲 ===");
            printBoard(board);

            char currentPlayer = 'X';
            boolean gameEnded = false;

            while (!gameEnded) {
                int row = -1, col = -1;
                boolean validMove = false;

                while (!validMove) {
                    System.out.print("玩家 " + currentPlayer + " 輸入位置 (row col): ");
                    if (!sc.hasNextInt()) {
                        sc.next(); // 跳過非整數
                        System.out.println("請輸入兩個 0~4 的整數！");
                        continue;
                    }
                    row = sc.nextInt();
                    if (!sc.hasNextInt()) {
                        System.out.println("請輸入兩個 0~4 的整數！");
                        continue;
                    }
                    col = sc.nextInt();

                    if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                        System.out.println("座標超出範圍，請重新輸入！");
                    } else if (board[row][col] != '.') {
                        System.out.println("這個位置已經被佔用了！");
                    } else {
                        validMove = true;
                    }
                }

                board[row][col] = currentPlayer;
                System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
                printBoard(board);

                if (checkWin(board, currentPlayer)) {
                    System.out.println("玩家 " + currentPlayer + " 獲勝！");
                    gameEnded = true;
                } else if (isBoardFull(board)) {
                    System.out.println("平手！");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    public static void initBoard(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.';
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char[][] board, char player) {

        for (int i = 0; i < SIZE; i++) {
            boolean win = true;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }

        for (int j = 0; j < SIZE; j++) {
            boolean win = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }

        boolean diag1 = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != player) {
                diag1 = false;
                break;
            }
        }
        if (diag1) {
            return true;
        }

        boolean diag2 = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] != player) {
                diag2 = false;
                break;
            }
        }
        if (diag2) {
            return true;
        }

        return false;
    }
}
