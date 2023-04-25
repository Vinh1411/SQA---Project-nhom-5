/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
public class HoaDonDAOTestTest {
    
    public HoaDonDAOTestTest() {
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
     * Test of testThemHoaDonException1 method, of class HoaDonDAOTest.
     */
    @Test
    public void testTestThemHoaDonException1() {
        System.out.println("Truong hop 1: Hoa don sai thong tin, nguoi dung khong ton tai");
        HoaDonDAOTest instance = new HoaDonDAOTest();
        instance.testThemHoaDonException1();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testThemHoaDonException2 method, of class HoaDonDAOTest.
     */
    @Test
    public void testTestThemHoaDonException2() {
        System.out.println("Truong hop 2: Hoa don sai thong tin, ngan hang khong ton tai");
        HoaDonDAOTest instance = new HoaDonDAOTest();
        instance.testThemHoaDonException2();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testThemHoaDonException3 method, of class HoaDonDAOTest.
     */
    @Test
    public void testTestThemHoaDonException3() {
        System.out.println("Truong hop 3: Hoa don khong thanh toan cho bat ky dot thue nao");
        HoaDonDAOTest instance = new HoaDonDAOTest();
        instance.testThemHoaDonException3();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testThemHoaDonException4 method, of class HoaDonDAOTest.
     */
    @Test
    public void testTestThemHoaDonException4() {
        System.out.println("Truong hop 4: Hoa don cho 1 ky dong thue.");
        HoaDonDAOTest instance = new HoaDonDAOTest();
        instance.testThemHoaDonException4();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testThemHoaDonException5 method, of class HoaDonDAOTest.
     */
    @Test
    public void testTestThemHoaDonException5() {
        System.out.println("Truong hop 5: Hoa don cho nhieu hon 1 ky dong thue");
        HoaDonDAOTest instance = new HoaDonDAOTest();
        instance.testThemHoaDonException5();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
