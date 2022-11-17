package com.lbachannel.mathutil.test.core;

import com.lbachannel.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class) // câu lệnh của JUnit sẽ cần loop qua tập data để lấy cặp data input|exoected nhồi vào hàm test
public class MathUtilDDTTest {
    
    // trả về mảng 2 chiều gồm nhiều cặp Expected|Input
    @Parameterized.Parameters // Junit sẽ ngầm chạy loop qua từng dòng của mảng
    public static Object[][] initData(){
        // int a[][] = {{x, y}, {x, y}, {x, y}}; mảng 2 chiều
        return new Integer[][]{
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 120},
        };
    }
    
    @Parameterized.Parameter(value = 0) // value = 0 là map với mảng data
    public int n; // biến map với value của cột 0 của mảng
    
    @Parameterized.Parameter(value = 1)
    public long expected; // kiểu long vì giá trị trả về của hàm getF() là long
    
    @Test 
    public void testGetFactorialGivenRightArgumentReturnsWell(){
        Assert.assertEquals(expected, MathUtil.getFactorial(n));
    }
    
}
