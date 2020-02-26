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

    @Test
    public void test1(){
        int [] result = {4, 1, 8};
        SnakeGame board = new SnakeGame(board1, 3, 3);
        assertArrayEquals(result, board.findTailExhaustive());
    }
    @Test
    public void test2(){
        int [] result = {1, 4, 7};
        SnakeGame board = new SnakeGame(board2, 1, 0);
        assertArrayEquals(result, board.findTailExhaustive());
    }
    @Test
    public void test3(){
        int [] result = {3, 0, 7};
        SnakeGame board = new SnakeGame(board3, 3, 4 );
        assertArrayEquals(result, board.findTailExhaustive());
    }
    @Test
    public void test4(){
        int [] result = {4, 0, 5};
        SnakeGame board = new SnakeGame(board4, 0, 0);
        assertArrayEquals(result, board.findTailExhaustive());
    }
}