package junit;

import org.junit.jupiter.api.*;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeBeforeAfterTest {
    @BeforeAll
    static void beforeAll(){
//        fail("Not yet implemented");
        System.out.println("before All");
    }
    @Test
    void test1(){
//        fail("Not yet implemented");
        System.out.println("test1");
    }
    @AfterEach
    void test2(){
//        fail("Not yet implemented");
        System.out.println("AfterEach");
    }
    @Test
    void test3(){
//        fail("Not yet implemented");
        System.out.println("test3");
    }
    @BeforeEach
    void test4(){
//        fail("Not yet implemented");
        System.out.println("BeforeEach");
    }

    @AfterAll
    static void afterAll(){
//        fail("Not yet implemented");
        System.out.println("After All");
    }

}