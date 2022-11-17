package com.lbachannel.mathutil.main;

import com.lbachannel.mathutil.core.MathUtil;

public class Main {
    public static void main(String[] args) {
        /*
            thử nghiệm hàm tính giai thừa coi chạy đúng như thiết kế hay không
            ta phải đưa ra các tình huống sử dụng hàm trong thực tế
            Ví dụ: -5 coi tính được không
                    0 coi tính mấy
                    20 coi tính mấy
                    21 coi tính ra mấy!!!
        
            => TEST CASE: Một tình huống hàm/app/màn hình/tính năng được đưa vào sử dụng
                          giả lập hành vi xài của ai đó
        
               TEST CASE: Là 1 tình huống sử dụng, xài App hay xài (HÀM) mà nó bao gồm: 
                          Input: data đầu vào cụ thể nào đó

                          Output đầu ra ứng với xử lí của hàm/chức năng của app, dĩ nhiên dùng đầu vào để xử lí
                          Kì vọng: Mong hàm sẽ trả về value nào đó ứng với input ở trên
                          So sánh để xem kết quả có như kì vọng hay không
        */
        
        // ĐÂY LÀ TEST KIỂU TRÂU BÒ
        
        long expected = 120; // ta kì vọng hàm ói về 120 nếu tính 5!
        int n = 5;           // input
        long actual = MathUtil.getFactorial(n);
        System.out.println("5! = " + expected + " expected");
        System.out.println("5! = " + actual + " actual"); // đúng cho case xài 5!
        
        //======================================================================
 
    }
}
