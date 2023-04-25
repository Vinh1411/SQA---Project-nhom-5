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
public class NguoiDungDAOTestTest {
    
    public NguoiDungDAOTestTest() {
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
     * Test of testDangNhapException1 method, of class NguoiDungDAOTest.
     */
    @Test
    public void testTestDangNhapException1() {
        System.out.println("Truong hop 1: Dang nhap thanh cong.");
        NguoiDungDAOTest instance = new NguoiDungDAOTest();
        instance.testDangNhapException1();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testDangNhapException2 method, of class NguoiDungDAOTest.
     */
    @Test
    public void testTestDangNhapException2() {
        System.out.println("Truong hop 2: Dang nhap that bai.");
        NguoiDungDAOTest instance = new NguoiDungDAOTest();
        instance.testDangNhapException2();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testDangKiException1 method, of class NguoiDungDAOTest.
     */
    @Test
    public void testTestDangKiException1() {
        System.out.println("Truong hop 3: Tao tai khoan thanh cong.");
        NguoiDungDAOTest instance = new NguoiDungDAOTest();
        instance.testDangKiException1();
    }

    /**
     * Test of testDangKiException2 method, of class NguoiDungDAOTest.
     */
    @Test
    public void testTestDangKiException2() {
        System.out.println("Truong hop 4: Tao tai khoan that bai.");
        NguoiDungDAOTest instance = new NguoiDungDAOTest();
        instance.testDangKiException2();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testDangNhapException3 method, of class NguoiDungDAOTest.
     */
    @Test
    public void testTestDangNhapException3() {
        System.out.println("Truong hop 5: Tai khoan chua duoc kich hoat");
        NguoiDungDAOTest instance = new NguoiDungDAOTest();
        instance.testDangNhapException3();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
