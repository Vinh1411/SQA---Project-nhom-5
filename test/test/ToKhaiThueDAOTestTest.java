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
public class ToKhaiThueDAOTestTest {
    
    public ToKhaiThueDAOTestTest() {
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
     * Test of testDSToKhaiChuaDongException1 method, of class ToKhaiThueDAOTest.
     */
    @Test
    public void testTestDSToKhaiChuaDongException1() {
        System.out.println("Truong hop 1: Nguoi dung khong ton tai trong he thong");
        ToKhaiThueDAOTest instance = new ToKhaiThueDAOTest();
        instance.testDSToKhaiChuaDongException1();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of testDSToKhaiChuaDongException2 method, of class ToKhaiThueDAOTest.
     */
    @Test
    public void testTestDSToKhaiChuaDongException2() {
        System.out.println("Truong hop 2: Nguoi dung ton tai, nhung khong khai bao thue tren he thong");
        ToKhaiThueDAOTest instance = new ToKhaiThueDAOTest();
        instance.testDSToKhaiChuaDongException2();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of testDSToKhaiChuaDongException3 method, of class ToKhaiThueDAOTest.
     */
    @Test
    public void testTestDSToKhaiChuaDongException3() {
        System.out.println("Truong hop 3: Nguoi dung ton tai, nhung da dong het cac khoan thue no");
        ToKhaiThueDAOTest instance = new ToKhaiThueDAOTest();
        instance.testDSToKhaiChuaDongException3();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testDSToKhaiChuaDongException4 method, of class ToKhaiThueDAOTest.
     */
    

    @Test
    public void testTestDSToKhaiChuaDongException4() {
        System.out.println("Truong hop 4: Nguoi dung ton tai, co 1 khoan thue no chua dong");
        ToKhaiThueDAOTest instance = new ToKhaiThueDAOTest();
        instance.testDSToKhaiChuaDongException4();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of testDSToKhaiChuaDongException5 method, of class ToKhaiThueDAOTest.
     */

    @Test
    public void testTestDSToKhaiChuaDongException5() {
        System.out.println("Truong hop 5: Nguoi dung ton tai, co nhieu hon 1 khoan the no chua dong");
        ToKhaiThueDAOTest instance = new ToKhaiThueDAOTest();
        instance.testDSToKhaiChuaDongException5();
        // TODO review the generated test code and remove the default call to fail.
        
    }  

    /**
     * Test of testLayThongTinToKhaiThueException1 method, of class ToKhaiThueDAOTest.
     */
    @Test
    public void testTestLayThongTinToKhaiThueException1() {
        System.out.println("Truong hop 1: To khai thue khong ton tai");
        ToKhaiThueDAOTest instance = new ToKhaiThueDAOTest();
        instance.testLayThongTinToKhaiThueException1();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of testLayThongTinToKhaiThueException2 method, of class ToKhaiThueDAOTest.
     */
    @Test
    public void testTestLayThongTinToKhaiThueException2() {
        System.out.println("Truong hop 2: To khai thue ton tai");
        ToKhaiThueDAOTest instance = new ToKhaiThueDAOTest();
        instance.testLayThongTinToKhaiThueException2();
        // TODO review the generated test code and remove the default call to fail.
    }
}
