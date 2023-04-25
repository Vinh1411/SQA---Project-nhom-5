/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vinh
 */
public class NganHangDAOTestTest {
    
    public NganHangDAOTestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of testLayToanBoNganHangException1 method, of class NganHangDAOTest.
     */
    @Test
    public void testTestLayToanBoNganHangException1() throws UnsupportedEncodingException {
        System.out.println("Truong hop 1: Bo qua vong lap");
        NganHangDAOTest instance = new NganHangDAOTest();
        instance.testLayToanBoNganHangException1();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testLayToanBoNganHangException2 method, of class NganHangDAOTest.
     */
    @Test
    public void testTestLayToanBoNganHangException2() {
        System.out.println("Truong hop 2: Thuc hien vong lap 1 lan");
        NganHangDAOTest instance = new NganHangDAOTest();
        instance.testLayToanBoNganHangException2();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testLayToanBoNganHangException3 method, of class NganHangDAOTest.
     */
    @Test
    public void testTestLayToanBoNganHangException3() {
        System.out.println("Truong hop 3: Thuc hien vong lap k lan");
        NganHangDAOTest instance = new NganHangDAOTest();
        instance.testLayToanBoNganHangException3();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
