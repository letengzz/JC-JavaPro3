package com.hjc.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class Car {
    public void run(){
        System.out.println("汽车在跑");
    }}

class BorrowApplicationTest {
    Integer a = new Integer(10);
    Integer b = new Integer(10);
    public static final double PI = 3.14;

    @Test
    void test() {
        Car aa = new Car();
        Car bb = new Car();
        bb = aa;
        System.out.println(bb == aa);


    }
}