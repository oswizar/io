/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: FunctionTest
 * Author:   com.xiexing
 * Date:     2018/12/6 13:46
 * Description: 函数测试
 */
package com.xiexing.obtest;

import org.junit.Test;

public class FunctionTest {

    public int getFactorialFor(int n){
        int temp = 1;
        if(n >=0){
            for(int i = 1 ; i <= n ; i++){
                temp = temp*i;
            }
        }else{
            return -1;
        }
        return temp;
    }



    public int getFactorial(int n){
        if(n >= 0){
            if(n==0){
                System.out.println(n+"!=1");
                return 1;
            }else{
                System.out.println(n);
                int temp = n*getFactorial(n-1);
                System.out.println(n+"!="+temp);
                return temp;
            }
        }
        return -1;
    }




    @Test
    public void print () {
        getFactorial(3);
    }






}
