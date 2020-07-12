package lesson5;

public class Main5 {

    static int queenID = 0;

    public static void main(String[] args) {
        int[][] desk = new int[8][8];
        installNextQueen(desk);
        printDesk(desk);
    }

    private static boolean installNextQueen(int[][] desk) {
        queenID++;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (isEmptyFromQueensAndAttacks(desk, x, y)) {
                    desk[x][y] = queenID;
                    markCellsUnderAttack(desk, x, y, queenID);
                    if (queenID == 8) return true;
                    boolean result = installNextQueen(desk);
                    if (result == true) return true;
                    clearCellsForThisQueen(desk, queenID);
                }
            }
        }
        return false;
    }

    private static boolean isEmptyFromQueensAndAttacks(int[][] desk, int x, int y) {
        return (desk[x][y] == 0);
    }

    private static void markCellsUnderAttack(int[][] desk, int x, int y, int queenID) {
        for (int i = 0; i < 8; i++) {
            if (desk[i][y] == 0) desk[i][y] = -queenID;
            if (desk[x][i] == 0) desk[x][i] = -queenID;
            if ((x - i) >= 0 && (y - i) >= 0) {
                if (desk[x - i][y - i] == 0) desk[x - i][y - i] = -queenID;
            }
            if ((x + i) < 8 && (y + i) < 8) {
                if (desk[x + i][y + i] == 0) desk[x + i][y + i] = -queenID;
            }
            if ((x - i) >= 0 && (y - i) < 8) {
                if (desk[x - i][y + i] == 0) desk[x - i][y + i] = -queenID;
            }
            if ((x + i) < 8 && (y - i) >= 0) {
                if (desk[x + i][y - i] == 0) desk[x + i][y - i] = -queenID;
            }
        }
    }

    private static void clearCellsForThisQueen(int[][] desk, int queenID) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (desk[i][j] == queenID || desk[i][j] == -queenID) {
                    desk[i][j] = 0;
                }
            }
        }
    }


    private static void printDesk(int[][] desk) {
        int temp;
        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[0].length; j++) {
                if (desk[i][j] > 0) temp = desk[i][j];
                else temp = 0;
                System.out.printf("%3d", temp);
            }
            System.out.println();
        }
    }

}
