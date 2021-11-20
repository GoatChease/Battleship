public class DanielHunt {
    public static String makeGuess(char[][] guesses) {
        int[][] heatmap = new int[10][10];
        int[] coords = new int[2];
        int row, col;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //Patrol boat
                if (isValid(i+1, j) && isOpen(i, j, guesses) && isOpen(i+1, j, guesses) && !patrolSunk(guesses)) {
                    heatmap[i][j]++;
                    heatmap[i+1][j]++;
                }
                if (isValid(i, j+1) && isOpen(i, j, guesses) && isOpen(i, j+1, guesses) && !patrolSunk(guesses)) {
                    heatmap[i][j]++;
                    heatmap[i][j+1]++;
                }
                //Submarine
                if (isValid(i+2, j) && isOpen(i, j, guesses) && isOpen(i+2, j, guesses) && !submarineSunk(guesses)) {
                    heatmap[i][j]++;
                    heatmap[i+2][j]++;
                }
                if (isValid(i, j+2) && isOpen(i, j, guesses) && isOpen(i, j+2, guesses) && !submarineSunk(guesses)) {
                    heatmap[i][j]++;
                    heatmap[i][j+2]++;
                }
                //Destroyer ship
                if (isValid(i+2, j) && isOpen(i, j, guesses) && isOpen(i+2, j, guesses) && !destroyerSunk(guesses)) {
                    heatmap[i][j]++;
                    heatmap[i+2][j]++;
                }
                if (isValid(i, j+2) && isOpen(i, j, guesses) && isOpen(i, j+2, guesses) && !destroyerSunk(guesses)) {
                    heatmap[i][j]++;
                    heatmap[i][j+2]++;
                }
                //Battleship
                if (isValid(i+3, j) && isOpen(i, j, guesses) && isOpen(i+3, j, guesses) && !battleshipSunk(guesses)) {
                    heatmap[i][j]++;
                    heatmap[i+3][j]++;
                }
                if (isValid(i, j+3) && isOpen(i, j, guesses) && isOpen(i, j+3, guesses) && !battleshipSunk(guesses)) {
                    heatmap[i][j]++;
                    heatmap[i][j+3]++;
                }
                //Aircraft carrier
                if (isValid(i+4, j) && isOpen(i, j, guesses) && isOpen(i+4, j, guesses) && !aircraftSunk(guesses)) {
                    heatmap[i][j]++;
                    heatmap[i+4][j]++;
                }
                if (isValid(i, j+4) && isOpen(i, j, guesses) && isOpen(i, j+4, guesses) && !aircraftSunk(guesses)) {
                    heatmap[i][j]++;
                    heatmap[i][j+4]++;
                }
                
                if (guesses[i][j] == 'O') {
                    heatmap[i][j] = 0;
                }
                //Up
                if (guesses[i][j] == 'X' && isValid(i+1, j)) {
                    heatmap[i+1][j] += 10;
                }
                //Right
                if (guesses[i][j] == 'X' && isValid(i, j+1)) {
                    heatmap[i][j+1] += 10;
                }
                //Down
                if (guesses[i][j] == 'X' && isValid(i-1, j)) {
                    heatmap[i-1][j] += 10;
                }
                //Left
                if (guesses[i][j] == 'X' && isValid(i, j-1)) {
                    heatmap[i][j-1] += 10;
                }
            }
        }
        coords = maxHeat(heatmap);
        row = coords[0];
        col = coords[1];
        char a = (char)((int)'A' + row);
        printBoard(heatmap);
        String guess = a + Integer.toString(col+1);
        return guess;
        
    }
    
    public static int[] maxHeat(int[][] arr) {
        int[] maxCoords = new int[2];
        int max = arr[0][0];
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
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
    public static boolean battleshipSunk(char[][] arr) {
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
    //Testing if aircraft carrier is sunk
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
    //Validity check
    public static boolean isValid(int i, int j) {
        return i >= 0 && i < 10 && j >= 0 && j < 10;
    }
    public static boolean isOpen(int i, int j, char[][] arr) {
        return arr[i][j] == '.' || arr[i][j] == 'X';
    }
    public static void printBoard(int[][] arr){
        char col = 'A';
        System.out.println("__________________________________________________");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(col + " ");
            for(int j = 0; j <arr[i].length; j++) {
                System.out.print("|_" + arr[i][j] + "_");
            }
            System.out.println("|");
            col++;
        }
    }
}