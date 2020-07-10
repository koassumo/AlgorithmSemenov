package lesson5;

public class Main5 {

    static int queenID = 1;

    public static void main(String[] args) {
        int[][] desk = new int[8][8];
        installNextQueen(desk);
        printDesk(desk);
//        System.out.println(op);
    }

    private static void installNextQueen(int[][] desk) {



        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (isEmptyFromQueensAndAttacks(desk, x, y)) {
                    desk[x][y] = queenID;
                    markCellsUnderAttack (desk, x, y, queenID);
                    queenID++;
                    installNextQueen(desk);
                }

            }

        }
    }

    private static boolean isEmptyFromQueensAndAttacks(int[][] desk, int x, int y) {
        return (desk [x][y] == 0);
    }

    private static void markCellsUnderAttack (int[][] desk, int x, int y, int queenID) {
        for (int i = 0; i < 8; i++) {
            if (desk[i][y] == 0) desk [i][y] = -queenID ;
            if (desk[x][i] == 0) desk [x][i] = -queenID;
        }
    }







//    private static int op = 0;
//    private static boolean knightMove(int[][] desk, int currX, int currY, int move) {
//        desk[currX][currY] = move;
//        if (move > desk.length * desk[0].length - 1) return true;
//
//        int nextX, nextY;
//        for (int i = 0; i < 7; i++) {
//            op++;
//            nextX = currX + kMoves[i][1];
//            nextY = currY + kMoves[i][0];
//            if (isPossible(desk, nextX, nextY) && knightMove(desk, nextX, nextY, move + 1)) {
//                return true;
//            }
//        }
//        desk[currX][currY] = 0;
//        return false;
//    }

    private static void printDesk(int[][] desk) {
        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[0].length; j++) {
                System.out.printf("%3d", desk[i][j]);
            }
            System.out.println();
        }
    }

}
