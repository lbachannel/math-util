package com.lbachannel.mathutil.core;

public class MathUtil {
    
    /*
        trong class này cung cấp cho ai đó nhiều cái hàm xử lí toán học
        clone class Math của JDK
        Hàm thư viện xài chung cho ai đó, ko cần lưu lại trạng thái/ giá trị
        Chọn thiết kế là hàm static
    */
    
    /*
        hàm tính giai thừa !!!
        => n! = 1.2.3.4...n | Không có giai thừa cho số âm
        0! = 1! = 1 quy ước
        giai thừa hàm đồ thị dốc đứng, tăng nhanh về giá trị
        giai thừa hàm đồ thị dốc đứng, tăng nhanh về giá trị
        20 giai thừa 18 con số 0, vừa kịp đủ cho kiểu long của Java
        21 giai thừa tràn kiểu long
        bài này quy ước tính n! trong khoảng từ 0..20
    */
    
//    public static long getFactorial(int n){
//        if(n < 0 || n > 20){
//            throw new IllegalArgumentException("Invalid argument. N must be between 0..20"); // nếu đưa cà chớn, quăng ra 1 cái ngoại lệ, ko thông báo gì cả
//        }
//        if(n == 0 || n == 1){
//            return 1; // kết thúc cuộc chơi sớm, nếu nhận những đầu vào đặc biệt
//        }
//        long product = 1; // tích nhân dồn, thuật toán heo đất, ốc bu dồn thịt
//        for(int i = 2; i <= n; ++i){
//            product *= i;
//        }
//        return product;
//    } 
    
    // Đệ quy: hiện tượng gọi lại chính mình với 1 quy mô khác - recursion
    /*
        n! = 1.2.3.4.5.6. ... .n
        6! = 6 x 5!
        5! = 5 x 4!
        4! = 4 x 3!
        3! = 3 x 2!
        2! = 2 x 1! // stop
    
        Quy ước: 1! = 0! = 1;
    
        Công thức đệ quy: n! = n * (n - 1)!
    */
    
    public static long getFactorial(int n){
        if(n < 0 || n > 20){
            throw new IllegalArgumentException("n must be between 0..20");
        }
        if(n == 0 || n == 1){
            return 1; // kết thúc cuộc chơi sớm, nếu nhận những đầu vào đặc biệt
        }
        
        return n * getFactorial(n - 1);
    } 
}
