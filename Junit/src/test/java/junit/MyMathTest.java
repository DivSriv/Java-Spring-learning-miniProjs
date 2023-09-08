package junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    private MyMath myMath = new MyMath();
    @Test
    void calcThreeLengthArray(){
//        fail("Not yet implemented");
        assertEquals(6,myMath.calcSum(new int[]{1,2,3}));
    }
    @Test
    void calcZeroLengthArray(){
//        fail("Not yet implemented");
        assertEquals(0,myMath.calcSum(new int[]{}));
    }
}