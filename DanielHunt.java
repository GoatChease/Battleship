public class DanielHunt {
    //Testing for active hit
    public static boolean isActiveHit(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'X') {
                    return true;
                }
            }
        }
        return false;
    }
    //Max heatmap method
    public static int[] max(int[][] arr) {
        int max = arr[0][0];
        int[] maxCoords = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    maxCoords[0] = i;
                    maxCoords[1] = j;
                }
            }
        }
        return maxCoords;
    }
    //Testing if patrol boat is sunk
    public static boolean patrolSunk(char[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '1') {
                    count++;
                }
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }
    //Testing if submarine is sunk
    public static boolean submarineSunk(char[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '2') {
                    count++;
                }
            }
        }
        if (count == 3) {
            return true;
        }
        return false;
    }
    //Testing if destroyer is sunk
    public static boolean destroyerSunk(char[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '3') {
                    count++;
                }
            }
        }
        if (count == 3) {
            return true;
        }
        return false;
    }
    //Testing if battleship is sunk
    public static boolean battleship(char[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '4') {
                    count++;
                }
            }
        }
        if (count == 4) {
            return true;
        }
        return false;
    }
    //Testing if battleship is sunk
    public static boolean aircraftSunk(char[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '5') {
                    count++;
                }
            }
        }
        if (count == 5) {
            return true;
        }
        return false;
    }
    //Testing for validity
    public static boolean isValid(int i) {
        if (i < 10) {
            return true;
        } else {
            return false;
        }
    }
    public static void printBoard(int[][] arr){
        char col = 'A';
        System.out.println("           ENEMY");
        System.out.println("    1   2   3   4   5   6");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(col + " ");
            for(int j = 0; j <arr[i].length; j++) {
                System.out.print("|_" + arr[i][j] + "_");
            }
            System.out.println("|");
            col++;
        }
    }
    //Guessing method
    public static String makeGuess(char[][] guesses) {
        int[][] heatMap = new int[10][10];
        int row, col;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (isValid(j+1)) {
                    if (guesses[i][j] == '.' && guesses[i][j+1] == '.') {
                        heatMap[i][j]++;
                        heatMap[i][j+1]++;
                    }
                }
                if (isValid(i+1)) {
                    if (guesses[i][j] == '.' && guesses[i+1][j] == '.') {
                        heatMap[i][j]++;
                        heatMap[i+1][j]++;
                    }
                }
            }
        }
        
        while (isActiveHit(guesses) == true) {

        }
        printBoard(heatMap);
        do{
            row = (int)(Math.random() * 10);
            col = (int)(Math.random() * 10);
        }while(guesses[row][col] != '.');
        char a = (char)((int)'A' + row); //Turning row into a char type
        String guess = a + Integer.toString(col+1); //Combining row and col into a guess
        return guess;
    }
}