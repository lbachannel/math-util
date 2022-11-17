package com.lbachannel.mathutil.test.core;

import com.lbachannel.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

public class MathUtilityTest {

    /*
        Đây là class sẽ sử dụng các hàm của thư viện/Framework JUnit
        Để kiểm thử/kiểm tra code chính - hàm tínhGiaiThua() bên
        class core.MathUtil
        Viết code để test code chính bên kia!!!
    */
    
    /*
        Có nhiều quy tắc đặt tên hàm kiểm thử
        nhưng thường sẽ là nói lên mục đích của các case/tình huống kiểm thử
        tình huống xài hàm theo kiểu thành công và thất bại
    */
    
    // hàm dưới đây là tình huống test hàm chạy thành công, trả về ngon
    // ta sẽ xài hàm kiểu well - đưa 5!, 6!, hok chơi đưa - 5!, 30!
    
    // @Test JUnit sẽ phối hợp với JVM để chạy hàm này
    // @Test phía hậu trường chính là public static void main()
    // Có nhiều @Test ứng với nhiều case khác nhau để kiểm thử hàm tính giai thừa
    @Test 
    public void testGetFactorialGivenRightArgumentReturnsWell(){
        int n = 0; // test thử tình huống tử tế đầu vào, mày phải chạy đúng
        long exptected = 1; // hy vọng 0! = 1
        
//        long actual = ; // gọi hàm cần test bên core/app chính
        long actual = MathUtil.getFactorial(n);
        
        // so sánh expected vs. actual dùng xanh xanh đỏ đỏ, framework
        Assert.assertEquals(exptected, actual);
        // hàm giúp so sánh 2 giá trị nào đó có giống nhau hay ko
        // nếu giống nhau -> thảy màu xanh đèn đường - đường thông, code ngon
        //                   ít nhất cho case đang test
        // nếu ko giống nhau -> thảy màu đỏ đèn đường
        //                      hàm ý expected và actual ko giống nhau
        
        
        // gộp thêm vài case thành công/đưa đầu vào ngon!!! hàm phải tính ngon
        
        Assert.assertEquals(1, MathUtil.getFactorial(1)); // tui mún 1! == 1
        Assert.assertEquals(2, MathUtil.getFactorial(2)); // tui mún 2! == 2
        Assert.assertEquals(6, MathUtil.getFactorial(3)); // tui mún 3! == 6
        Assert.assertEquals(24, MathUtil.getFactorial(4)); // tui mún 4! == 24
        Assert.assertEquals(120, MathUtil.getFactorial(5)); // tui mún 5! == 120
        Assert.assertEquals(720, MathUtil.getFactorial(6)); // tui mún 6! == 720
    }
    
    //========================================================================== Bắt Exception cách 1
    
    /*
        hàm getF() ta thiết kế có 2 tình huống xử lí
        1. đưa data tử tế trong [0..20] -> tính đúng được n! - done
        2. đưa dât vào cà chớn, âm, > 20; thiết kế của hàm là ném ra ngoại lệ
           tao kì vọng ngoại lệ xuất hiện khi n < 0 || n > 20
           rất mong ngoại lệ xuất hiện với n cà chớn này
           nếu hàm nhận vào n < 0 hoặc n > 20 và hàm ném ra ngoại lệ
           Hàm chạy đúng như thiết kế -> XANH phải xuất hiện
    
           Nếu hàm nhận vào n < 0 hoặc n > 20 và hàm éo ném ra ngoại lệ
           sure, hàm chạy sai thiết kế, sai kì vọng, màu đỏ
    
        Test case:
        input    : -5
        expected : IllegalArgumentException xuất hiện
        tình huống bất thường, ngoại lệ, ngoài dự tính, dữ liệu
        Là những thứ ko thể đo đường so sánh theo kiểu value
        Mà chỉ có thể đo lường = cách chúng có xuất hiện hay ko
        assertEquals() KO DÙNG để si sánh 2 ngoại lệ
        equals()       là bằng nhau hay không trên value!!!
        Màu đỏ đó em, do hàm đúng là có ném ngoại lệ thật sự
                      nhưng ko phải là ngoại lệ như kì vọng - thực sự kì vọng sai
                      ko phải hàm ném sai
    */
    
//    @Test(expected = NumberFormatException.class)
//    public void testGetFactorialGivenWrongArgumentThrowsException(){
//        MathUtil.getFactorial(-5); // hàm @Test chạy, hay hàm getF() chạy 
//                                   // sẽ ném về ngoại lệ NumberFormat... (legal: hợp pháp, Illegal là éo hợp pháp)
//    }
    
//    @Test(expected = IllegalArgumentException.class)
//    public void testGetFactorialGivenWrongArgumentThrowsException(){
//        MathUtil.getFactorial(-5); // hàm @Test chạy, hay hàm getF() chạy 
//                                   // sẽ ném về ngoại lệ IllegalArgumentException... (legal: hợp pháp, Illegal là éo hợp pháp)
//    }
    
    //========================================================================== Cách 3: bắt bằng Lambda
    
    // cách khác để bắt ngoại lệ xuất hiện, viết tự nhiên hơn!!!
    // xài Lambda
    // Test case: hàm sẽ ném về ngoại lệ nếu nhận vào 21
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_LambdaVersion(){
        //Assert.assertThrows(tham số 1: loại ngoại lệ muốn so sánh, 
        //                    tham số 2: đoan code chạy văng ra ngoại lệ runnable);
        
        Assert.assertThrows(IllegalArgumentException.class, () -> MathUtil.getFactorial(-5)); // hàm này cũng là dạng kì vọng ném ngoại lệ
        
    }
    
    //========================================================================== Cách 2: chủ động bắt bằng Try - catch
    
    // Bắt ngoại lệ, xem hàm có ném về ngoại lệ hay ko khi n cà chớn
    // có ném, tức là hàm chạy đúng thiết kế -> xanh
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_TryCath(){
        
        // chủ động kiểm soát ngoại lệ
        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            /*
                bắt try-catch là JUnit sẽ ra xanh do chủ động kiểm soát ngoại lệ
                nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko ???
                có đoạn code kiểm soát đúng ngoại lệ IllegalArgumentException xh
            */

            Assert.assertEquals("Invalid argument. N must be between 0..20", e.getMessage());
            
        }
    }
    
}
