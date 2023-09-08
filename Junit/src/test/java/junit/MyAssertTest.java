package junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyAssertTest {
    private List<String> todos = Arrays.asList("Spring","REST","MySQL");
    @Test
    void test(){
        boolean test1 = todos.contains("REST");
//        fail("Not yet implemented");
//        assertEquals(true, test);
//        assertTrue(test1, "SOmething wrong");
        assertArrayEquals(new int[]{1,1,2}, new int[]{1,1,2});
//        assertEquals(3, todos.size());
    }

}