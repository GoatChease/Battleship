public class DanielHunt {
    public static String makeGuess(char[][] guesses) {
        int[][] heatmap = new int[10][10];
        int row, col;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //Patrol boat
                if (!patrolSunk(guesses)) {
                    if (isValid(i+1, j) && isOpen(i, j, guesses) && isOpen(i+1, j, guesses)) {
                        heatmap[i][j]++;
                        heatmap[i+1][j]++;
                    }
                    if (isValid(i, j+1) && isOpen(i, j, guesses) && isOpen(i, j+1, guesses)) {
                        heatmap[i][j]++;
                        heatmap[i][j+1]++;
                    }
                }
                //Submarine
                if (!submarineSunk(guesses)) {
                    if (isValid(i+2, j) && isOpen(i, j, guesses) && isOpen(i+2, j, guesses)) {
                        heatmap[i][j]++;
                        heatmap[i+1][j]++;
                        heatmap[i+2][j]++;
                    }
                    if (isValid(i, j+2) && isOpen(i, j, guesses) && isOpen(i, j+2, guesses)) {
                        heatmap[i][j]++;
                        heatmap[i][j+1]++;
                        heatmap[i][j+2]++;
                    }
                }
                //Destroyer ship
                if (!destroyerSunk(guesses)) {
                    if (isValid(i+2, j) && isOpen(i, j, guesses) && isOpen(i+2, j, guesses)) {
                        heatmap[i][j]++;
                        heatmap[i+1][j]++;
                        heatmap[i+2][j]++;
                    }
                    if (isValid(i, j+2) && isOpen(i, j, guesses) && isOpen(i, j+2, guesses)) {
                        heatmap[i][j]++;
                        heatmap[i][j+1]++;
                        heatmap[i][j+2]++;
                    }
                }
                //Battleship
                if (!battleshipSunk(guesses)) {
                    if (isValid(i+3, j) && isOpen(i, j, guesses) && isOpen(i+3, j, guesses)) {
                        heatmap[i][j]++;
                        heatmap[i+1][j]++;
                        heatmap[i+2][j]++;
                        heatmap[i+3][j]++;
                    }
                    if (isValid(i, j+3) && isOpen(i, j, guesses) && isOpen(i, j+3, guesses)) {
                        heatmap[i][j]++;
                        heatmap[i][j+1]++;
                        heatmap[i][j+2]++;
                        heatmap[i][j+3]++;
                    }
                }
                //Aircraft carrier
                if (!aircraftSunk(guesses)) {
                    if (isValid(i+4, j) && isOpen(i, j, guesses) && isOpen(i+4, j, guesses)) {
                        heatmap[i][j]++;
                        heatmap[i+1][j]++;
                        heatmap[i+2][j]++;
                        heatmap[i+3][j]++;
                        heatmap[i+4][j]++;
                    }
                    if (isValid(i, j+4) && isOpen(i, j, guesses) && isOpen(i, j+4, guesses)) {
                        heatmap[i][j]++;
                        heatmap[i][j+1]++;
                        heatmap[i][j+2]++;
                        heatmap[i][j+3]++;
                        heatmap[i][j+4]++;
                    }
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
                //Negative for anything that has already been guessed
                if (guesses[i][j] != '.') {
                    heatmap[i][j] = -9;
                }
            }
        }
        int[] coords = maxHeat(heatmap);
        row = coords[0];
        col = coords[1];
        char a = (char)((int)'A' + row);
        String guess = a + Integer.toString(col+1);
        return guess;
    }
    //Method to find max value
    public static int[] maxHeat(int[][] arr) {
        int[] maxCoords = new int[2];
        int max = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
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
    //Testing to make sure it's in bounds
    public static boolean isValid(int i, int j) {
        return i >= 0 && i < 10 && j >= 0 && j < 10;
    }
    //Testing to see if it's a possible position for a ship
    public static boolean isOpen(int i, int j, char[][] arr) {
        return arr[i][j] == '.' || arr[i][j] == 'X';
    }
}