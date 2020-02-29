import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SnakeGame {

    //Attributes
    private boolean[][] game; // Stores the final game state, cells that are true contain a part of the snake, and false are the background. Note that in this version of the game the snake will always have a barrier of one cell (i.e. every neighborhood of 9 cells around a portion of the snake will only ever have at most 3 true cells).

    private int[] headPosition; //Stores the location of the snake's head.

    private static int exhaustiveChecks; //counts the number of positions checked when performing the tail search using exhaustive enumeration, across all instances of the SnakeGame.

    private static int recursiveChecks; //counts the number of positions checked when performing the tail search using recursive search, across all instances of the SnakeGame

    private static int length;
    //Constructors
    SnakeGame(){ //which initializes an empty 1 x 1 gameboard
        int [][] board =  new int[1][1];

    }
    SnakeGame(boolean[][] board, int x, int y ){

        headPosition = new int[] {x, y};

        game = board;

    }
    //Methods
    public int[] findTailExhaustive(){

        boolean check = true;
        int[] result = new int[3];
        int length = 0;
        resetCounters();
        for(int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if(check) {
                    exhaustiveChecks++;
                }
                System.out.println("i: " + i);
                System.out.println("j: " + j);
                System.out.println();

                if (game[i][j]){
                    length++;

                    //Call Neighbors
                    int neighbors = countNeighbors(i, j);

                    if (neighbors == 1){

                        if (i == headPosition[0] && j == headPosition[1]) {
                            System.out.println("Head found at i: " + i + " j: " + j);
                        }
                        else{
                            System.out.println("Tail found at i: " + i + " j: " + j);
                            result[0] = i;
                            result[1] = j;
                            check = false;
                        }
                    }
                    if (neighbors >= 2) {
                        continue;
                    }
                }
                System.out.println("Exhaustive Checks: " + exhaustiveChecks);
            }
        }
        System.out.println("Exhaustive checks = " + exhaustiveChecks);
        System.out.println("Length of the snake is: " + length);
        result[2] = length;
        return result;
    }
    public int countNeighbors(int row, int col){
        int numNeighbors = 0;

        if((row - 1) >= 0){
            if(game[row - 1][col]){
                numNeighbors++;
            }
        }
        if((row + 1) < game.length){
            if(game[row + 1][col]){
                numNeighbors++;
            }
        }
        if((col - 1) >= 0){
            if(game[row][col - 1]){
                numNeighbors++;
            }
        }
        if((col + 1) < game[row].length){
            if(game[row][col + 1]){
                numNeighbors++;
            }
        }
        return numNeighbors;
    }

    public int[] findTailRecursive(){ //will find the tail of the snake by conducting a search starting at the head location and recursively following the snake's body, and return 3 items: the x and y position of the tail in the grid, and the length of the snake on the board. Increments the recursiveChecks counter with each (x',y') cell that is examined.
        resetCounters();

        return findTailRecursive(headPosition, headPosition);
    }
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        recursiveChecks++;
        int result [] = new int[3];
        int x = currentPosition[0];
        int y = currentPosition[1];
        System.out.println("i: " + x + " j: " + y);

        int numNeighbors = countNeighbors(x, y);

        System.out.println("Number of Neighbors: " + numNeighbors);

        if(numNeighbors == 1){
            if (headPosition[0] != x && headPosition[1] != y) {
                length++;
                result[0] = currentPosition[0];
                result[1] = currentPosition[1];
                result[2] = length;
                return result;
            }
        }
        if(x + 1 < game.length && previousPosition[0] != x + 1){
            if(game[x + 1][y]){
                length++;
                previousPosition = currentPosition;
                int[] newPos = new int[] {currentPosition[0] + 1, currentPosition[1]};
                return findTailRecursive(newPos, previousPosition);
            }
        }
        if(x - 1 >= 0 && previousPosition[0] != x - 1){
            if(game[x - 1][y]){
                length++;
                previousPosition = currentPosition;
                int[] newPos = new int[] {currentPosition[0] - 1, currentPosition[1]};
                return findTailRecursive(newPos, previousPosition);
            }
        }
        if(y + 1 < game[x].length && previousPosition[1] != y + 1){
            if(game[x][y + 1]){
                length++;
                previousPosition = currentPosition;
                int[] newPos = new int[] {currentPosition[0], currentPosition[1] + 1};
                return findTailRecursive (newPos, previousPosition);
            }
        }
        if(y - 1 >= 0 && previousPosition[1] != y - 1){
            if(game[x][y - 1]){
                length++;
                previousPosition = currentPosition;
                int[] newPos = new int[] {currentPosition[0], currentPosition[1] - 1};
                return findTailRecursive(newPos, previousPosition);
            }
        }
        length++;
        result[0] = x;
        result[1] = y;
        result[2] = length;
        System.out.println("Recursive Checks: " + getRecursiveChecks());
        System.out.println("Length of the snake is: " + length);
        System.out.println("Found tail at: i: " + x + " j: " + y);

        return result;
    }



    private void resetCounters(){ //resets both the exhaustiveChecks and recursiveChecks counters to 0.
        exhaustiveChecks = 0;
        recursiveChecks = 0;

    }

    public static int getRecursiveChecks(){ //gets the current state of the recursiveChecks counter.
        return  recursiveChecks;
    }
    public static int getExhaustiveChecks(){ //gets the current state of the exhaustiveChecks counter.
        return  exhaustiveChecks;
    }
}
