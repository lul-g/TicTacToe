import javax.print.DocFlavor;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        String[][] board = {
                {"   |", "   ", "|"},
                {"___|", "___", "|___"},
                {"   |", "   ", "|"},
                {"___|", "___", "|___"},
                {"   |", "   ", "|"},
                {"   |", "   ", "|  "}
        };


       // System.out.println("Please Select Game MODE:");
       // System.out.println("1: MultiPlayer \nOR\n" +
                //"2: Single Player");
        //int gameMode = in.nextInt();
        printBoard(board);




        //MULTIPLAYER

        singlePLayer(board);


    }

    public static void singlePLayer(String[][] board) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please Choose your CHAR: 'X' OR 'O': ");
        String XO = in.next();
        String[][] tracker = {
                {"0","0","0"},
                {"0","0","0"},
                {"0","0","0"}
        };

        do {
            playerMoves(tracker, XO, board);
            if(!checkForZero(tracker)) break;
            if(gameOver(tracker, XO, checkForZero(tracker))) break;
            CPUMoves(tracker, XO, board);

            for (String[] k: tracker) {
                System.out.println();
                for(String j: k)
                    System.out.print(j + " ");
            }
        }while(checkForZero(tracker));
        gameOver(tracker, XO, checkForZero(tracker));
    }


    public static boolean gameOver(String[][] tracker, String XO, boolean checkZeros) {
        //player wins

        if(XO.equalsIgnoreCase("X")) {
            if(
                tracker[0][0].equalsIgnoreCase(XO) && tracker[0][1].equalsIgnoreCase(XO) && tracker[0][2].equalsIgnoreCase(XO)
                || tracker[1][0].equalsIgnoreCase(XO) && tracker[1][1].equalsIgnoreCase(XO) && tracker[1][2].equalsIgnoreCase(XO)
                || tracker[2][0].equalsIgnoreCase(XO) && tracker[2][1].equalsIgnoreCase(XO) && tracker[2][2].equalsIgnoreCase(XO)

                || tracker[0][0].equalsIgnoreCase(XO) && tracker[1][0].equalsIgnoreCase(XO) && tracker[2][0].equalsIgnoreCase(XO)
                || tracker[0][1].equalsIgnoreCase(XO) && tracker[1][1].equalsIgnoreCase(XO) && tracker[2][1].equalsIgnoreCase(XO)
                || tracker[0][2].equalsIgnoreCase(XO) && tracker[1][2].equalsIgnoreCase(XO) && tracker[2][2].equalsIgnoreCase(XO)

                || tracker[0][0].equalsIgnoreCase(XO) && tracker[1][1].equalsIgnoreCase(XO) && tracker[2][2].equalsIgnoreCase(XO)
                || tracker[0][2].equalsIgnoreCase(XO) && tracker[1][1].equalsIgnoreCase(XO) && tracker[2][0].equalsIgnoreCase(XO)
            ) {
                System.out.println("\nYOU WIN!!!");
                return true;
            }
            else if(
                       tracker[0][0].equalsIgnoreCase("O") && tracker[0][1].equalsIgnoreCase("O") && tracker[0][2].equalsIgnoreCase("O")
                        || tracker[1][0].equalsIgnoreCase("O") && tracker[1][1].equalsIgnoreCase("O") && tracker[1][2].equalsIgnoreCase("O")
                        || tracker[2][0].equalsIgnoreCase("O") && tracker[2][1].equalsIgnoreCase("O") && tracker[2][2].equalsIgnoreCase("O")

                        || tracker[0][0].equalsIgnoreCase("O") && tracker[1][0].equalsIgnoreCase("O") && tracker[2][0].equalsIgnoreCase("O")
                        || tracker[0][1].equalsIgnoreCase("O") && tracker[1][1].equalsIgnoreCase("O") && tracker[2][1].equalsIgnoreCase("O")
                        || tracker[0][2].equalsIgnoreCase("O") && tracker[1][2].equalsIgnoreCase("O") && tracker[2][2].equalsIgnoreCase("O")

                        || tracker[0][0].equalsIgnoreCase("O") && tracker[1][1].equalsIgnoreCase("O") && tracker[2][2].equalsIgnoreCase("O")
                        || tracker[0][2].equalsIgnoreCase("O") && tracker[1][1].equalsIgnoreCase("O") && tracker[2][0].equalsIgnoreCase("O")
                ) {
                    System.out.println("\nYOU LOSE!!!");
                    return true;
                }
            else if(!checkZeros) {System.out.println("\nDRAW!!!");return true;}
            }

        else {
            if(tracker[0][0].equalsIgnoreCase(XO) && tracker[0][1].equalsIgnoreCase(XO) && tracker[0][2].equalsIgnoreCase(XO)
                    || tracker[1][0].equalsIgnoreCase(XO) && tracker[1][1].equalsIgnoreCase(XO) && tracker[1][2].equalsIgnoreCase(XO)
                    || tracker[2][0].equalsIgnoreCase(XO) && tracker[2][1].equalsIgnoreCase(XO) && tracker[2][2].equalsIgnoreCase(XO)

                    || tracker[0][0].equalsIgnoreCase(XO) && tracker[1][0].equalsIgnoreCase(XO) && tracker[2][0].equalsIgnoreCase(XO)
                    || tracker[0][1].equalsIgnoreCase(XO) && tracker[1][1].equalsIgnoreCase(XO) && tracker[2][1].equalsIgnoreCase(XO)
                    || tracker[0][2].equalsIgnoreCase(XO) && tracker[1][2].equalsIgnoreCase(XO) && tracker[2][2].equalsIgnoreCase(XO)

                    || tracker[0][0].equalsIgnoreCase(XO) && tracker[1][1].equalsIgnoreCase(XO) && tracker[2][2].equalsIgnoreCase(XO)
                    || tracker[0][2].equalsIgnoreCase(XO) && tracker[1][1].equalsIgnoreCase(XO) && tracker[2][0].equalsIgnoreCase(XO)
            ) {
                System.out.println("\nYOU WIN!!!");
                return true;
            }
            else if(
                        tracker[0][0].equalsIgnoreCase("X") && tracker[0][1].equalsIgnoreCase("X") && tracker[0][2].equalsIgnoreCase("X")
                                || tracker[1][0].equalsIgnoreCase("X") && tracker[1][1].equalsIgnoreCase("X") && tracker[1][2].equalsIgnoreCase("X")
                                || tracker[2][0].equalsIgnoreCase("X") && tracker[2][1].equalsIgnoreCase("X") && tracker[2][2].equalsIgnoreCase("X")

                                || tracker[0][0].equalsIgnoreCase("X") && tracker[1][0].equalsIgnoreCase("X") && tracker[2][0].equalsIgnoreCase("X")
                                || tracker[0][1].equalsIgnoreCase("X") && tracker[1][1].equalsIgnoreCase("X") && tracker[2][1].equalsIgnoreCase("X")
                                || tracker[0][2].equalsIgnoreCase("X") && tracker[1][2].equalsIgnoreCase("X") && tracker[2][2].equalsIgnoreCase("X")

                                || tracker[0][0].equalsIgnoreCase("X") && tracker[1][1].equalsIgnoreCase("X") && tracker[2][2].equalsIgnoreCase("X")
                                || tracker[0][2].equalsIgnoreCase("X") && tracker[1][1].equalsIgnoreCase("X") && tracker[2][0].equalsIgnoreCase("X")
                ) {
                    System.out.println("\nYOU LOSE!!!");
                    return true;
                }
            else if(!checkZeros) {System.out.println("\nDRAW!!!");return true;}

        }
        return false;

        //DRAW
    }

    public static boolean checkForZero(String[][] tracker) {
        for(String[] row: tracker)
            for (String col: row)
                if(col.equalsIgnoreCase("0")) return true;
        return false;
    }

    public static void playerMoves(String[][] tracker, String XO, String[][] board) {
        Scanner in = new Scanner(System.in);
        int user_in;
        do {
            System.out.print("\nPlease enter A number from 1 - 9: ");
            user_in = in.nextInt();
        }while (user_in > 9 || user_in < 1);


        int row, col, rowT, colT;
        while (true) {
            row = findRow(user_in);
            col = findColumn(user_in, row);

            rowT = findRowT(user_in);
            colT = findColumnT(user_in, rowT);


            if (tracker[rowT][colT].equalsIgnoreCase("0")) break;
            if(!checkForZero(tracker)) break;

            System.out.print("Please enter A number from 1 - 9: ");
            user_in = in.nextInt();
        }
        tracker[rowT][colT] = XO.toUpperCase();

        if(XO.equalsIgnoreCase("X")) replacer1(row, col, board);
        else replacer2(row, col, board);
        printBoard(board);
    }

    public static void CPUMoves(String[][] tracker, String XO, String[][] board) {
        Random random = new Random();
        int rand = random.nextInt(9 - 1) + 1;
        int row, col, rowT, colT;
        while (true) {
            row = findRow(rand);
            col = findColumn(rand, row);

            rowT = findRowT(rand);
            colT = findColumnT(rand, rowT);

            if (tracker[rowT][colT].equalsIgnoreCase("0")) break;
            if(!checkForZero(tracker)) break;

            rand = random.nextInt(9 - 1) + 1;
        }

        System.out.println("CPU MOVES at: " + rand);
        if(XO.equalsIgnoreCase("X")) {
            replacer2(row, col, board);
            tracker[rowT][colT] = "O";
        }
        else {
            replacer1(row, col, board);
            tracker[rowT][colT] = "X";
        }
        printBoard(board);
    }

    public static void replacer1(int row, int col, String[][] board) {
        if(col == 0) board[row][col] = board[row][col].replace("   |", " X |");
        else if(col == 1) board[row][col] = board[row][col].replace("   ", " X ");
        else board[row][col] = board[row][col].replace("|", "| X ");
    }

    public static void replacer2(int row, int col, String[][] board) {
        if(col == 0) board[row][col] = board[row][col].replace("   |", " O |");
        else if(col == 1) board[row][col] = board[row][col].replace("   ", " O ");
        else board[row][col] = board[row][col].replace("|", "| O ");
    }

    public static int findColumn(int user_in, int row) {
        if(row == 0)
            return user_in - 1;
        else if(row == 2)
            return user_in - 4;
        else
            return user_in - 7;
    }

    public static int findRow(int user_in) {
        if(user_in <= 3)
            return 0;
        else if(user_in <= 6)
            return 2;
        else
            return 4;
    }

    public static int findRowT(int user_in) {
        if(user_in <= 3)
            return 0;
        else if(user_in <= 6)
            return 1;
        else
            return 2;
    }

    public static int findColumnT(int user_in, int row) {
        if(row == 0)
            return user_in - 1;
        else if(row == 1)
            return user_in - 4;
        else
            return user_in - 7;
    }

    public static void printBoard(String[][] board) {
        for (String[] row: board) {
            for (String col: row) {
                System.out.print(col );
            }
            System.out.println();
        }
    }
}
