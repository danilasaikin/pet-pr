import java.util.Scanner;

public class TicTacToe {
    public TicTacToe() {
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 88;
        boolean gameFinished = false;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            while(!gameFinished) {
                printBoard(board);
                System.out.print("Игрок " + currentPlayer + ", введите строку и столбец через пробел и нажмите Enter \n (например, 1 \"пробел\" 2 \"Enter\" ): ");
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = (char)currentPlayer;
                    if (checkWin(board, (char)currentPlayer)) {
                        printBoard(board);
                        System.out.println("Игрок " + currentPlayer + " выиграл!");
                        gameFinished = true;
                    } else if (isBoardFull(board)) {
                        printBoard(board);
                        System.out.println("Ничья!");
                        gameFinished = true;
                    } else {
                        currentPlayer = (char) (currentPlayer == 88 ? 79 : 88);
                    }
                } else {
                    System.out.println("Недопустимый ход. Попробуйте снова.");
                }
            }

            scanner.close();
            return;
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("  1 2 3");

        for(int i = 0; i < 3; ++i) {
            System.out.print(i + 1 + " ");

            for(int j = 0; j < 3; ++j) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }

            System.out.println();
            if (i < 2) {
                System.out.println("  -+-+-");
            }
        }

    }

    public static boolean checkWin(char[][] board, char player) {
        for(int i = 0; i < 3; ++i) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }

            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        } else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBoardFull(char[][] board) {
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}
