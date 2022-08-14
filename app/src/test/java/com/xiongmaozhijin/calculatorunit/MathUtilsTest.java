package com.xiongmaozhijin.calculatorunit;

import junit.framework.TestCase;

public class MathUtilsTest extends TestCase {

    public void testGetResult() {
        String express = "-1 + 2 * 3 - 4";
        try {
            String result = MathUtils.getResult(express);
            System.out.println("------>result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}