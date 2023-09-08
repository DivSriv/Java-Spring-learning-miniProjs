package com.mockito.mockdemo.business;

import com.mockito.mockdemo.Dummy.AbstractClass;
import com.mockito.mockdemo.Dummy.Instance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @BeforeEach
    void testThreeValueArray(){
        System.out.println("test3val");
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25,15,5});
        assertEquals(25, someBusiness.findTheGreatestFromAllData());
    }

    @Test
    void testOneValue(){
        System.out.println("test1val");
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{45});
        assertEquals(45, someBusiness.findTheGreatestFromAllData());
    }
    @Test
    void testEmptyArray(){
        System.out.println("test0val");
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, someBusiness.findTheGreatestFromAllData());
    }

}

