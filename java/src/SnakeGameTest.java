import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTest {

    public boolean[][] board1 = {
            {false, false, false, false, false},
            {false, true, true, true, false},
            {false, true, false, true, false},
            {false, true, false, true, false},
            {false, true, false, false, false},
        };

    public boolean[][] board2 = {
            {true, true, true, true, true},
            {true, false, false, false, true},
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false},
    };
    public boolean[][]  board3 = {
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false},
            {true, false, false, false, true},
            {true, true, true, true, true}
    };
    public boolean[][]  board4 = {
            {true, false, false, false, false},
            {true, false, false, false, false},
            {true, false, false, false, false},
            {true, false, false, false, false},
            {true, false, false, false, false}
    };
    public boolean[][]  board5 = {
            {false, false, false, false, false},
            {false, false, false, false, false},
            {true, true, true, true, true},
            {false, false, false, false, false},
            {false, false, false, false, false}
    };
    public boolean[][] board6 = {
            {true, false, true, true, true},
            {true, false, true, false, true},
            {true, false, true, false, true},
            {true, true, true, false, true},
            {false, false, false, false, true},
    };
    public boolean[][]  board7 = {
            {false, false, false, false, false},
            {false, false, false, false, false},
            {true, true, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false}
    };

    @Test
    //Testing Exhaustive checks
    public void test1Exhaustive(){
        int exhaustiveChecks = 22;
        SnakeGame board = new SnakeGame(board1, 3, 3);
        board.findTailExhaustive();
        assertEquals(exhaustiveChecks, board.getExhaustiveChecks());
    }
    @Test
    //Basic Test for result
    public void testExhaustive2(){
        int [] result = {1, 4, 7};
        SnakeGame board = new SnakeGame(board2, 1, 0);
        assertArrayEquals(result, board.findTailExhaustive());
    }
    @Test
    //Traversing through snake in a column exhaustively
    public void testExhaustive3(){
        int [] result = {4, 0, 5};
        SnakeGame board = new SnakeGame(board4, 0, 0);
        assertArrayEquals(result, board.findTailExhaustive());
    }
    @Test
    //Traversing through snake in a row exhaustively
    public void testExhaustive4(){
        int [] result = {2, 4, 5};
        SnakeGame board = new SnakeGame(board5, 2, 0);
        assertArrayEquals(result, board.findTailExhaustive());
    }
    @Test
    //Edge Case: What if the head was the first element on the board and the tail at
    public void testExhaustive5(){
        int [] result = {4, 4, 15};
        SnakeGame board = new SnakeGame(board6, 0, 0);
        assertArrayEquals(result, board.findTailExhaustive());
    }
    @Test
    //Basic Test for result
    public void testRecursion1(){
        int [] result = {4, 1, 8};
        SnakeGame board = new SnakeGame(board1, 3, 3);
        assertArrayEquals(result, board.findTailRecursive());
    }
    @Test
    //Checking Recursive Checks
    public void testRecursion2(){
        int recursiveChecks = 7;
        SnakeGame board = new SnakeGame(board2, 1, 4);
        board.findTailRecursive();
        assertEquals(recursiveChecks, board.getRecursiveChecks());
    }
    @Test
    //Traversing through the columns recursively
    public void testRecursion3(){
        int [] result = {3, 0, 7};
        SnakeGame board = new SnakeGame(board3, 3, 4 );
        assertArrayEquals(result, board.findTailRecursive());
    }
    @Test
    //Traversing only through the rows recursively
    public void testRecursion4(){
        int [] result = {4, 0, 5};
        SnakeGame board = new SnakeGame(board4, 0, 0);
        assertArrayEquals(result, board.findTailRecursive());
    }
    @Test
    //Edge case: What if the snake is only composed of the head and the tail?
    public void testRecursion5(){
        int [] result = {2, 1, 2};
        SnakeGame board = new SnakeGame(board7, 2, 0);
        assertArrayEquals(result, board.findTailRecursive());
    }
}